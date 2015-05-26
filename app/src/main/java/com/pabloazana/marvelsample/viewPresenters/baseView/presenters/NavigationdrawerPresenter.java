package com.pabloazana.marvelsample.viewPresenters.baseView.presenters;

import com.pabloazana.marvelsample.viewPresenters.baseView.views.NavigationDrawerCallbacks;

public class NavigationdrawerPresenter{

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
