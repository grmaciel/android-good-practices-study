package br.com.lowestprice.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.androidcore.adapter.CustomAdapter;
import br.com.lowestprice.R;
import br.com.lowestprice.domain.model.Promotion;
import butterknife.Bind;
import butterknife.ButterKnife;

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
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.promotion_item, null);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Promotion promo = this.getItem(position);

        holder.productName.setText(promo.getProductName());
        holder.price.setText(String.valueOf(promo.getProductPrice()));
        holder.place.setText(promo.getPlaceName());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.promotionProductName)
        TextView productName;
        @Bind(R.id.promotionProductPlace)
        TextView place;
        @Bind(R.id.promotionProductPrice)
        TextView price;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
