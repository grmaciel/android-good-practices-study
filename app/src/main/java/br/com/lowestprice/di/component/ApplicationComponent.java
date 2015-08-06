package br.com.lowestprice.di.component;

import android.content.Context;

import javax.inject.Singleton;

import br.com.androidcore.activity.BaseActivity;
import br.com.lowestprice.di.module.ApplicationModule;
import br.com.lowestprice.di.module.PresenterModule;
import dagger.Component;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class
        })
public interface ApplicationComponent {
    Context context();
}
