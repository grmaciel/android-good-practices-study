package br.com.lowestprice.view.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.androidcore.activity.BaseCompatActivity;
import br.com.lowestprice.R;
import br.com.lowestprice.view.adapter.NavigationAdapter;
import br.com.lowestprice.view.fragment.HomeFragment;
import br.com.lowestprice.view.model.EnumMenuSections;
import br.com.lowestprice.view.model.SecaoMenuItem;

/**
 * Created by Gilson Maciel on 26/07/2015.
 */
public class MainActivity extends BaseCompatActivity {
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setViewValues() {

        this.configureNavigationMenu();
        this.setupFragments();
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeAsUpIndicator(getResources()
                .getDrawable(R.drawable.ic_navigation));
    }

    @Override
    public int getLayoutFile() {
        return R.layout.activity_main;
    }

    private Fragment getHomeFragment() {
        return new HomeFragment();
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

    public void onMenuClickListener(int position) {
        Toast.makeText(this, "AAAA", Toast.LENGTH_LONG).show();
    }

    private void setupMenuItens() {
        NavigationAdapter adapter = new NavigationAdapter(getMenuItens());
        ListView menuListview = this.findCustomViewById(R.id.navigationMenu);
        menuListview.setAdapter(adapter);
        menuListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuClickListener(position);
            }
        });

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

    /**
     * This will give us our menus, their labels and their icons
     *
     * @return
     */
    public List<SecaoMenuItem> getMenuItens() {
        List<SecaoMenuItem> menu = new ArrayList<>();

        SecaoMenuItem menu1 = new SecaoMenuItem();
        menu1.icon = getResources().getDrawable(R.drawable.profile);
        menu1.label = "Gilson Maciel";
        menu1.secao = EnumMenuSections.PROFILE;

        SecaoMenuItem menu2 = new SecaoMenuItem();
        menu2.icon = getResources().getDrawable(R.drawable.ic_home);
        menu2.label = getString(R.string.home);
        menu2.secao = EnumMenuSections.HOME;

        SecaoMenuItem menu3 = new SecaoMenuItem();
        menu3.icon = getResources().getDrawable(R.drawable.ic_promotion);
        menu3.label = getString(R.string.promocoes);
        menu3.secao = EnumMenuSections.PROMOTIONS;

        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        return menu;
    }
}
