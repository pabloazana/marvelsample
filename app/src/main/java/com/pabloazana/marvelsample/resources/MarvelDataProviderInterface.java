package com.pabloazana.marvelsample.resources;

import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.marvelsample.net.ResourcesCallBacks.ResourcesCallBack;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by pablo-azana on 23/05/15.
 */

public interface MarvelDataProviderInterface {

    void getFeaturedComics(ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException;

    void getFeaturedCharacters(ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException;

    void getFeaturedEvents(ResourcesCallBack<ArrayList<RecycleBaseModel>> responseCallBack) throws NoSuchAlgorithmException;

}
