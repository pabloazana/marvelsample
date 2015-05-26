package com.pabloazana.marvelsample.viewPresenters.featuredView.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pabloazana.marvelsample.R;

/**
 * Created by pablo-azana on 21/05/15.
 */
public class FeaturedHeaderViewHolder extends RecyclerView.ViewHolder {

    public TextView headerTittle;

    public FeaturedHeaderViewHolder(View itemView) {
        super(itemView);
        headerTittle = (TextView) itemView.findViewById(R.id.featured_tittle);
    }
}
