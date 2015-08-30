package br.com.androidcore.adapter;

import android.view.View;

/**
 * Created by Gilson Maciel on 30/08/2015.
 */
public interface IOnItemClickListener<T> {
    void onClick(View view, T data);
}
