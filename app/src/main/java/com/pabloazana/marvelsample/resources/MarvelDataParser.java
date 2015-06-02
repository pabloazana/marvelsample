package com.pabloazana.marvelsample.resources;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pabloazana.marvelsample.model.*;
import com.pabloazana.marvelsample.model.Character;


import java.util.ArrayList;

import static com.pabloazana.marvelsample.model.BaseModel.modelType.TYPE_CHARACTER;
import static com.pabloazana.marvelsample.model.BaseModel.modelType.TYPE_COMIC;
import static com.pabloazana.marvelsample.model.BaseModel.modelType.TYPE_EVENT;

/**
 * Created by pablo-azana on 23/05/15.
 */

public class MarvelDataParser {

    private static JsonParser parser = new JsonParser();

    public static ArrayList<BaseModel> parserComicsArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<BaseModel> resultArray = new ArrayList<>();
        for(int i=0; i<dataArray.size(); i++){
            try {
                resultArray.add(parserComicObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException ignoredExecption) {}
        }
        return resultArray;
    }

    public static Comic parserComicObject(JsonObject comicObject) throws ParserException{
        try{
            Comic comic = new Comic(comicObject.get("title").getAsString(), TYPE_COMIC, comicObject.get("id").getAsString());
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

    public static ArrayList<BaseModel> parserCharactersArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<BaseModel> resultArray = new ArrayList<>();
        for(int i = 0; i< dataArray.size(); i++){
            try {
                resultArray.add(parserCharacterObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException e) {}
        }
        return resultArray;
    }

    public static Character parserCharacterObject(JsonObject characterObject) throws ParserException{
        try {
            Character character = new Character(TYPE_CHARACTER, characterObject.get("name").getAsString(), characterObject.get("id").getAsString());
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

    public static ArrayList<BaseModel> parserEventsArray(String message){
        JsonObject jsonObject = parser.parse(message).getAsJsonObject();
        JsonObject data = jsonObject.getAsJsonObject("data");
        JsonArray dataArray = data.getAsJsonArray("results");
        ArrayList<BaseModel> resultArray = new ArrayList<>();
        for(int i = 0; i< dataArray.size(); i++){
            try {
                resultArray.add(parserEventObject(dataArray.get(i).getAsJsonObject()));
            } catch (ParserException e) {}
        }
        return resultArray;
    }

    public static Event parserEventObject(JsonObject characterObject) throws ParserException{
        try {
            Event event = new Event(TYPE_EVENT, characterObject.get("title").getAsString(), characterObject.get("id").getAsString());
            event.setDescription(characterObject.get("description").getAsString());
            JsonObject thumbs = characterObject.getAsJsonObject("thumbnail");
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
