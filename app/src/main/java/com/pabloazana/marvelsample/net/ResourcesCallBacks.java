package com.pabloazana.marvelsample.net;

import com.android.volley.Response;

/**
 * Created by pablo-azana on 23/05/15.
 */

public interface ResourcesCallBacks {

    interface ResourcesCallBack<T> extends Response.Listener<T> {
        void onResponse(T t);
    }

}
