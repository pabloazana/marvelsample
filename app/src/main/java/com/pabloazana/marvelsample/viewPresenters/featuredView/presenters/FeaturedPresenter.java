package com.pabloazana.marvelsample.viewPresenters.featuredView.presenters;


import com.pabloazana.marvelsample.model.BaseModel;
import com.pabloazana.marvelsample.resources.MarvelDataProvider;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;
import com.pabloazana.marvelsample.viewPresenters.baseView.presenters.BasePresenter;
import com.pabloazana.marvelsample.viewPresenters.featuredView.views.FeaturedView;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by pablo-azana on 8/05/15.
 */


public class FeaturedPresenter extends BasePresenter<FeaturedView> {

    private MarvelDataProvider marvelDataProvider;

    public FeaturedPresenter(FeaturedView view) {
        super(view);
        marvelDataProvider = new MarvelDataProvider(view.getActivity());
    }

    @Override
    public void retrieveData() {
        try {
            marvelDataProvider.getFeaturedComics(new ResourcesCallBack<ArrayList<BaseModel>>() {
                @Override
                public void onResponse(ArrayList<BaseModel> comicArrayList) {
                    view.paintComic(comicArrayList);
                }
            });

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
