import android.content.Intent;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.robolectric.Shadows;
import org.robolectric.util.FragmentTestUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.view.activity.PromotionAddActivity;
import br.com.lowestprice.view.fragment.HomeFragment;

/**
 * Created by Gilson Maciel on 02/08/2015.
 */
public class HomeFragmentTest extends BaseTest {
    HomeFragment fragment;

    @Override
    public void setup() {
        fragment = new HomeFragment();
        FragmentTestUtil.startFragment(fragment);
    }

    @Test
    public void addButtonOpensPromotionAddActivity() {
        fragment.getBtnAdd().performClick();

        Intent expectedIntent = new Intent(fragment.getActivity(), PromotionAddActivity.class);
        Assertions.assertThat(Shadows.shadowOf(fragment.getActivity()).getNextStartedActivity())
                .isEqualTo(expectedIntent);
    }

    @Test
    public void listViewMustShowMaximumThreePromotions() {
        List<Promotion> promotions = new ArrayList<>();
        Promotion promo1 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo2 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo3 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo4 = new Promotion("", 1.98, new Date(), "", "");
        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);
        promotions.add(promo4);

        fragment.renderPromotionList(promotions);
        Assertions.assertThat(fragment.getPromotionListView()
                .getAdapter().getCount()).isEqualTo(3);
    }



    @Override
    public void tearDown() {
        fragment = null;
    }
}
