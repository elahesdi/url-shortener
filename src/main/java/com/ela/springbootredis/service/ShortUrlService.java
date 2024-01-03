package com.ela.springbootredis.service;

import com.ela.springbootredis.entity.ShortUrl;
import com.ela.springbootredis.repo.ShortUrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

  @Autowired
  ShortUrlRepo shortUrlRepo;

  @Cacheable(value = "urlCache")
  public ShortUrl getUrlById(String url) {
    System.out.println("Calling repo for url");
    return shortUrlRepo.findById(url).orElse(null
    );
  }

}
