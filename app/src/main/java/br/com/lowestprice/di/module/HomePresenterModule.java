package br.com.lowestprice.di.module;

import br.com.lowestprice.domain.repository.IPromotionRepository;
import br.com.lowestprice.presenter.HomePresenter;
import br.com.lowestprice.presenter.IHomePresenter;
import br.com.lowestprice.view.HomeView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */
@Module
public class HomePresenterModule {
    private final HomeView homeView;

    public HomePresenterModule(HomeView homeView) {
        this.homeView = homeView;
    }

    @Provides HomeView provideHomeView() {
        return this.homeView;
    }

    @Provides @PerActivity IHomePresenter provideHomePresenter(IPromotionRepository repository) {
        return new HomePresenter(repository, homeView);
    }
}
