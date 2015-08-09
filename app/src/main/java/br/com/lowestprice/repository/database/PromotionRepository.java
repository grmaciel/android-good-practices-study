package br.com.lowestprice.repository.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.domain.repository.IPromotionRepository;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class PromotionRepository implements IPromotionRepository {

    /**
     * Perform a long operation to be used in the main thread
     * @param maxResults
     * @return
     */
    @Override
    public Observable<List<Promotion>> queryLastestPromotion(int maxResults) {
        return Observable.create(new Observable.OnSubscribe<List<Promotion>>() {
            @Override
            public void call(Subscriber<? super List<Promotion>> subscriber) {
                try {
                    // Long ass operation
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }

                subscriber.onNext(getFakePromotions());
                subscriber.onCompleted();
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    private List<Promotion> getFakePromotions() {
        List<Promotion> promotions = new ArrayList<>();
        Promotion promo1 = new Promotion("Cerveja Brahma", 1.45, new Date(), "Angeloni", "");
        Promotion promo2 = new Promotion("Vinho Casillero del Diablo", 21.99, new Date(), "Giassi", "");
        Promotion promo3 = new Promotion("Cerveja Skol", 1.78, new Date(), "Cooper", "");
        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);

        return promotions;
    }

    @Override
    public Observable<List<Promotion>> queryAll() {
        return null;
    }

    @Override
    public Observable<Promotion> findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Promotion entity) {
    }

    @Override
    public void delete(Promotion entity) {
    }
}
