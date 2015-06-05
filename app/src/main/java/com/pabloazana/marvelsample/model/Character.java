package com.pabloazana.marvelsample.model;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;

/**
 * Created by pablo-azana on 28/05/15.
 */

public class Character extends RecycleBaseModel{

    public static final int CHARACTER_TYPE = 2;

    private String name;
    private String description;
    private String thumbnailURI;


    public Character(String id) {
        super(CHARACTER_TYPE, id);
    }

    public void setDescription(String description) {
        if("".equals(description))
            this.description = "Ups! Looks like there is not description for this character";
        else this.description = description;
    }

    public void setThumbnailURI(String thumbnailURI) {
        this.thumbnailURI = thumbnailURI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailURI() {
        return thumbnailURI;
    }

    public String getName() {
        return name;
    }
}
