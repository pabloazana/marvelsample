package com.pabloazana.marvelsample.resources;

import com.pabloazana.marvelsample.model.BaseModel;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by pablo-azana on 23/05/15.
 */

public interface MarvelDataProviderInterface {

    void getFeaturedComics(ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException;

    void getFeaturedCharacters(ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException;

    void getFeaturedEvents(ResourcesCallBack<ArrayList<BaseModel>> responseCallBack) throws NoSuchAlgorithmException;

}
