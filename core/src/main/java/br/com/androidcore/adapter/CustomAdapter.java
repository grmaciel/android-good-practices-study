package br.com.androidcore.adapter;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Gilson Maciel on 21/02/2015.
 */
public abstract class CustomAdapter<T> extends BaseAdapter {
    protected final List<T> data;

    protected CustomAdapter(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public abstract T getItem(int position);
}
