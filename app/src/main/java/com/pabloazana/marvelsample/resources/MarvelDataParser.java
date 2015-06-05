package com.pabloazana.marvelsample.resources;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;
import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;


import java.util.ArrayList;

/**
 * Created by pablo-azana on 23/05/15.
 */

public class MarvelDataParser {

    private static JsonParser parser = new JsonParser();

    public static ArrayList<RecycleBaseModel> parserComicsArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<RecycleBaseModel> resultArray = new ArrayList<>();
        for(int i=0; i<dataArray.size(); i++){
            try {
                resultArray.add(parserComicObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException ignoredExecption) {}
        }
        return resultArray;
    }

    public static Comic parserComicObject(JsonObject comicObject) throws ParserException{
        try{
            Comic comic = new Comic(comicObject.get("id").getAsString());
            comic.setName(comicObject.get("title").getAsString());
            comic.setDescription(comicObject.get("description").getAsString());
            JsonObject thumbs = comicObject.getAsJsonObject("thumbnail");
            String thumbnailURL = thumbs.get("path").getAsString() + "." + thumbs.get("extension").getAsString();
            checkImageAvailable(thumbnailURL);
            comic.setThumbnailURI(thumbnailURL);
            return comic;
        }catch (Exception e){
            throw new ParserException(e);
        }
    }

    public static ArrayList<RecycleBaseModel> parserCharactersArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<RecycleBaseModel> resultArray = new ArrayList<>();
        for(int i = 0; i< dataArray.size(); i++){
            try {
                resultArray.add(parserCharacterObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException e) {}
        }
        return resultArray;
    }

    public static Character parserCharacterObject(JsonObject characterObject) throws ParserException{
        try {
            Character character = new Character(characterObject.get("id").getAsString());
            character.setName(characterObject.get("name").getAsString());
            character.setDescription(characterObject.get("description").getAsString());
            JsonObject thumbs = characterObject.getAsJsonObject("thumbnail");
            String thumbnailURL = thumbs.get("path").getAsString() + "." + thumbs.get("extension").getAsString();
            checkImageAvailable(thumbnailURL);
            character.setThumbnailURI(thumbnailURL);
            return character;
        } catch (Exception e){
            throw new ParserException(e);
        }
    }

    public static ArrayList<RecycleBaseModel> parserEventsArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<RecycleBaseModel> resultArray = new ArrayList<>();
        for(int i = 0; i< dataArray.size(); i++){
            try {
                resultArray.add(parserEventObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException e) {}
        }
        return resultArray;
    }

    public static Event parserEventObject(JsonObject eventObject) throws ParserException{
        try {
            Event event = new Event(eventObject.get("id").getAsString());
            event.setName(eventObject.get("title").getAsString());
            event.setDescription(eventObject.get("description").getAsString());
            JsonObject thumbs = eventObject.getAsJsonObject("thumbnail");
            String thumbnailURL = thumbs.get("path").getAsString() + "." + thumbs.get("extension").getAsString();
            checkImageAvailable(thumbnailURL);
            event.setThumbnail(thumbnailURL);
            return event;
        } catch (Exception e){
            throw new ParserException(e);
        }
    }

    public static void checkImageAvailable(String imageUrl) throws ParserException {
        if(imageUrl.contains("image_not_available")) throw new ParserException(new Exception());
    }



}
