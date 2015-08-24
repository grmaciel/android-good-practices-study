import android.content.Intent;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.robolectric.Shadows;
import org.robolectric.util.FragmentTestUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.lowestprice.domain.model.Promotion;
import br.com.lowestprice.repository.PromotionRepository;
import br.com.lowestprice.view.activity.PromotionAddActivity;
import br.com.lowestprice.view.fragment.HomeFragment;
import rx.observers.TestSubscriber;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
    public void adapterNotEmptyAfterRenderPromotionList() {
        List<Promotion> promotions = getFakePromotions();

        fragment.renderPromotionList(promotions);
        Assertions.assertThat(fragment.getPromotionListView()
                .getAdapter().getItemCount()).isGreaterThan(0);
    }

    private List<Promotion> getFakePromotions() {
        List<Promotion> promotions = new ArrayList<>();
        Promotion promo1 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo2 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo3 = new Promotion("", 1.98, new Date(), "", "");
        Promotion promo4 = new Promotion("", 1.98, new Date(), "", "");
        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);
        promotions.add(promo4);
        return promotions;
    }

    @Test
    public void promotionRepositoryShouldReturnToSubscriber() {
        PromotionRepository repo = new PromotionRepository();
        TestSubscriber<List<Promotion>> testSubscriber = new TestSubscriber<>();
        repo.queryLastestPromotion(3).subscribe(testSubscriber);

        testSubscriber.assertValues(repo.getFakePromotions(), repo.getFakeServerPromotions());
        testSubscriber.assertNoErrors();
        assertThat(testSubscriber.getOnNextEvents().size(), is(2));
    }

    @Override
    public void tearDown() {
        fragment = null;
    }
}
