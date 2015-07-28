package br.com.lowestprice.view.activity;

import android.view.Menu;

import br.com.androidcore.activity.BaseActivity;
import br.com.lowestprice.R;

/**
 * Created by Gilson Maciel on 21/07/2015.
 */
public class RegistrationActivity extends BaseActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }

    @Override
    public void setViewValues() {
        this.showActionBarBackButton();
    }

    @Override
    public void setViewListener() {
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_registration;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(R.anim.left_slide_in,
                R.anim.right_slide_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
