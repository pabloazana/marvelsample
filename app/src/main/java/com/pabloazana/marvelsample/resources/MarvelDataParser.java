package com.pabloazana.marvelsample.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pabloazana.marvelsample.model.BaseModel;
import com.pabloazana.marvelsample.model.Comic;


import java.util.ArrayList;

import static com.pabloazana.marvelsample.model.BaseModel.modelType.TYPE_COMIC;

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
            if(comicObject.get("description") != null) comic.setDescription(comicObject.get("description").getAsString());
            JsonObject thumbs = comicObject.getAsJsonObject("thumbnail");
            String thumbnailURL = thumbs.get("path").getAsString() + "." + thumbs.get("extension").getAsString();
            comic.setThumbnailURI(thumbnailURL);
            return comic;
        }catch (Exception e){
            throw new ParserException(e);
        }
    }


}
