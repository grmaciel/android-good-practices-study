package br.com.lowestprice.repository.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.domain.repository.IPromotionRepository;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class PromotionRepository implements IPromotionRepository {
    @Override
    public List<Promotion> queryLastestPromotion(int maxResults) {
        List<Promotion> promotions = new ArrayList<>();
        Promotion promo1 = new Promotion("Cerveja Brahma", 1.45, new Date(), "Angeloni", "");
        Promotion promo2 = new Promotion("Vinho Casillero del Diablop", 21.99, new Date(), "Giassi", "");
        Promotion promo3 = new Promotion("Cerveja Skol", 1.78, new Date(), "Cooper", "");
        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);

        return promotions;
    }

    @Override
    public List<Promotion> queryAll() {
        return null;
    }

    @Override
    public Promotion findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Promotion entity) {

    }

    @Override
    public void delete(Promotion entity) {

    }
}
