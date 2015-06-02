package com.pabloazana.marvelsample.model;

/**
 * Created by pablo-azana on 28/05/15.
 */
public class Character extends BaseModel{


    private String description;
    private String thumbnailURI;

    public Character(modelType type, String name, String id) {
        super(type, name, id);
    }

    public void setDescription(String description) {
        if("".equals(description))
            this.description = "Ups! Looks like there is not description for this character";
        else this.description = description;
    }

    public void setThumbnailURI(String thumbnailURI) {
        this.thumbnailURI = thumbnailURI;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailURI() {
        return thumbnailURI;
    }
}
