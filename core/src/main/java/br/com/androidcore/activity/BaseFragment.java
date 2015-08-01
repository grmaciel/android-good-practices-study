package br.com.androidcore.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.androidcore.util.DialogUtil;

public abstract class BaseFragment extends Fragment {
    public abstract void setViewValues(Bundle savedInstanceState);

    protected abstract int getLayoutFile();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutFile(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViewValues(savedInstanceState);
    }

    protected void onException(Exception e) {
        DialogUtil.showOKDialog(getActivity(), null, e.getMessage());
    }

}
