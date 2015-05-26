package com.pabloazana.marvelsample.model;

/**
 * Created by pablo-azana on 21/05/15.
 */

public class BaseModel {

    public enum modelType{
        TYPE_CHARACTER,
        TYPE_COMIC,
        TYPE_CREATOR
    }

    private modelType type;
    private String name;
    private String id;

    public BaseModel(modelType type, String name, String id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public modelType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
