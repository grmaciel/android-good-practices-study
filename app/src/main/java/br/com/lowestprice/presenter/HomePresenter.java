package br.com.lowestprice.presenter;

import com.google.android.gms.location.places.Place;

import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.domain.repository.IPromotionRepository;
import br.com.lowestprice.repository.database.PromotionRepository;
import br.com.lowestprice.view.HomeView;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class HomePresenter implements IHomePresenter {
    private final HomeView view;
    // Dagger 2 injection
    private IPromotionRepository promotionRepository = new PromotionRepository();

    public HomePresenter(HomeView view) {
        this.view = view;
        view.renderPromotionList(getLastThreePromotions());
    }

    private List<Promotion> getLastThreePromotions() {
        return promotionRepository.queryLastestPromotion(3);
    }

    public void getNearPromotionPlaces() {
    }

    public void onBtnAddPromotion() {
        this.view.showPromotionRegistration();
    }

    public void onPlacePickerResult(Place place) {
    }

    public void onNewPromotion(Promotion promotion) {

    }
}
