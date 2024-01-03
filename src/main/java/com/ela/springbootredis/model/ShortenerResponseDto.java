package com.ela.springbootredis.model;

public class ShortenerResponseDto {

    private String long_url;
    private String short_url;

    private String hash;


    public ShortenerResponseDto() {
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
