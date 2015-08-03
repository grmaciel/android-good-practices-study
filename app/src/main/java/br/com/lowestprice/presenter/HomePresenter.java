package br.com.lowestprice.presenter;

import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.location.places.Place;

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

    public List<Promotion> getLastTwoPromotions() {
        return null;
    }

    public void getNearPromotionPlaces() {
    }

    public void onBtnAddPromotion() {
        this.view.showPromotionRegistration();
    }

    public void onPlacePickerResult(Place place) {
    }

    public void actionOnNewPromotion(Promotion promotion) {

    }
}
