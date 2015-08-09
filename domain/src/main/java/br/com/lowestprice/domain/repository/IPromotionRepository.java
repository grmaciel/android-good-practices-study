package br.com.lowestprice.domain.repository;

import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import rx.Observable;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public interface IPromotionRepository extends IRepository<Promotion, Long> {
    public Observable<List<Promotion>> queryLastestPromotion(int maxResults);
}
