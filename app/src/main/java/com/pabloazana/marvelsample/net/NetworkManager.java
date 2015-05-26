package com.pabloazana.marvelsample.net;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;


/**
 * Created by pablo-azana on 23/05/15.
 */


public class NetworkManager {

    private RequestQueue requestQueue;

    public NetworkManager(Context context){
        requestQueue = Volley.newRequestQueue(context);
    }

    public void addRequest(BaseRequest request){
        requestQueue.add(createVolleyRequest(request, null));
    }

    public Request createVolleyRequest(final BaseRequest request, Response.ErrorListener errorListener){
        return new Request<CustomNetworkResponse>(request.getMethod(), request.getUrl(), errorListener) {
            @Override
            protected Response parseNetworkResponse(NetworkResponse response) {
                String charSet = HttpHeaderParser.parseCharset(response.headers);
                try {
                    return Response.success(new CustomNetworkResponse(response.statusCode, new String(response.data, charSet), response.headers), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new VolleyError(e));
                }
            }

            @Override
            protected void deliverResponse(CustomNetworkResponse response) {
                request.deliverResponse(response);
            }
        };
    }


















}
