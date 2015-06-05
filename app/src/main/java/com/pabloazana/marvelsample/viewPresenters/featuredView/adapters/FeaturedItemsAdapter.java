package com.pabloazana.marvelsample.viewPresenters.featuredView.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedCharacterViewHolder;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedHeaderViewHolder;
import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedComicViewHolder;


import com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders.FeaturedEventViewHolder;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;
import com.pabloazana.multipleheaderrecyclerview.views.adapter.RecycleBaseAdapter;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;
import com.squareup.picasso.Picasso;

import static com.pabloazana.marvelsample.model.Character.CHARACTER_TYPE;
import static com.pabloazana.marvelsample.model.Event.EVENT_TYPE;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedItemsAdapter extends RecycleBaseAdapter {

    private Context contex;

    public FeaturedItemsAdapter(Context context, RecycleDataProvider recycleDataProvider) {
        super(recycleDataProvider);
        this.contex = context;
    }

    @Override
    public HeaderAndItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_header_featured, parent, false);
            return new FeaturedHeaderViewHolder(v);
        }
        else if(viewType == EVENT_TYPE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_event_featured_card_view, parent, false);
            return new FeaturedEventViewHolder(v);
        } else if(viewType == CHARACTER_TYPE) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_character_featured_card_view, parent, false);
            return new FeaturedCharacterViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_comic_featured_card_view, parent, false);
            return new FeaturedComicViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder instanceof FeaturedHeaderViewHolder){
            ((FeaturedHeaderViewHolder)holder).headerTittle.setText(getHeaderTitle(position));
        }else{
            String imageUri = "";
            switch (recycleDataProvider.getTypeOfItem(position)) {
                case Comic.COMIC_TYPE:
                    ((FeaturedComicViewHolder) holder).comicName.setText(((Comic) recycleDataProvider.getItem(position)).getName());
                    ((FeaturedComicViewHolder) holder).comicDescription.setText(((Comic) recycleDataProvider.getItem(position)).getDescription());
                    imageUri = ((((Comic) recycleDataProvider.getItem(position)).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedComicViewHolder) holder).comicImage);
                    break;

                case CHARACTER_TYPE:
                    ((FeaturedCharacterViewHolder) holder).characterName.setText(((Character) recycleDataProvider.getItem(position)).getName());
                    ((FeaturedCharacterViewHolder) holder).characterDescription.setText(((Character) recycleDataProvider.getItem(position)).getDescription());
                    imageUri = ((((Character) recycleDataProvider.getItem(position)).getThumbnailURI()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedCharacterViewHolder) holder).characterImage);
                    break;

                case EVENT_TYPE:
                    ((FeaturedEventViewHolder) holder).eventName.setText(((Event) recycleDataProvider.getItem(position)).getName());
                    ((FeaturedEventViewHolder) holder).eventDescription.setText(((Event) recycleDataProvider.getItem(position)).getDescription());
                    imageUri = ((((Event) recycleDataProvider.getItem(position)).getThumbnail()));
                    Picasso.with(contex).load(imageUri).fit().centerCrop().into(((FeaturedEventViewHolder) holder).eventImage);
                    break;
            }
        }
    }

    @Override
    public int getSpanSize(int position){
        if(getItemViewType(position) == TYPE_HEADER || getItemViewType(position) == EVENT_TYPE) return 2;
        else return 1;
    }
}
