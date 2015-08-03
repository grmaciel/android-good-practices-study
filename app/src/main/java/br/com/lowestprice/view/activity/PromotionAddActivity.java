package br.com.lowestprice.view.activity;

import br.com.androidcore.activity.BaseCompatActivity;
import br.com.lowestprice.R;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class PromotionAddActivity extends BaseCompatActivity {
    @Override
    public void setViewValues() {
        this.showActionBarBackButton();
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_promotion_add;
    }
}
