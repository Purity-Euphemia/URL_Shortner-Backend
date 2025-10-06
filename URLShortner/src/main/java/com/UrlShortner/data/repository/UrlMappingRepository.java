package com.UrlShortner.data.repository;

import com.UrlShortner.data.model.UrlMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlMappingRepository extends MongoRepository<UrlMapping, String> {

}
