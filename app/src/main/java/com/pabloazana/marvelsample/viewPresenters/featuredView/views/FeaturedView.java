package com.pabloazana.marvelsample.viewPresenters.featuredView.views;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.Event;
import com.pabloazana.marvelsample.viewPresenters.featuredView.adapters.FeaturedItemsAdapter;
import com.pabloazana.marvelsample.viewPresenters.featuredView.presenters.FeaturedPresenter;
import com.pabloazana.marvelsample.viewPresenters.baseView.views.BaseFragment;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;

import static com.pabloazana.marvelsample.model.Event.EVENT_TYPE;
import static com.pabloazana.multipleheaderrecyclerview.views.adapter.RecycleBaseAdapter.TYPE_HEADER;


/**
 * Created by pablo-azana on 8/05/15.
 */

public class FeaturedView extends BaseFragment<FeaturedPresenter> {

    public static final String SCREEN_TAG = "Featured_View";
    private RecyclerView mRecyclerView;
    private FeaturedItemsAdapter mAdapter;
    private GridLayoutManager mLayoutManager;

    public static FeaturedView newInstance() {
        return new FeaturedView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screen_tag = SCREEN_TAG;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration());
        mLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void paintComic(RecycleDataProvider recycleDataProvider) {
        mAdapter = new FeaturedItemsAdapter(getActivity(), recycleDataProvider);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getSpanSize(position);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildPosition(view);
            if(mAdapter.getItemViewType(position) == TYPE_HEADER){
                outRect.left = 16;
                outRect.right = 16;
                outRect.bottom = 8;
                outRect.top = 16;
            }
            else if(mAdapter.getItemViewType(position) == EVENT_TYPE){
                outRect.left = 16;
                outRect.right = 16;
                outRect.bottom = 8;
                outRect.top = 8;
            }
            else {
                outRect.left = (mAdapter.getRealPosition(position) % 2 == 0 ? 16 : 8);
                outRect.right = (mAdapter.getRealPosition(position) % 2 == 0 ? 8 : 16);
                outRect.bottom = 8;
                outRect.top = mAdapter.getRealPosition(position) == 0 || mAdapter.getRealPosition(position) == 1 ? 16 : 8;
            }
        }
    }


    @Override
    protected FeaturedPresenter getPresenter() {
        return new FeaturedPresenter(this);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.featured_fragment;
    }

    @Override
    protected void setupToolbar() {
        mainActivity.getToolBar().setTitle("Featured");
        mainActivity.getToolBar().setNavigationIcon(R.drawable.ic_drawer_new);
    }
}
