package br.com.lowestprice.presenter;

import com.google.android.gms.location.places.Place;

import java.util.List;

import javax.inject.Inject;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.domain.repository.IPromotionRepository;
import br.com.lowestprice.view.HomeView;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class HomePresenter implements IHomePresenter {
    private final HomeView view;
    private IPromotionRepository promotionRepository;

    @Inject
    public HomePresenter(IPromotionRepository promotionRepository, HomeView view) {
        this.view = view;
        this.promotionRepository = promotionRepository;
        this.loadLastestPromotions();
    }

    private void loadLastestPromotions() {
        this.view.showLoading();
        getLastThreePromotions();
    }

    /**
     * RxAndroid for querying our promotions
     */
    private void getLastThreePromotions() {
        this.promotionRepository.queryLastestPromotion(3)
                .subscribeOn(Schedulers.newThread())
                .subscribe(getPromotionObserver());
    }

    private Observer<List<Promotion>> getPromotionObserver() {
        return new Observer<List<Promotion>>() {
            @Override
            public void onCompleted() {
                view.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.toString());
            }

            @Override
            public void onNext(List<Promotion> promotions) {
                view.renderPromotionList(promotions);
            }
        };
    }

    public void onBtnAddPromotion() {
        this.view.showPromotionRegistration();
    }

    public void onPlacePickerResult(Place place) {
    }

    public void onNewPromotion(Promotion promotion) {

    }
}
