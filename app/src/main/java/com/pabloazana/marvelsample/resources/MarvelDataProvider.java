package com.pabloazana.marvelsample.resources;

import android.content.Context;
import android.util.Log;

import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.net.BaseRequest;
import com.pabloazana.marvelsample.net.CustomNetworkResponse;
import com.pabloazana.marvelsample.net.NetworkManager;
import com.pabloazana.marvelsample.net.RequestListener;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleDataProvider;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by pablo-azana on 22/05/15.
 */

public class MarvelDataProvider implements MarvelDataProviderInterface {

    private NetworkManager networkManager;

    public MarvelDataProvider(Context context){
        networkManager = new NetworkManager(context);
    }

    @Override
    public void getFeaturedComics(final ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructComicFeaturedURI();
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<RecycleBaseModel> comicArrayList = MarvelDataParser.parserComicsArray(response.message);
                responseCallBack.onResponse(comicArrayList);
            }
        }));
    }

    @Override
    public void getFeaturedCharacters(final ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructCharactersFeaturedURI();
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<RecycleBaseModel> charactersArrayList = MarvelDataParser.parserCharactersArray(response.message);
                responseCallBack.onResponse(charactersArrayList);
            }
        }));
    }

    @Override
    public void getFeaturedEvents(final ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructEventsFeaturedURI();
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<RecycleBaseModel> charactersArrayList = MarvelDataParser.parserEventsArray(response.message);
                responseCallBack.onResponse(charactersArrayList);
            }
        }));

    }

}
