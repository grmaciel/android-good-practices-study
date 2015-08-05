package br.com.lowestprice.di.module;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Gilson Maciel on 14/07/2015.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
