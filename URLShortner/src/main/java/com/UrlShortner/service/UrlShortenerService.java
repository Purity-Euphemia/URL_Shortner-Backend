package com.UrlShortner.service;

import com.UrlShortner.data.model.UrlMapping;
import com.UrlShortner.data.repository.UrlMappingRepository;
import com.UrlShortner.dtos.Request.UrlShortenRequest;
import com.UrlShortner.dtos.Response.UrlShortenResponse;
import com.UrlShortner.util.KeyGenerator;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
    private final String BASE_URL = "http://localhost:8080/";
    private final UrlMappingRepository repository;

    public UrlShortenerService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public UrlShortenResponse shortenUrl(UrlShortenRequest request) {
        String shortKey;

        do {
            shortKey = KeyGenerator.generateKey();
        } while (repository.existsById(shortKey));

        UrlMapping mapping = new UrlMapping(shortKey, request.getUrl());
        repository.save(mapping);

        return new UrlShortenResponse(BASE_URL + shortKey);
    }

    public String getOriginalUrl(String shortKey) {
        UrlMapping mapping = repository.findById(shortKey).map(UrlMapping::getOriginalUrl).orElseThrow(() -> new RuntimeException("Url not found"));
        return mapping.getOriginalUrl();
    }
}
