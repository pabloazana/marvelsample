package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class FeaturedComicViewHolder extends HeaderAndItemViewHolder {

    public TextView comicName;
    public TextView comicDescription;
    public ImageView comicImage;

    public FeaturedComicViewHolder(View itemView) {
        super(itemView);
        comicName = (TextView) itemView.findViewById(R.id.comic_name);
        comicImage = (ImageView) itemView.findViewById(R.id.comic_image);
        comicDescription = (TextView) itemView.findViewById(R.id.comic_description);
    }


}
