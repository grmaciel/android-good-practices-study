package br.com.lowestprice.view;

import com.google.android.gms.analytics.ecommerce.Promotion;

import java.util.List;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public interface HomeView extends LoadDataView {
    void renderPromotionList(List<Promotion> promotions);
}
