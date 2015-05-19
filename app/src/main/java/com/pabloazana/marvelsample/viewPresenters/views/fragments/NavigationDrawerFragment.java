package com.pabloazana.marvelsample.viewPresenters.views.fragments;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.viewPresenters.presenters.NavigationdrawerPresenter;
import com.pabloazana.marvelsample.viewPresenters.views.UiUtils;

public class NavigationDrawerFragment extends BaseFragment<NavigationdrawerPresenter> {

    private static final String STATE_SELECTED_POSITION = "STATE_SELECTED_POSITION";
    private static final String PREF_USER_LEARNED_DRAWER = "NAV_DRAWER_LEARNED";

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private View fragmentContainerView;
    private View [] navDrawerItemViews;

    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    private static final int NAVDRAWER_ITEM_INVALID = -1;
    private static final int NAVDRAWER_ITEM_SEPARATOR = -2;
    private static final int NAVDRAWER_ITEM_FEATURES = 0;
    private static final int NAVDRAWER_ITEM_MY_MUSIC = 1;
    private static final int NAVDRAWER_ITEM_SETTINGS = 2;

    private static final int[] NAVDRAWER_ITEM_ID = new int[]{
            NAVDRAWER_ITEM_FEATURES,
            NAVDRAWER_ITEM_MY_MUSIC,
            NAVDRAWER_ITEM_SEPARATOR,
            NAVDRAWER_ITEM_SETTINGS
    };

    private static final int[] NAVDRAWER_TITLE_RES_ID = new int[]{
            R.string.navdrawer_item_featured,
            R.string.navdrawer_item_my_music,
            R.string.navdrawer_item_settings
    };

    private static final int[] NAVDRAWER_ICON_RES_ID = new int[]{
            R.drawable.ic_nav_drawer_featured,
            R.drawable.ic_nav_drawer_my_music,
            R.drawable.ic_nav_drawer_settings
    };

    @Override
    protected NavigationdrawerPresenter getPresenter() {
        return new NavigationdrawerPresenter(mainActivity);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.navigationdrawer;
    }

    @Override
    protected void setupToolbar() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);
        if (savedInstanceState != null) mFromSavedInstanceState = true;
        selectItem(savedInstanceState != null ? savedInstanceState.getInt(STATE_SELECTED_POSITION) : 0);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayoutDrawer = (LinearLayout) super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup navDrawerItemsListContainer = (ViewGroup) linearLayoutDrawer.findViewById(R.id.navdrawer_items_list);
        navDrawerItemViews = new View[NAVDRAWER_ITEM_ID.length];
        navDrawerItemsListContainer.removeAllViews();
        for (int i = 0; i < NAVDRAWER_ITEM_ID.length; i++) {
            navDrawerItemViews[i] = makeNavDrawerItem(NAVDRAWER_ITEM_ID[i], navDrawerItemsListContainer, inflater);
            navDrawerItemsListContainer.addView(navDrawerItemViews[i]);
        }
        return linearLayoutDrawer;
    }

    private View makeNavDrawerItem(final int itemId, ViewGroup container, LayoutInflater inflater) {
        int layoutToInflate = isSeparator(itemId) ? R.layout.item_navdrawer_separator : R.layout.item_navdrawer;
        View view = inflater.inflate(layoutToInflate, container, false);
        if (isSeparator(itemId)) {
            UiUtils.setAccessibilityIgnore(view);
        } else {
            boolean selected = NAVDRAWER_ITEM_INVALID == itemId;
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);
            TextView titleView = (TextView) view.findViewById(R.id.title);
            iconView.setVisibility(View.VISIBLE);
            iconView.setImageResource(NAVDRAWER_ICON_RES_ID[itemId]);
            titleView.setText(getString(NAVDRAWER_TITLE_RES_ID[itemId]));
            formatNavDrawerItem(view, itemId, selected);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectItem(itemId);
                }
            });
        }
        return view;
    }

    private void formatNavDrawerItem(View view, int itemId, boolean selected) {
        if (!isSeparator(itemId)) {
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);
            TextView titleView = (TextView) view.findViewById(R.id.title);
            titleView.setTextColor(selected ?
                    getResources().getColor(R.color.navdrawer_text_color_selected) :
                    getResources().getColor(R.color.navdrawer_text_color));
            iconView.setColorFilter(selected ?
                    getResources().getColor(R.color.navdrawer_icon_tint_selected) :
                    getResources().getColor(R.color.navdrawer_icon_tint));
        }
    }

    private boolean isSeparator(int itemId) {
        return itemId == NAVDRAWER_ITEM_SEPARATOR;
    }

    public void setUpNavigationDrawer(int fragmentId, DrawerLayout drawerLayout) {
        fragmentContainerView = getActivity().findViewById(fragmentId);
        this.drawerLayout = drawerLayout;
        this.drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        initActionBarDrawerToggle();

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            this.drawerLayout.openDrawer(fragmentContainerView);
        }

        this.drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
        this.drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    public void initActionBarDrawerToggle(){
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) return;
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) return;
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }
                getActivity().supportInvalidateOptionsMenu();
            }
        };
    }

    private void selectItem(int position) {
        setSelectedNavDrawerItem(position);
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(fragmentContainerView);
        }
        presenter.selectNavigationDrawerPosition(position);
    }

    private void setSelectedNavDrawerItem(int itemId) {
        if (navDrawerItemViews != null) {
            for (int i = 0; i < navDrawerItemViews.length; i++) {
                int thisItemId = NAVDRAWER_ITEM_ID[i];
                formatNavDrawerItem(navDrawerItemViews[i], thisItemId, itemId == thisItemId);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, presenter.getCurrentPosition());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }
}
