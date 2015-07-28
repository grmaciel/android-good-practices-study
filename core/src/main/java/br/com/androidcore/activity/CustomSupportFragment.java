package br.com.androidcore.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.androidcore.util.DialogUtil;

/**
 * Created by Gilson Maciel on 01/03/2015.
 */
public abstract class CustomSupportFragment extends Fragment {
    public abstract void setViewValues(Bundle savedInstanceState);

    public abstract void setViewListener();

    public abstract int getLayoutFile();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutFile(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViewValues(savedInstanceState);
        setViewListener();
    }

    public void showActionBarBackButton() {
//        getSu
    }

    @SuppressWarnings("unchecked")
    public <T> T findViewById(int resId) {
        return (T) this.getView().findViewById(resId);
    }

    protected void onException(Exception e) {
        DialogUtil.showOKDialog(getActivity(), null, e.getMessage());
    }
}
