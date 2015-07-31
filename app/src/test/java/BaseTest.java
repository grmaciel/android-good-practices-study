import android.app.Activity;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import br.com.lowestprice.BuildConfig;
import br.com.lowestprice.view.activity.LoginActivity;

/**
 * Created by Gilson Maciel on 18/07/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public abstract class BaseTest {
    @Before
    public abstract void setup();

    @After
    public abstract void tearDown();

    public <T extends Activity> T getActivity(Class<T> activityClass) {
        return Robolectric.setupActivity(activityClass);
    }
}
