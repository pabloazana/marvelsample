package com.pabloazana.marvelsample.net;

/**
 * Created by pablo-azana on 23/05/15.
 */
public class BaseRequest {

    private int method;
    private String url;
    RequestListener listener;

    public BaseRequest(int method, String url, RequestListener listener){
        this.method = method;
        this.url = url;
        this.listener = listener;
    }

    public int getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public void deliverResponse(CustomNetworkResponse response){
        listener.onResponde(response);
    }
}
