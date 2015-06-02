package com.pabloazana.marvelsample.viewPresenters.featuredView.utils;

import com.pabloazana.marvelsample.model.BaseModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pablo-azana on 26/05/15.
 */
public class FeaturedDataProvider {

    private HashMap<String, ArrayList<BaseModel>> featuredData;
    private ArrayList<String> titles;

    public FeaturedDataProvider(){
        featuredData = new HashMap<>();
        titles = new ArrayList<>();
    }

    public void addFeaturedData(String title, ArrayList<BaseModel> data){
        featuredData.put(title, data);
        titles.add(title);
    }

    public HashMap<String, ArrayList<BaseModel>> getFeaturedData() {
        return featuredData;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public int getTotalSections(){
        return titles.size();
    }

    public int getTotalItemsOfSection(int section){
        return featuredData.get(titles.get(section)).size();
    }
}
