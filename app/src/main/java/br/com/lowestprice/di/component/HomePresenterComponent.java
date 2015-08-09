package br.com.lowestprice.di.component;

import br.com.lowestprice.di.module.PerActivity;
import br.com.lowestprice.di.module.HomePresenterModule;
import br.com.lowestprice.view.activity.MainActivity;
import br.com.lowestprice.view.fragment.HomeFragment;
import dagger.Component;

/**
 * Created by Gilson Maciel on 06/08/2015.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {
                HomePresenterModule.class
        })
public interface HomePresenterComponent {
    void inject(HomeFragment fragment);
}
