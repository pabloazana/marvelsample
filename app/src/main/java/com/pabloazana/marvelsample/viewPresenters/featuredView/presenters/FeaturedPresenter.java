package com.pabloazana.marvelsample.viewPresenters.featuredView.presenters;


import com.pabloazana.marvelsample.R;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.resources.MarvelDataProvider;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;
import com.pabloazana.marvelsample.viewPresenters.baseView.presenters.BasePresenter;
import com.pabloazana.marvelsample.viewPresenters.featuredView.views.FeaturedView;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pablo-azana on 8/05/15.
 */


public class FeaturedPresenter extends BasePresenter<FeaturedView> {

    public static final int TOTAL_ITEMS = 3;

    private MarvelDataProvider marvelDataProvider;
    private RecycleDataProvider recyleDataProvider;
    private AtomicInteger itemsCount;

    public FeaturedPresenter(FeaturedView view) {
        super(view);
        marvelDataProvider = new MarvelDataProvider(view.getActivity());
        recyleDataProvider = new RecycleDataProvider(TOTAL_ITEMS);
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
            marvelDataProvider.getFeaturedComics(new ResourcesCallBack<ArrayList<RecycleBaseModel>>() {
                @Override
                public void onResponse(ArrayList<RecycleBaseModel> comicArrayList) {
                    recyleDataProvider.addFeaturedData(view.getResources().getString(R.string.comic_sectionTitle), comicArrayList, Comic.COMIC_TYPE);
                    paintContent();
                }
            });

        } catch (NoSuchAlgorithmException e) {}
    }


    private void getFeaturedCharacters(){
        try {
            marvelDataProvider.getFeaturedCharacters(new ResourcesCallBack<ArrayList<RecycleBaseModel>>() {
                @Override
                public void onResponse(ArrayList<RecycleBaseModel> characterArrayList) {
                    recyleDataProvider.addFeaturedData(view.getResources().getString(R.string.character_sectionTitle), characterArrayList, Character.CHARACTER_TYPE);
                    paintContent();
                }
            });
        } catch (NoSuchAlgorithmException e) {}
    }

    private void getFeaturedEvents(){
        try {
            marvelDataProvider.getFeaturedEvents(new ResourcesCallBack<ArrayList<RecycleBaseModel>>() {
                @Override
                public void onResponse(ArrayList<RecycleBaseModel> eventArrayList) {
                    recyleDataProvider.addFeaturedData(view.getResources().getString(R.string.event_sectionTitle), eventArrayList, Event.EVENT_TYPE);
                    paintContent();
                }
            });
        } catch (NoSuchAlgorithmException e) {}
    }


    private void paintContent(){
        if(itemsCount.decrementAndGet() == 0)
            view.paintComic(recyleDataProvider);
    }

}
