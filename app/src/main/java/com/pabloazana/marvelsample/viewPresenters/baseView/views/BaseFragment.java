package com.pabloazana.marvelsample.viewPresenters.baseView.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.viewPresenters.startingView.views.StartingActivity;
import com.pabloazana.marvelsample.viewPresenters.baseView.presenters.BasePresenter;

/**
 * Created by pablo-azana on 8/05/15.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;
    protected String screen_tag;
    public StartingActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (StartingActivity)getActivity();
        presenter = getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.retrieveData();
    }

    @Override
    public void onResume() {
        super.onResume();
        setupToolbar();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    protected abstract P getPresenter();

    protected abstract int getFragmentLayout();

    protected abstract void setupToolbar();





}
