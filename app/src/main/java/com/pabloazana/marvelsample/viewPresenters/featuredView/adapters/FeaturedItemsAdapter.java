package com.pabloazana.marvelsample.viewPresenters.featuredView.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.viewPresenters.featuredView.utils.FeaturedDataProvider;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedHeaderViewHolder;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedItemViewHolder;

import java.util.ArrayList;
import java.util.HashMap;

import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.HeaderAndItemViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedItemsAdapter extends Adapter {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    FeaturedDataProvider featuredDataProvider;
    private ArrayList<BaseModel> itemArray;
    private ArrayList<String> headerTittleArraylist;
    private Context contex;

    public FeaturedItemsAdapter(FeaturedDataProvider featuredDataProvider, Context context) {
        this.contex = context;
        this.featuredDataProvider = featuredDataProvider;
        this.headerTittleArraylist = new ArrayList<>();
        this.itemArray = new ArrayList<>();

        ArrayList<String> headerTitles = featuredDataProvider.getTitles();
        for (String title : headerTitles) {
            headerTittleArraylist.add(title);
            itemArray.addAll(featuredDataProvider.getFeaturedData().get(title));
        }
    }

    @Override
    public HeaderAndItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_header_featured, parent, false);
            return new FeaturedHeaderViewHolder(v);
        }
        else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.componenet_item_featured_cardview, parent, false);
            return new FeaturedItemViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder instanceof FeaturedHeaderViewHolder){
            ((FeaturedHeaderViewHolder)holder).headerTittle.setText(getHeaderTitle(position));
        }else{
            String imageUri = "";
            switch (itemArray.get(getRelativePosition(position)).getType()) {
                case TYPE_COMIC:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(itemArray.get(getRelativePosition(position)).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Comic) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Comic) itemArray.get(getRelativePosition(position))).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;

                case TYPE_CHARACTER:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(itemArray.get(getRelativePosition(position)).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Character) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Character) itemArray.get(getRelativePosition(position))).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;

                case TYPE_EVENT:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(itemArray.get(getRelativePosition(position)).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Event) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Event) itemArray.get(getRelativePosition(position))).getThumbnail()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemArray.size() + headerTittleArraylist.size();
    }

    @Override
    public int getItemViewType(int position) {
        return isHeaderSection(position) ? TYPE_HEADER : TYPE_ITEM;
    }

    public boolean isHeaderSection(int position) {
        int totalSections = featuredDataProvider.getTotalSections();
        int itemCount = 0;
        for (int i = 0; i < totalSections; i++) {
            if (itemCount == position) return true;
            ++itemCount;
            itemCount += featuredDataProvider.getTotalItemsOfSection(i);
        }

        return false;
    }

    public int getRelativePosition(int position){
        int totalSections = featuredDataProvider.getTotalSections();
        int countSection = 0;
        int countItems = 0;
        for(int i = 0; i < totalSections; i++){
            ++countSection;
            countItems += featuredDataProvider.getFeaturedData().get(headerTittleArraylist.get(i)).size() + 1;
            if(position <= countItems) return position - countSection;
        }
        return position - countItems;
    }

    public String getHeaderTitle(int position){
        HashMap<String, ArrayList<BaseModel>> dataHasMap = featuredDataProvider.getFeaturedData();
        int totalItemsCount = 0;
        String titleResult = "";
        for(String title : headerTittleArraylist){
            ArrayList<BaseModel> section = dataHasMap.get(title);
            totalItemsCount += (section.size() + 1);
            if(position < totalItemsCount){
                titleResult = title;
                break;
            }
        }
        return titleResult;
    }

    public int getSpanSize(int position){
        return isHeaderSection(position) ? 2 : 1;
    }
}
