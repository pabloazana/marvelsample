package com.pabloazana.multipleheaderrecyclerview.model;

/**
 * Created by pablo-azana on 3/06/15.
 */

public abstract class RecycleBaseModel {

    public int type;
    public String id;

    public RecycleBaseModel(int type, String id){
        this.type = type;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getId(){
        return id;
    }

    public boolean equals(RecycleBaseModel o) {
        return (this.id.equals(o.getId()));
    }
}
