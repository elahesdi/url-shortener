package com.ela.springbootredis.controller;

import com.ela.springbootredis.config.UrlShortenerConfig;
import com.ela.springbootredis.entity.ShortUrl;
import com.ela.springbootredis.model.RequestDto;
import com.ela.springbootredis.model.ResponseDto;
import com.ela.springbootredis.model.ShortenerResponseDto;
import com.ela.springbootredis.repo.ShortUrlRepo;
import com.ela.springbootredis.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

@RestController
public class UrlController {

  @Autowired
  ShortUrlRepo shortUrlRepo;
  final UrlShortenerConfig urlShortenerConfig;
  @Autowired
  ShortUrlService shortUrlService;

  public UrlController(UrlShortenerConfig urlShortenerConfig) {
    this.urlShortenerConfig = urlShortenerConfig;
  }


  @PostMapping("/")
  public ResponseDto saveUrlData(@RequestBody RequestDto requestDto) throws UnknownHostException {
    ShortUrl shortUrl = shortUrlService.getUrlById(requestDto.getUrl());
    if(shortUrl != null){
      System.out.println("Cached");
      return new ResponseDto(shortUrl.getUrl(), shortUrl.getShortUrl(), true);
    }else{
      System.out.println("Not Cached");
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.set("apiKey", urlShortenerConfig.getKey());
      HttpEntity<String> request = new HttpEntity<>(requestDto.getUrl(), headers);
      ResponseEntity<ShortenerResponseDto> response = restTemplate
              .exchange(urlShortenerConfig.getURLShortener(), HttpMethod.POST, request, ShortenerResponseDto.class);
      shortUrlRepo.save(new ShortUrl(requestDto.getUrl(), response.getBody().getShort_url()));
      return new ResponseDto(response.getBody().getLong_url(), response.getBody().getShort_url(), false);
    }
  }
}
