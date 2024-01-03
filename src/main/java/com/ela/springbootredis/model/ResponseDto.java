package com.ela.springbootredis.model;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ResponseDto {

    private String longUrl;
    private String shortUrl;
    private boolean isCached;
    private String hostName;


    public ResponseDto() {
    }

    public ResponseDto(String longUrl, String shortUrl, boolean isCached) throws UnknownHostException {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.isCached = isCached;
        this.hostName= InetAddress.getLocalHost().getHostName();
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean cached) {
        isCached = cached;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
