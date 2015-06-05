package com.pabloazana.marvelsample.viewPresenters.featuredView.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedHeaderViewHolder;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedItemViewHolder;

import java.util.ArrayList;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;
import com.pabloazana.multipleheaderrecyclerview.views.adapter.RecycleBaseAdapter;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedItemsAdapter extends RecycleBaseAdapter {

    private Context contex;

    public FeaturedItemsAdapter(Context context, RecycleDataProvider recycleDataProvider, ArrayList<Integer> types) {
        super(recycleDataProvider, types);
        this.contex = context;
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
                case Comic.COMIC_TYPE:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(((Comic) itemArray.get(getRelativePosition(position))).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Comic) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Comic) itemArray.get(getRelativePosition(position))).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;

                case Character.CHARACTER_TYPE:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(((Character)itemArray.get(getRelativePosition(position))).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Character) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Character) itemArray.get(getRelativePosition(position))).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;

                case Event.EVENT_TYPE:
                    ((FeaturedItemViewHolder) holder).featured_name.setText(((Event)itemArray.get(getRelativePosition(position))).getName());
                    ((FeaturedItemViewHolder) holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                    ((FeaturedItemViewHolder) holder).featured_description.setText(((Event) itemArray.get(getRelativePosition(position))).getDescription());
                    imageUri = ((((Event) itemArray.get(getRelativePosition(position))).getThumbnail()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                    break;
            }
        }
    }

    public int getSpanSize(int position){
        return isHeaderSection(position) ? 2 : 1;
    }
}
