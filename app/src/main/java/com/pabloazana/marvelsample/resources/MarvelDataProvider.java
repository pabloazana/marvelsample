package com.pabloazana.marvelsample.resources;

import android.content.Context;
import android.util.Log;

import com.pabloazana.marvelsample.model.BaseModel;
import com.pabloazana.marvelsample.net.BaseRequest;
import com.pabloazana.marvelsample.net.CustomNetworkResponse;
import com.pabloazana.marvelsample.net.NetworkManager;
import com.pabloazana.marvelsample.net.RequestListener;
import com.pabloazana.marvelsample.net.ResourcesCallBacks;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;

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
    public void getFeaturedComics(final ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructComicFeaturedURI();
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<BaseModel> comicArrayList = MarvelDataParser.parserComicsArray(response.message);
                responseCallBack.onResponse(comicArrayList);
            }
        }));
    }

    @Override
    public void getFeaturedCharacters(final ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructCharactersFeaturedURI();
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<BaseModel> charactersArrayList = MarvelDataParser.parserCharactersArray(response.message);
                responseCallBack.onResponse(charactersArrayList);
            }
        }));
    }

    @Override
    public void getFeaturedEvents(final ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException {
        String url = MarvelEndPoints.constructEventsFeaturedURI();
        Log.d("Pablito", url);
        networkManager.addRequest(new BaseRequest(0, url, new RequestListener() {
            @Override
            public void onResponde(CustomNetworkResponse response) {
                ArrayList<BaseModel> charactersArrayList = MarvelDataParser.parserEventsArray(response.message);
                responseCallBack.onResponse(charactersArrayList);
            }
        }));

    }

}
