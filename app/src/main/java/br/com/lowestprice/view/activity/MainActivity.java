package br.com.lowestprice.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import br.com.androidcore.activity.BaseCompatActivity;
import br.com.lowestprice.R;
import br.com.lowestprice.view.adapter.NavigationAdapter;
import br.com.lowestprice.view.fragment.HomeFragment;
import br.com.lowestprice.view.model.EnumSecaoMenu;
import br.com.lowestprice.view.model.SecaoMenuItem;
import butterknife.ButterKnife;

/**
 * Created by Gilson Maciel on 26/07/2015.
 */
public class MainActivity extends BaseCompatActivity {
    private final int PLACE_PICKER_REQUEST = 1;

    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    public void setViewValues() {
        ButterKnife.bind(this);
        this.configureNavigationMenu();
        this.setupFragments();
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(getResources()
                .getDrawable(R.drawable.ic_navigation));
    }

    private void configureNavigationMenu() {
        this.inflateDrawerLayout();
        this.createDrawerToggle();
        this.createMenuView();
        this.setupMenuItens();
    }

    private void inflateDrawerLayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.drawerLayout = (DrawerLayout) inflater.inflate(R.layout.navigation, null); // "null" is important.
    }

    private void createMenuView() {
        FrameLayout container = (FrameLayout) drawerLayout.findViewById(R.id.container);
        /**
         * Getting the top view hierarchy to make sure our navigation bar
         * goes on top of the action bar
         */
        ViewGroup decor = (ViewGroup) this.getWindow().getDecorView();
        View child = decor.getChildAt(0);
        decor.removeView(child);

        container.addView(child);

        // Make the drawer replace the first child
        decor.addView(drawerLayout);
    }

    private void createDrawerToggle() {
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.drawable.ic_navigation,
                R.string.login,
                R.string.login);
    }


    private void setupMenuItens() {
        NavigationAdapter adapter = new NavigationAdapter(getMenuItens());
        ListView menuListview = this.findCustomViewById(R.id.navigationMenu);
        menuListview.setAdapter(adapter);
//        menuListview.setOnItemClickListener(itemClickListener);

        int width = this.getResources().getDisplayMetrics().widthPixels / 2;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) menuListview.getLayoutParams();
        params.width = (int) (width + width * .5);

        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private void setupFragments() {
        FragmentManager fragManager = getFragmentManager();

        FragmentTransaction fragTrans = fragManager.beginTransaction();
        fragTrans.replace(R.id.sessionMain, getHomeFragment());
        fragTrans.commit();
    }

    public void actionOnAddPromotionClick() {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(getApplicationContext()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
//                this.place = place.getName();
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

    public FloatingActionButton getBtnAdd() {
        return null;
    }

    public Fragment getHomeFragment() {
        return new HomeFragment();
    }

    /**
     * This will give us our menus, their labels and their icon
     * @return
     */
    private List<SecaoMenuItem> getMenuItens() {
        List<SecaoMenuItem> menu = new ArrayList<>();

        SecaoMenuItem menu1 = new SecaoMenuItem();
        menu1.icon = getResources().getDrawable(R.drawable.profile);
        menu1.label = "Gilson Maciel";
        menu1.secao = EnumSecaoMenu.PERFIL;

        menu.add(menu1);

        return menu;
    }
}
