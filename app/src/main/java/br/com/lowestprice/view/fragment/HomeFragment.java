package br.com.lowestprice.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.androidcore.activity.BaseFragment;
import br.com.lowestprice.R;
import br.com.lowestprice.di.AndroidApplication;
import br.com.lowestprice.di.component.DaggerHomePresenterComponent;
import br.com.lowestprice.di.module.HomePresenterModule;
import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.presenter.IHomePresenter;
import br.com.lowestprice.view.HomeView;
import br.com.lowestprice.view.PromotionView;
import br.com.lowestprice.view.activity.PromotionAddActivity;
import br.com.lowestprice.view.adapter.PromotionAdapter;
import br.com.lowestprice.view.components.RecyclerItemSeparator;
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

    @Bind(R.id.rootLayout)
    CoordinatorLayout rootView;

    @Bind(R.id.btnAddPromotion)
    FloatingActionButton btnAdd;

    @Bind(R.id.homePromotionList)
    RecyclerView promotionListView;

    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;

    private PromotionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setViewValues(Bundle savedInstanceState) {
        DaggerHomePresenterComponent.builder()
                .applicationComponent(((AndroidApplication) getActivity().getApplication()).component())
                .homePresenterModule(new HomePresenterModule(this))
                .build().inject(this);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        getPromotionRecyclerView().setLayoutManager(llm);
        getPromotionRecyclerView().addItemDecoration(new
                RecyclerItemSeparator(getResources()
                .getDrawable(R.drawable.list_item_separator)));
        getPromotionRecyclerView();
        this.adapter = new PromotionAdapter(getActivity(), new ArrayList<Promotion>());
        getPromotionRecyclerView().setAdapter(adapter);

        Snackbar.make(rootView, "Snackbar coordinator layout...", Snackbar.LENGTH_SHORT)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    @Override
    protected int getLayoutFile() {
        return R.layout.fragment_home;
    }

    @Override
    public void renderPromotionList(List<Promotion> promotions) {
        adapter.addData(promotions);
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
        this.rl_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
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

    public RecyclerView getPromotionRecyclerView() {
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
