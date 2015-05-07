package com.pabloazana.marvelsample.views.fragments;

import android.os.Bundle;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.views.presenters.FeaturedPresenter;

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
}
