package br.com.lowestprice.view.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.androidcore.activity.BaseCompatActivity;
import br.com.lowestprice.R;
import br.com.lowestprice.presenter.IHomePresenter;
import br.com.lowestprice.service.LocationService;
import br.com.lowestprice.service.RegistrationIntentService;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Gilson Maciel on 26/07/2015.
 */
public class LoginActivity extends BaseCompatActivity {
    @Bind(R.id.loginBtnRegister)
    Button btnRegisterEmail;
    @Bind(R.id.loginBtnRegisterFacebook)
    Button btnRegisterFb;
    @Bind(R.id.loginBtnLogin)
    Button btnAccountLogin;

    private BroadcastReceiver receiver;

    @Inject
    IHomePresenter presenter;

    @Override
    public void setViewValues() {
        this.hideActionBar();
        ButterKnife.bind(this);
        this.registerGcmToken();
    }

    private void registerGcmToken() {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean("sentTokenToServer", false);
                if (sentToken) {
                    Toast.makeText(LoginActivity.this, "Gcm Sended", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Gcm Error", Toast.LENGTH_SHORT).show();
                }
            }
        };

        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,
                new IntentFilter("registrationComplete"));

    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        super.onPause();
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.loginBtnLogin)
    public void actionOnAccountLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.loginBtnRegister)
    public void actionOnRegister() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
    }

    public Button getBtnRegisterEmail() {
        return btnRegisterEmail;
    }

    public Button getBtnRegisterFb() {
        return btnRegisterFb;
    }

    public Button getBtnAccountLogin() {
        return btnAccountLogin;
    }
}
