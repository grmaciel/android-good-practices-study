package br.com.lowestprice.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gilson Maciel on 11/08/2015.
 */
public class LocationService extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private final String LOG_TAG = this.getClass().getSimpleName();
    private final long LOCATION_UPDATE_INTERVAL = TimeUnit.MINUTES.toMillis(2);
    private GoogleApiClient apiClient;

    @Override
    public void onCreate() {
        Log.d(LOG_TAG, "Location service created");
        this.initializeGoogleApiClient();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        apiClient.connect();

        return Service.START_STICKY;
    }

    private void initializeGoogleApiClient() {
        if (this.apiClient == null) {
            this.apiClient = new GoogleApiClient.Builder(getApplicationContext())
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onConnected(Bundle bundle) {
        this.requestLocationUpdates();
    }

    private void requestLocationUpdates() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        locationRequest.setInterval(LOCATION_UPDATE_INTERVAL);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                this.apiClient,
                locationRequest,
                this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(LOG_TAG, "Location changed: " + location);
    }
}
