package br.com.lowestprice.presenter;

import com.google.android.gms.analytics.ecommerce.Promotion;

import java.util.List;

import br.com.lowestprice.view.HomeView;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class HomePresenter implements Presenter {
    private final HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    public List<Promotion> getLastFourPromotions() {
        return null;
    }

    public void actionOnNewPromotion(Promotion promotion) {

    }
}
