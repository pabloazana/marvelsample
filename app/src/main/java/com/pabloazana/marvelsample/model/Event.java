package com.pabloazana.marvelsample.model;

import com.pabloazana.multipleheaderrecyclerview.model.RecycleBaseModel;

/**
 * Created by pablo-azana on 3/06/15.
 */

public class Event extends RecycleBaseModel {

    public static final int EVENT_TYPE = 1;

    private String name;
    private String description;
    private String thumbnail;

    public Event(String id) {
        super(EVENT_TYPE, id);
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        if("".equals(description))
            this.description = "Ups! Looks like there is not description for this event";
        else this.description = description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
