package com.pabloazana.marvelsample.views.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.pabloazana.marvelsample.views.fragments.NavigationDrawerFragment;

/**
 * Created by pablo-azana on 7/05/15.
 */

public abstract class BaseActivity extends ActionBarActivity{


    protected NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    public abstract int getContentLayout();

    public abstract int getNavDrawerLayout();

}
