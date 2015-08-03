package br.com.lowestprice.view.fragment;

import android.app.Fragment;
import android.os.Bundle;


import java.util.List;

import br.com.androidcore.activity.BaseFragment;
import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.view.PromotionView;

/**
 * Created by Gilson Maciel on 30/07/2015.
 */
public class PromotionListFragment extends BaseFragment implements PromotionView {

    @Override
    public void renderPromotionList(List<Promotion> promotions) {

    }

    @Override
    public void showPromotionRegistration() {

    }

    @Override
    public void viewPromotion() {

    }

    @Override
    public void addNewPromotion() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void setViewValues(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutFile() {
        return 0;
    }
}
