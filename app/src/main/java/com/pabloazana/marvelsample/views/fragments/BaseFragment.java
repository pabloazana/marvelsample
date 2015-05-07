package com.pabloazana.marvelsample.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.views.presenters.BasePresenter;

/**
 * Created by pablo-azana on 8/05/15.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;
    protected String screen_tag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    protected abstract P getPresenter();

    protected abstract int getFragmentLayout();





}
