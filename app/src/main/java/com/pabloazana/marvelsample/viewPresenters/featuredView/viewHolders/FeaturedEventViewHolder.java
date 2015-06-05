package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

/**
 * Created by pablo-azana on 5/06/15.
 */
public class FeaturedEventViewHolder extends HeaderAndItemViewHolder{

    public TextView eventName;
    public TextView eventDescription;
    public ImageView eventImage;

    public FeaturedEventViewHolder(View itemView){
        super(itemView);
        eventName = (TextView) itemView.findViewById(R.id.event_name);
        eventImage = (ImageView) itemView.findViewById(R.id.event_image);
        eventDescription = (TextView) itemView.findViewById(R.id.event_description);
    }

}
