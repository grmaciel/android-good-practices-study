package br.com.lowestprice.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.androidcore.adapter.CustomAdapter;
import br.com.lowestprice.domain.model.Promotion;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class PromotionAdapter extends CustomAdapter<Promotion> {
    public PromotionAdapter(List<Promotion> data) {
        super(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Promotion getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
