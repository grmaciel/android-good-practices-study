package br.com.lowestprice.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.List;

import javax.inject.Inject;

import br.com.androidcore.activity.BaseFragment;
import br.com.lowestprice.R;
import br.com.lowestprice.di.AndroidApplication;
import br.com.lowestprice.di.component.DaggerActivityComponent;
import br.com.lowestprice.di.component.DaggerPresenterComponent;
import br.com.lowestprice.di.module.PresenterModule;
import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.presenter.HomePresenter;
import br.com.lowestprice.presenter.IHomePresenter;
import br.com.lowestprice.view.HomeView;
import br.com.lowestprice.view.PromotionView;
import br.com.lowestprice.view.activity.PromotionAddActivity;
import br.com.lowestprice.view.adapter.PromotionAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public class HomeFragment extends BaseFragment implements PromotionView, HomeView {
    @Inject
    IHomePresenter homePresenter;

    private final int PLACE_PICKER_REQUEST = 1;

    @Bind(R.id.btnAddPromotion)
    FloatingActionButton btnAdd;

    @Bind(R.id.homePromotionList)
    ListView promotionListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setViewValues(Bundle savedInstanceState) {
        DaggerPresenterComponent.builder()
                .applicationComponent(((AndroidApplication) getActivity().getApplication()).component())
                .presenterModule(new PresenterModule(this))
                .build().inject(this);
    }

    @Override
    protected int getLayoutFile() {
        return R.layout.fragment_home;
    }

    @Override
    public void renderPromotionList(List<Promotion> promotions) {
        // ugly thing, just trying out some robolectric tests
        if (promotions.size() > 3) {
            promotions = promotions.subList(0, 3);
        }

        getPromotionListView().setAdapter(new PromotionAdapter(promotions));
    }

    @Override
    public void showPromotionRegistration() {
        Intent intent = new Intent(getActivity(), PromotionAddActivity.class);
        startActivity(intent);
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
    public void renderPromotionPlaces() {

    }

    @Override
    public void showPlacePicker() {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btnAddPromotion)
    public void onAddPromotionClicked() {
        this.homePresenter.onBtnAddPromotion();
    }

    public FloatingActionButton getBtnAdd() {
        return btnAdd;
    }

    public ListView getPromotionListView() {
        return promotionListView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == getActivity().RESULT_OK) {
                this.homePresenter.onPlacePickerResult(PlacePicker.getPlace(data,
                        getActivity()));
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
