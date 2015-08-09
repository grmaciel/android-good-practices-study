package br.com.lowestprice.di.component;

import br.com.lowestprice.di.module.PerActivity;
import dagger.Component;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent {
}
