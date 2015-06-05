package com.pabloazana.multipleheaderrecyclerview.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pablo-azana on 3/06/15.
 */
public class RecycleDataProvider {

    private HashMap<Integer, ArrayList<RecycleBaseModel>> featuredData;
    private ArrayList<String> titles;

    public RecycleDataProvider(int totalItems){
        featuredData = new HashMap<>();
        titles = new ArrayList<>();
        for(int i = 0; i < totalItems; i++){
            titles.add(i, "");
        }
    }

    public void addFeaturedData(String title, ArrayList<RecycleBaseModel> data, int type){
        featuredData.put(type, data);
        titles.set(type, title);
    }

    public HashMap<Integer, ArrayList<RecycleBaseModel>> getFeaturedData() {
        return featuredData;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public int getTotalSections(){
        return titles.size();
    }

    public int getTotalItemsOfSection(int section){
        return featuredData.get(section).size();
    }

    public int getTypeOfItem(RecycleBaseModel baseModel){
        for(int i = 0; i < featuredData.size(); i++){
            ArrayList<RecycleBaseModel> sectionList = featuredData.get(i);
            if(sectionList != null && sectionList.contains(baseModel)){
                return i;
            }
        }
        return -1;
    }


}
