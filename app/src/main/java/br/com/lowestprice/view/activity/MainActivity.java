package br.com.lowestprice.view.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import br.com.androidcore.activity.BaseCompatActivity;
import br.com.lowestprice.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Gilson Maciel on 26/07/2015.
 */
public class MainActivity extends BaseCompatActivity {
    private final int PLACE_PICKER_REQUEST = 1;

    @Bind(R.id.btnAddPromotion)
    FloatingActionButton btnAdd;
    private CharSequence place;

    @Override
    public void setViewValues() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAddPromotion)
    public void actionOnAddPromotionClick() {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(getApplicationContext()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                this.place = place.getName();
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

    public FloatingActionButton getBtnAdd() {
        return btnAdd;
    }

    public CharSequence getPlace() {
        return place;
    }
}
