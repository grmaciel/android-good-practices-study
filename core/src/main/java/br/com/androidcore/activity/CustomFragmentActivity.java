package br.com.androidcore.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;

import br.com.androidcore.util.DialogUtil;

public abstract class CustomFragmentActivity extends FragmentActivity {
    public abstract int getLayoutFile();

    public abstract void setViewListener();

    public abstract void setViewValues(Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutFile());
        setViewListener();
        setViewValues(savedInstanceState);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
            default:
                Log.d("", "ID: " + item.getItemId());
                return super.onOptionsItemSelected(item);
        }
    }

    public void showActionBarBackButton() {
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    public void hideActionBarBackButton() {
        getActionBar().setDisplayShowHomeEnabled(false);
    }

    @SuppressWarnings("unchecked")
    public <T> T findView(int resId) {
        return (T) this.findViewById(resId);
    }

    protected void onException(Exception e) {
        DialogUtil.showOKDialog(this, null, e.getMessage());
    }
}
