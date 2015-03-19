package com.example.romain.applisport;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends AbstractNavDrawerActivity{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
        }
    }

        @Override
        protected NavDrawerActivityConfiguration getNavDrawerConfiguration() {

            NavDrawerItem[] menu = new NavDrawerItem[] {
                    NavMenuSection.create( 100, "Demos"),
                    NavMenuItem.create(101,"List/Detail (Fragment)", "navdrawer_friends", false, this),
                    NavMenuItem.create(102, "Airport (AsyncTask)", "navdrawer_airport", true, this),
                    NavMenuSection.create(200, "General"),
                    NavMenuItem.create(202, "Rate this app", "navdrawer_rating", false, this),
                    NavMenuItem.create(203, "Eula", "navdrawer_eula", false, this),
                    NavMenuItem.create(204, "Quit", "navdrawer_quit", false, this)};

            NavDrawerActivityConfiguration navDrawerActivityConfiguration = new NavDrawerActivityConfiguration();
            navDrawerActivityConfiguration.setMainLayout(R.layout.activity_main);
            navDrawerActivityConfiguration.setDrawerLayoutId(R.id.drawer_layout);
            navDrawerActivityConfiguration.setLeftDrawerId(R.id.left_drawer);
            navDrawerActivityConfiguration.setNavItems(menu);
            navDrawerActivityConfiguration.setDrawerShadow(R.drawable.drawer_shadow);
            navDrawerActivityConfiguration.setDrawerOpenDesc(R.string.drawer_open);
            navDrawerActivityConfiguration.setDrawerCloseDesc(R.string.drawer_close);
            navDrawerActivityConfiguration.setBaseAdapter(
                    new NavDrawerAdapter(this, R.layout.navdrawer_item, menu ));
            return navDrawerActivityConfiguration;
        }

        @Override
        protected void onNavItemSelected(int id) {
            switch ((int)id) {
                case 101:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FriendMainFragment()).commit();
                    break;
                case 102:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new AirportFragment()).commit();
                    break;
            }
        }
}