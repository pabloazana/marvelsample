package com.pabloazana.marvelsample.viewPresenters.featuredView.presenters;


import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.BaseModel;
import com.pabloazana.marvelsample.resources.MarvelDataProvider;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;
import com.pabloazana.marvelsample.viewPresenters.baseView.presenters.BasePresenter;
import com.pabloazana.marvelsample.viewPresenters.featuredView.utils.FeaturedDataProvider;
import com.pabloazana.marvelsample.viewPresenters.featuredView.views.FeaturedView;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pablo-azana on 8/05/15.
 */


public class FeaturedPresenter extends BasePresenter<FeaturedView> {

    private MarvelDataProvider marvelDataProvider;
    private FeaturedDataProvider featuredDataProvider;
    private AtomicInteger itemsCount;

    public FeaturedPresenter(FeaturedView view) {
        super(view);
        marvelDataProvider = new MarvelDataProvider(view.getActivity());
        featuredDataProvider = new FeaturedDataProvider();
        itemsCount = new AtomicInteger(3);
    }

    @Override
    public void retrieveData() {
        getFeaturedComics();
        getFeaturedCharacters();
        getFeaturedEvents();
    }

    private void getFeaturedComics(){
        try {
            marvelDataProvider.getFeaturedComics(new ResourcesCallBack<ArrayList<BaseModel>>() {
                @Override
                public void onResponse(ArrayList<BaseModel> comicArrayList) {
                    featuredDataProvider.addFeaturedData(view.getResources().getString(R.string.comic_sectionTitle), comicArrayList);
                    paintContent();
                }
            });

        } catch (NoSuchAlgorithmException e) {}
    }


    private void getFeaturedCharacters(){
        try {
            marvelDataProvider.getFeaturedCharacters(new ResourcesCallBack<ArrayList<BaseModel>>() {
                @Override
                public void onResponse(ArrayList<BaseModel> characterArrayList) {
                    featuredDataProvider.addFeaturedData(view.getResources().getString(R.string.character_sectionTitle), characterArrayList);
                    paintContent();
                }
            });
        } catch (NoSuchAlgorithmException e) {}
    }

    private void getFeaturedEvents(){
        try {
            marvelDataProvider.getFeaturedEvents(new ResourcesCallBack<ArrayList<BaseModel>>() {
                @Override
                public void onResponse(ArrayList<BaseModel> eventArrayList) {
                    featuredDataProvider.addFeaturedData(view.getResources().getString(R.string.event_sectionTitle), eventArrayList);
                    paintContent();
                }
            });
        } catch (NoSuchAlgorithmException e) {}
    }


    private void paintContent(){
        if(itemsCount.decrementAndGet() == 0)
            view.paintComic(featuredDataProvider);
    }

}
