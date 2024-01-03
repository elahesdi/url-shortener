package com.ela.springbootredis.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Url")
public class ShortUrl implements Serializable {
  public ShortUrl(String url, String shortUrl) {
    this.url = url;
    this.shortUrl = shortUrl;
  }

  public ShortUrl() {
  }
  @Id
  String url;
  String shortUrl;

}
