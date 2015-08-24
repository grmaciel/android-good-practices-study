package br.com.lowestprice.presenter;

import br.com.lowestprice.view.PromotionView;

/**
 * Created by Gilson Maciel on 30/07/2015.
 */
public class PromotionPresenter implements Presenter {
    private final PromotionView view;

    public PromotionPresenter(PromotionView view) {
        this.view = view;
    }

    public void loadPromotions() {
        this.view.showLoading();
        this.loadPromotionsData();
    }

    public void loadPromotionsData() {

    }
}
