package br.com.lowestprice.view.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import com.google.android.gms.analytics.ecommerce.Promotion;

import java.util.List;

import br.com.androidcore.activity.BaseFragment;
import br.com.lowestprice.R;
import br.com.lowestprice.view.HomeView;
import butterknife.Bind;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class HomeFragment extends BaseFragment implements HomeView {
    private final int PLACE_PICKER_REQUEST = 1;

    @Bind(R.id.btnAddPromotion)
    FloatingActionButton btnAdd;


    @Override
    public void setViewValues(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutFile() {
        return R.layout.fragment_home;
    }

    @Override
    public void renderPromotionList(List<Promotion> promotions) {

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
}
