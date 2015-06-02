package com.pabloazana.marvelsample.viewPresenters.baseView.presenters;

import com.pabloazana.marvelsample.viewPresenters.baseView.views.NavigationDrawerCallbacks;

public class NavigationdrawerPresenter{

    private NavigationDrawerCallbacks navigationDrawerCallbacks;
    private int currentPosition;

    public NavigationdrawerPresenter(NavigationDrawerCallbacks startingActivity){
        navigationDrawerCallbacks = startingActivity;
        currentPosition = -1;
    }

    public void selectNavigationDrawerPosition(int position){
        if(currentPosition != position) {
            currentPosition = position;
            navigationDrawerCallbacks.onNavigationDrawerItemSelected(currentPosition);
        }
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

}
