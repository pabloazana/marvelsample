package com.pabloazana.marvelsample.viewPresenters.views.fragments;

import android.os.Bundle;
import android.util.Log;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.viewPresenters.presenters.FeaturedPresenter;

/**
 * Created by pablo-azana on 8/05/15.
 */

public class FeaturedView extends BaseFragment<FeaturedPresenter>{

    public static final String SCREEN_TAG = "featured_view";

    public static FeaturedView newInstance(){
        return new FeaturedView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screen_tag = SCREEN_TAG;
    }

    @Override
    protected FeaturedPresenter getPresenter() {
        return new FeaturedPresenter();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_starting;
    }

    @Override
    protected void setupToolbar() {
        mainActivity.getToolBar().setTitle("Featured");
        mainActivity.getToolBar().setNavigationIcon(R.drawable.ic_drawer_new);
    }
}
