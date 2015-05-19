package com.pabloazana.marvelsample.viewPresenters.views.activities;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.FeaturedView;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.NavigationDrawerCallbacks;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.NavigationDrawerFragment;


public class StartingActivity extends BaseActivity implements NavigationDrawerCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(getNavDrawerLayout());
        mNavigationDrawerFragment.setUpNavigationDrawer(getNavDrawerLayout(), (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_starting;
    }

    @Override
    public int getNavDrawerLayout() {
        return R.id.navigation_drawer;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, FeaturedView.newInstance()).commit();
    }

}
