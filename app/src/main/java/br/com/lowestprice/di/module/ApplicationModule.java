package br.com.lowestprice.di.module;

import android.content.Context;

import javax.inject.Singleton;

import br.com.lowestprice.di.AndroidApplication;
import br.com.lowestprice.domain.repository.IPromotionRepository;
import br.com.lowestprice.repository.PromotionRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Gilson Maciel on 04/08/2015.
 */

/**
 * Module to provide objects that will live during the application lifecycle
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;
    PromotionRepository promotionRepository = new PromotionRepository();

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton IPromotionRepository providePromotionRepository() {
        return promotionRepository;
    }
}
