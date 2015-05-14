package com.pabloazana.marvelsample.viewPresenters.views.fragments;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.viewPresenters.views.UiUtils;

public class NavigationDrawerFragment extends Fragment {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private LinearLayout linearLayuotDrawer;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
    private View [] navDrawerItemViews;
    
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


    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        selectItem(mCurrentSelectedPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        linearLayuotDrawer = (LinearLayout) inflater.inflate(R.layout.navigationdrawer, container, false);

        ViewGroup navDrawerItemsListContainer = (ViewGroup) linearLayuotDrawer.findViewById(R.id.navdrawer_items_list);
        navDrawerItemViews = new View[NAVDRAWER_ITEM_ID.length];
        navDrawerItemsListContainer.removeAllViews();
        for (int i = 0; i < NAVDRAWER_ITEM_ID.length; i++) {
            navDrawerItemViews[i] = makeNavDrawerItem(NAVDRAWER_ITEM_ID[i], navDrawerItemsListContainer, inflater);
            navDrawerItemsListContainer.addView(navDrawerItemViews[i]);
        }
        return linearLayuotDrawer;
    }


    private View makeNavDrawerItem(final int itemId, ViewGroup container, LayoutInflater inflater) {
        boolean selected = NAVDRAWER_ITEM_INVALID == itemId;
        boolean isSeparator = isSeparator(itemId);
        int layoutToInflate = isSeparator ? R.layout.item_navdrawer_separator : R.layout.item_navdrawer;
        View view = inflater.inflate(layoutToInflate, container, false);
        if (isSeparator) {
            UiUtils.setAccessibilityIgnore(view);
        } else {
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


    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.drawable.ic_drawer_new,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

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

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        setSelectedNavDrawerItem(position);
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (mDrawerLayout != null && isDrawerOpen()) {
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setTitle(R.string.app_name);
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

    public interface NavigationDrawerCallbacks {
        void onNavigationDrawerItemSelected(int position);
    }
}
