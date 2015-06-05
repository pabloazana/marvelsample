package com.pabloazana.multipleheaderrecyclerview.views.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pablo-azana on 3/06/15.
 */
public abstract class RecycleBaseAdapter extends Adapter {

    protected static final int TYPE_HEADER = -1;

    private RecycleDataProvider recycleDataProvider;
    protected ArrayList<RecycleBaseModel> itemArray;
    protected ArrayList<String> headerTittleArraylist;

    public RecycleBaseAdapter(RecycleDataProvider recycleDataProvider, ArrayList<Integer> types){
        this.recycleDataProvider = recycleDataProvider;
        this.headerTittleArraylist = new ArrayList<>();
        this.itemArray = new ArrayList<>();

        ArrayList<String> headerTitles = recycleDataProvider.getTitles();
        for (int i = 0; i < headerTitles.size(); i++){
            headerTittleArraylist.add(headerTitles.get(i));
            if(recycleDataProvider.getFeaturedData().get(i) != null)
                itemArray.addAll(recycleDataProvider.getFeaturedData().get(i));
        }
    }

    @Override
    public abstract HeaderAndItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return itemArray.size() + headerTittleArraylist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(isHeaderSection(position)) {
            return TYPE_HEADER;
        }else {
            int type = recycleDataProvider.getTypeOfItem(itemArray.get(getRelativePosition(position)));
            return type;
        }
    }

    public boolean isHeaderSection(int position) {
        int totalSections = recycleDataProvider.getTotalSections();
        int itemCount = 0;
        for (int i = 0; i < totalSections; i++) {
            if (itemCount == position) return true;
            ++itemCount;
            itemCount += recycleDataProvider.getTotalItemsOfSection(i);
        }
        return false;
    }

    public int getRelativePosition(int position){
        int totalSections = recycleDataProvider.getTotalSections();
        int countSection = 0;
        int countItems = 0;
        for(int i = 0; i < totalSections; i++){
            ++countSection;
            countItems += recycleDataProvider.getFeaturedData().get(i).size() + 1;
            if(position <= countItems) return position - countSection;
        }
        return position - countItems;
    }

    public String getHeaderTitle(int position){
        HashMap<Integer, ArrayList<RecycleBaseModel>> dataHasMap = recycleDataProvider.getFeaturedData();
        int totalItemsCount = 0;
        String titleResult = "";
        for(String title : headerTittleArraylist){
            ArrayList<RecycleBaseModel> section = dataHasMap.get(headerTittleArraylist.indexOf(title));
            totalItemsCount += (section.size() + 1);
            if(position < totalItemsCount){
                titleResult = title;
                break;
            }
        }
        return titleResult;
    }
}
