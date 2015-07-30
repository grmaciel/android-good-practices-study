import android.content.Intent;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;

import br.com.lowestprice.view.activity.LoginActivity;
import br.com.lowestprice.view.activity.RegistrationActivity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Gilson Maciel on 29/07/2015.
 */
public class LoginActivityTest extends BaseTest {
    private LoginActivity activity;

    @Override
    public void setup() {
        this.activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void resgiterButtonClickOpensRegisterActivity() {
        activity.getBtnRegisterEmail().performClick();

        Intent expectedIntent = new Intent(activity, RegistrationActivity.class);
        assertThat(Shadows.shadowOf(activity).getNextStartedActivity())
                .isEqualTo(expectedIntent);
    }

    @Override
    public void tearDown() {
        this.activity = null;
    }
}
