package br.com.lowestprice.di.module;

import javax.inject.Singleton;

import br.com.lowestprice.presenter.HomePresenter;
import br.com.lowestprice.presenter.IHomePresenter;
import br.com.lowestprice.view.HomeView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */
@Module
public class PresenterModule {
    @Provides @Singleton IHomePresenter provideHomePresenter(HomeView view) {
        return new HomePresenter(view);
    }

}
