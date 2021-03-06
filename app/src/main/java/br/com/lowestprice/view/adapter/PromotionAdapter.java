package br.com.lowestprice.view.adapter;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.androidcore.adapter.CustomRecyclerAdapter;
import br.com.androidcore.adapter.IOnItemClickListener;
import br.com.lowestprice.R;
import br.com.lowestprice.domain.model.Promotion;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class PromotionAdapter extends CustomRecyclerAdapter<Promotion, PromotionAdapter.ViewHolder> {

    private final Context context;
    private int lastPosition = -1;
    private IOnItemClickListener<Promotion> clickListener;

    public PromotionAdapter(Context context, List<Promotion> data,
                            IOnItemClickListener<Promotion> clickListener) {
        super(data);
        this.context = context;
        this.clickListener = clickListener;
    }

    @Override
    public Promotion getItem(int position) {
        return data.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.promotion_item, viewGroup, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Promotion promo = this.getItem(i);

        viewHolder.productName.setText(promo.getProductName());
        viewHolder.price.setText(String.valueOf(promo.getProductPrice()));
        viewHolder.place.setText(promo.getPlaceName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(viewHolder.image, promo);
            }
        });

//        this.setAnimation(viewHolder.container, i);
    }

    private void setAnimation(View container, int i) {
        Animation anim = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        container.startAnimation(anim);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.promotionProductImg)
        ImageView image;
        @Bind(R.id.promotionLayoutContainer)
        RelativeLayout container;
        @Bind(R.id.promotionProductName)
        TextView productName;
        @Bind(R.id.promotionProductPlace)
        TextView place;
        @Bind(R.id.promotionProductPrice)
        TextView price;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
