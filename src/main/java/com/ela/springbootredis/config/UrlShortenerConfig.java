package com.ela.springbootredis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "api")
public class UrlShortenerConfig {
    private String URLShortener;
    private String key;

    public String getURLShortener() {
        return URLShortener;
    }

    public void setURLShortener(String URLShortener) {
        this.URLShortener = URLShortener;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
