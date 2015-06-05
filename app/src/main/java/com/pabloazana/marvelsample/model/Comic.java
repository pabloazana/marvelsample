package com.pabloazana.marvelsample.model;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;

/**
 * Created by pablo-azana on 20/05/15.
 */

public class Comic extends RecycleBaseModel{

    public static final int COMIC_TYPE = 2;

    private String name;
    private String description;
    private String thumbnailURI;

    public Comic(String id) {
        super(COMIC_TYPE, id);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnailURI(String thumbnailURI) {
        this.thumbnailURI = thumbnailURI;
    }

    public String getName() {
        return name;
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
}
