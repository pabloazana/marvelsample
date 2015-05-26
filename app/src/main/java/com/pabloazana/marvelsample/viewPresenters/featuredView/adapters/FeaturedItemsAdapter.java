package com.pabloazana.marvelsample.viewPresenters.featuredView.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.Comic;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedItemViewHolder;

import java.util.ArrayList;

import com.pabloazana.marvelsample.model.BaseModel;
import com.squareup.picasso.Picasso;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedItemsAdapter extends Adapter {

    private ArrayList<BaseModel> itemArray;
    private ArrayList<String> headerTittleArraylist;
    private Context contex;

    public FeaturedItemsAdapter(ArrayList<BaseModel> item_array, Context context, ArrayList<String> headerTittleArraylist) {
        this.contex = context;
        this.itemArray = item_array;
        this.headerTittleArraylist = headerTittleArraylist;

    }

    @Override
    public FeaturedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.componenet_item_featured_cardview, parent, false);
        return new FeaturedItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (itemArray.get(position).getType()){
            case TYPE_COMIC:
                ((FeaturedItemViewHolder)holder).featured_name.setText(itemArray.get(position).getName());
                ((FeaturedItemViewHolder)holder).featured_image.setImageDrawable(contex.getResources().getDrawable(R.drawable.ic_nav_drawer_settings));
                ((FeaturedItemViewHolder)holder).featured_description.setText(((Comic) itemArray.get(position)).getDescription());
                String imageUri = ((((Comic) itemArray.get(position)).getThumbnailURI()));
                Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedItemViewHolder) holder).featured_image);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemArray.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
