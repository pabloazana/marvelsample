package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.view.View;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;
import com.pabloazana.multipleheaderrecyclerview.views.viewholder.HeaderAndItemViewHolder;

/**
 * Created by pablo-azana on 21/05/15.
 */
public class FeaturedHeaderViewHolder extends HeaderAndItemViewHolder {

    public TextView headerTittle;

    public FeaturedHeaderViewHolder(View itemView) {
        super(itemView);
        headerTittle = (TextView) itemView.findViewById(R.id.featured_tittle);
    }
}
