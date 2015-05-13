package com.pabloazana.marvelsample.viewPresenters.views.activities;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.FeaturedView;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.NavigationDrawerFragment;
import com.pabloazana.marvelsample.viewPresenters.views.fragments.NavigationDrawerFragment.NavigationDrawerCallbacks;


public class StartingActivity extends BaseActivity implements NavigationDrawerCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(getNavDrawerLayout());
        mNavigationDrawerFragment.setUp(getNavDrawerLayout(), (DrawerLayout) findViewById(R.id.drawer_layout));
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
        Log.d("Pablito", "Position: " + position);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, FeaturedView.newInstance()).commit();
    }

}
