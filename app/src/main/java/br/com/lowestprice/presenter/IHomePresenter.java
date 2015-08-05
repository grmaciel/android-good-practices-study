package br.com.lowestprice.presenter;

import com.google.android.gms.location.places.Place;

import br.com.lowestprice.domain.model.Promotion;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */
public interface IHomePresenter extends Presenter {
    void onBtnAddPromotion();
    void onPlacePickerResult(Place place);
    void onNewPromotion(Promotion promotion);
}
