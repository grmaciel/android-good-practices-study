package br.com.lowestprice.di;

import android.app.Application;

import br.com.lowestprice.di.component.ApplicationComponent;
import br.com.lowestprice.di.component.DaggerApplicationComponent;
import br.com.lowestprice.di.module.ApplicationModule;

/**
 * /**
 * Created by Gilson Maciel on 09/07/2015.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializaInjector();
    }

    private void initializaInjector() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent component() {
        return component;
    }
}
