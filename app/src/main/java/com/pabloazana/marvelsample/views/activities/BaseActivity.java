package com.pabloazana.marvelsample.views.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.pabloazana.marvelsample.R;

/**
 * Created by pablo-azana on 7/05/15.
 */

public abstract class BaseActivity extends ActionBarActivity{

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initializeToolbar();
    }

    private void initializeToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar_main_layout);
        setSupportActionBar(toolbar);
    }

    public Toolbar getToolBar(){
        return toolbar;
    }

    public abstract int getContentLayout();

}
