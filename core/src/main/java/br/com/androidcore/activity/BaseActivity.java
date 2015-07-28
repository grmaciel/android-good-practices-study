package br.com.androidcore.activity;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;

import br.com.androidcore.R;
import br.com.androidcore.util.DialogUtil;

public abstract class BaseActivity extends Activity {
    public abstract void setViewValues();

    public abstract void setViewListener();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutFile());

        loadParams(savedInstanceState);
        setViewValues();
        setViewListener();
    }

    public abstract int getLayoutFile();

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
        getActionBar().hide();
    }

    public void showActionBar() {
        getActionBar().show();
    }

    public void showActionBarBackButton() {
        getActionBar().show();
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideActionBarBackButton() {
        getActionBar().hide();
        getActionBar().setDisplayHomeAsUpEnabled(false);
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
