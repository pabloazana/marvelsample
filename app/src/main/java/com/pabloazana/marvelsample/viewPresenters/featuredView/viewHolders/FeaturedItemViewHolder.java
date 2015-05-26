package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedItemViewHolder extends ViewHolder {

    public TextView featured_name;
    public TextView featured_description;
    public ImageView featured_image;

    public FeaturedItemViewHolder(View itemView) {
        super(itemView);
        featured_name = (TextView) itemView.findViewById(R.id.comic_name);
        featured_image = (ImageView) itemView.findViewById(R.id.comic_image);
        featured_description = (TextView) itemView.findViewById(R.id.comic_description);
    }
}