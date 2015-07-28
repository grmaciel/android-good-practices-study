package br.com.lowestprice.view.activity;

import android.content.Intent;
import android.widget.Button;

import br.com.androidcore.activity.BaseActivity;
import br.com.lowestprice.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Gilson Maciel on 26/07/2015.
 */
public class LoginActivity extends BaseActivity {
    @Bind(R.id.loginBtnRegister)
    Button btnRegisterEmail;
    @Bind(R.id.loginBtnRegisterFacebook)
    Button btnRegisterFb;
    @Bind(R.id.loginBtnLogin)
    Button btnAccountLogin;

    @Override
    public void setViewValues() {
        this.hideActionBar();
        ButterKnife.bind(this);
    }

    @Override
    public void setViewListener() {

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
//        Intent intent = new Intent(this, RegistrationActivity.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
    }
}
