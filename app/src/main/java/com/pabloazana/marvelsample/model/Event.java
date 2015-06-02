package com.pabloazana.marvelsample.model;

/**
 * Created by pablo-azana on 3/06/15.
 */
public class Event extends BaseModel {

    private String description;
    private String thumbnail;

    public Event(modelType type, String name, String id) {
        super(type, name, id);
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
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
