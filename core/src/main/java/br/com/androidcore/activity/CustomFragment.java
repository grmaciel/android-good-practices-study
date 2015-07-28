package br.com.androidcore.activity;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.androidcore.util.DialogUtil;

public abstract class CustomFragment extends Fragment {
    public abstract void setViewValues(Bundle savedInstanceState);

    protected abstract void setViewListener();

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
        setViewListener();
    }

    @SuppressWarnings("unchecked")
    public <T> T findViewById(int resId) {
        return (T) this.getView().findViewById(resId);
    }

    public void showActionBarBackButton() {
//		getActivity().getS().show();
//		getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void onException(Exception e) {
        DialogUtil.showOKDialog(getActivity(), null, e.getMessage());
    }

}
