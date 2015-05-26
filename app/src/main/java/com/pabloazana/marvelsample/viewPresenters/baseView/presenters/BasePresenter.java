package com.pabloazana.marvelsample.viewPresenters.baseView.presenters;

import android.content.Context;

/**
 * Created by pablo-azana on 8/05/15.
 */

public abstract class BasePresenter<T> {

    protected T view;

    public BasePresenter(T view){
        this.view = view;
    }

    public abstract void retrieveData();
}
