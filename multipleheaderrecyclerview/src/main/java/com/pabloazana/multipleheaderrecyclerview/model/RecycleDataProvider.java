package com.pabloazana.multipleheaderrecyclerview.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pablo-azana on 3/06/15.
 */
public class RecycleDataProvider {


    private HashMap<Integer, ArrayList<RecycleBaseModel>> featuredData;
    private ArrayList<RecycleBaseModel> onlyItemsWithoutTitles;
    private ArrayList<String> titles;

    public RecycleDataProvider(int totalItems){
        featuredData = new HashMap<>();
        titles = new ArrayList<>();
        onlyItemsWithoutTitles = new ArrayList<>();
        for(int i = 0; i < totalItems; i++){
            titles.add(i, "");
        }
    }

    public void addFeaturedData(String titleOfSection, ArrayList<RecycleBaseModel> data, int type){
        featuredData.put(type, data);
        titles.set(type, titleOfSection);
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

    public void createOnlyItemsWithoutTitles(){
        for (int i = 0; i < featuredData.keySet().size(); i++){
            if(featuredData.get(i) != null)
                onlyItemsWithoutTitles.addAll(featuredData.get(i));
        }
    }

    public ArrayList<RecycleBaseModel> getOnlyItemsWithoutTitles(){
        return onlyItemsWithoutTitles;
    }

    public int getTypeOfItem(int position){
        return onlyItemsWithoutTitles.get(getRelativePosition(position)).getType();
    }

    public RecycleBaseModel getItem(int position){
        return onlyItemsWithoutTitles.get(getRelativePosition(position));
    }

    public boolean isHeaderSection(int position) {
        int itemCount = 0;
        for (int i = 0; i < getTotalSections(); i++) {
            if (itemCount == position) return true;
            ++itemCount;
            itemCount += getTotalItemsOfSection(i);
        }
        return false;
    }

    public String getHeaderTitle(int position){
        int totalItemsCount = 0;
        String titleResult = "";
        for(String title : titles){
            ArrayList<RecycleBaseModel> section = featuredData.get(titles.indexOf(title));
            totalItemsCount += (section.size() + 1);
            if(position < totalItemsCount){
                titleResult = title;
                break;
            }
        }
        return titleResult;
    }

    public int getRelativePosition(int position){
        int totalSections = getTotalSections();
        int countSection = 0;
        int countItems = 0;
        for(int i = 0; i < totalSections; i++){
            ++countSection;
            countItems += featuredData.get(i).size() + 1;
            if(position <= countItems) return position - countSection;
        }
        return position - countItems;
    }


}
