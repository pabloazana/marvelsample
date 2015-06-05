package com.pabloazana.multipleheaderrecyclerview.views.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

/**
 * Created by pablo-azana on 3/06/15.
 */
public abstract class RecycleBaseAdapter extends Adapter {

    public static final int TYPE_HEADER = -1;

    protected RecycleDataProvider recycleDataProvider;

    public RecycleBaseAdapter(RecycleDataProvider recycleDataProvider){
        this.recycleDataProvider = recycleDataProvider;
        this.recycleDataProvider.createOnlyItemsWithoutTitles();
    }

    @Override
    public abstract HeaderAndItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(ViewHolder holder, int position);

    public abstract int getSpanSize(int position);


    @Override
    public int getItemCount() {
        return recycleDataProvider.getOnlyItemsWithoutTitles().size() + recycleDataProvider.getTitles().size();
    }

    @Override
    public int getItemViewType(int position) {
        if(recycleDataProvider.isHeaderSection(position)) {
            return TYPE_HEADER;
        }else {
            return recycleDataProvider.getTypeOfItem(position);
        }
    }

    public boolean isHeaderSection(int position){
        return recycleDataProvider.isHeaderSection(position);
    }

    public String getHeaderTitle(int position){
        return recycleDataProvider.getHeaderTitle(position);
    }

    public int getRealPosition(int position){
        return recycleDataProvider.getRelativePosition(position);
    }
}
