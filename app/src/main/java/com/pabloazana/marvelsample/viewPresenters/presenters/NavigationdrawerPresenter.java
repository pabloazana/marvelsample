package com.pabloazana.marvelsample.viewPresenters.presenters;

import com.pabloazana.marvelsample.viewPresenters.views.fragments.NavigationDrawerCallbacks;

public class NavigationdrawerPresenter extends BasePresenter{

    private NavigationDrawerCallbacks navigationDrawerCallbacks;
    private int currentPosition;

    public NavigationdrawerPresenter(NavigationDrawerCallbacks startingActivity){
        navigationDrawerCallbacks = startingActivity;
    }

    public void selectNavigationDrawerPosition(int position){
        currentPosition = position;
        navigationDrawerCallbacks.onNavigationDrawerItemSelected(currentPosition);
    }

    public int getCurrentPosition(){
        return currentPosition;
    }



}
