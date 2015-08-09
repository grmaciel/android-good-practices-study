import org.junit.Test;
import org.robolectric.Robolectric;

import br.com.lowestprice.view.activity.MainActivity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Gilson Maciel on 08/08/2015.
 */
public class MainActivityTest extends BaseTest {
    private MainActivity activity;

    @Override
    public void setup() {
        this.activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void menuItensShouldBeThree() {
        assertThat(this.activity.getMenuItens().size()).isEqualTo(3);
    }

    @Override
    public void tearDown() {
        this.activity = null;
    }
}
