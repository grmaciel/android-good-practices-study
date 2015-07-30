import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import br.com.lowestprice.BuildConfig;

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
}
