package com.portablemind.app;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
public class Response {

    private String key;
    private String value;

    public Response() {}

    public Response(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
