package br.com.androidcore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import br.com.androidcore.R;
import br.com.androidcore.util.DialogUtil;

/**
 * Created by Gilson Maciel on 28/07/2015.
 */
public abstract class BaseCompatActivity extends AppCompatActivity {
    public abstract void setViewValues();
    public abstract int getLayoutFile();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutFile());

        loadParams(savedInstanceState);
        setViewValues();
    }

    public void loadParams(Bundle savedInstanceState) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                this.hideActionBarBackButton();

                overridePendingTransition(R.anim.left_slide_in,
                        R.anim.right_slide_out);
            default:
                Log.d("", "ID: " + item.getItemId());
                return super.onOptionsItemSelected(item);
        }
    }

    public void hideActionBar() {
        getSupportActionBar().hide();
    }

    public void showActionBar() {
        getSupportActionBar().show();
    }

    public void showActionBarBackButton() {
        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back));
    }

    public void hideActionBarBackButton() {
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void hideKeyboard() {
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @SuppressWarnings("unchecked")
    public <T> T findCustomViewById(int resId) {
        return (T) this.findViewById(resId);
    }

    protected void onException(Exception e) {
        DialogUtil.showOKDialog(this, null, e.getMessage());
    }
}
