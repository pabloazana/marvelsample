package com.pabloazana.marvelsample.views.activities;

import android.os.Bundle;

import com.pabloazana.marvelsample.R;


public class StartingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_starting;
    }
}