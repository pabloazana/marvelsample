package com.pabloazana.marvelsample.model;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class Comic extends BaseModel{


    private String description;
    private String thumbnailURI;

    public Comic(String name, modelType type, String id) {
        super(type, name, id);
    }

    public void setDescription(String description) {
        this.description = description;
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
