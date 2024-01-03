package com.ela.springbootredis.repo;

import com.ela.springbootredis.entity.ShortUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepo extends CrudRepository<ShortUrl, String> {

}

