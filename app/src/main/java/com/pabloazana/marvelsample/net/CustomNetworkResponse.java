package com.pabloazana.marvelsample.net;

import java.util.Map;

/**
 * Created by pablo-azana on 23/05/15.
 */
public class CustomNetworkResponse {

    public final int statusCode;
    public final String message;
    public final Map<String, String> headers;

    public CustomNetworkResponse(int statusCode, String message, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.message = message;
        this.headers = headers;
    }

}
