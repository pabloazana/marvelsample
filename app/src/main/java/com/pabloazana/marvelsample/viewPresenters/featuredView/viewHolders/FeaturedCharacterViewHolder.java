package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

/**
 * Created by pablo-azana on 6/06/15.
 */
public class FeaturedCharacterViewHolder extends HeaderAndItemViewHolder {

    public TextView characterName;
    public TextView characterDescription;
    public ImageView characterImage;

    public FeaturedCharacterViewHolder(View itemView) {
        super(itemView);
        characterName = (TextView) itemView.findViewById(R.id.character_name);
        characterImage = (ImageView) itemView.findViewById(R.id.character_image);
        characterDescription = (TextView) itemView.findViewById(R.id.character_description);
    }
}
