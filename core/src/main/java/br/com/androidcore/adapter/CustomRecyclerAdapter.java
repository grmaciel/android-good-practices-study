package br.com.androidcore.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Gilson Maciel on 18/08/2015.
 */
public abstract class CustomRecyclerAdapter<U, T extends RecyclerView.ViewHolder> extends android.support.v7.widget.RecyclerView.Adapter<T> {
    protected List<U> data;

    protected CustomRecyclerAdapter(List<U> data) {
        this.data = data;
    }

    public List<U> getData() {
        return data;
    }

    public abstract U getItem(int position);

    public void addData(List<U> data) {
        this.data.clear();
        this.data.addAll(data);
        this.notifyDataSetChanged();
    }
}
