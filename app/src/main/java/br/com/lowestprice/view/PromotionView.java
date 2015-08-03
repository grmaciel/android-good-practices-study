package br.com.lowestprice.view;

import java.util.List;

import br.com.lowestprice.domain.model.Promotion;

/**
 * Created by Gilson Maciel on 30/07/2015.
 */
public interface PromotionView extends LoadDataView {
    void renderPromotionList(List<Promotion> promotions);

    void showPromotionRegistration();

    void viewPromotion();

    void addNewPromotion();
}
