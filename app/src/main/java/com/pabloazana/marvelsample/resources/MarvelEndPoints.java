package com.pabloazana.marvelsample.resources;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pablo-azana on 22/05/15.
 */
public class MarvelEndPoints {

    private static String BASE_URL = "http://gateway.marvel.com:80/v1/public/";
    private static String FORMAT_TYPE = "formatType=";
    private static String DATE_DESCRIPTOR = "dateDescriptor=";
    private static String ORDER_BY = "orderBy=";
    private static String LIMIT = "limit=";
    private static String OFFSET = "offset=";
    private static String API_KEY_STRING = "apikey=";
    private static String TS = "ts=";
    private static String HASH = "hash=";
    private static String COMICS_TYPE = "comics?";
    private static String API_KEY = "55cd4d518dbc152ccffdb394c1e92744";

    /* NEVER DO IT AT HOME!!!!! */
    private static String PRIVATE_KEY = "49df3bfe3653a4f8da93f71ccd134e7c2b78f981";


    public static String constructComicFeaturedURI() throws NoSuchAlgorithmException {
        long currentTime = System.currentTimeMillis();
        return BASE_URL + COMICS_TYPE + FORMAT_TYPE + "comic&" + DATE_DESCRIPTOR + "lastWeek&" + ORDER_BY + "-onsaleDate&" + LIMIT + "20&" + OFFSET + "0&" +
                API_KEY_STRING + API_KEY + "&" + TS + currentTime + "&" + HASH + getHash(currentTime + "");
    }


    public static String getHash(String currentTime) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        String pass = currentTime + PRIVATE_KEY + API_KEY;
        byte[] data = pass.getBytes();
        m.update(data,0,data.length);
        BigInteger i = new BigInteger(1,m.digest());
        return i.toString(16);
    }



}
