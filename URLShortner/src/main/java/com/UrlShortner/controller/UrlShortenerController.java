package com.UrlShortner.controller;

import com.UrlShortner.dtos.Request.UrlShortenRequest;
import com.UrlShortner.dtos.Response.UrlShortenResponse;
import com.UrlShortner.service.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shortener")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlShortenerController {
    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlShortenResponse> shortenUrl(@RequestBody UrlShortenRequest request){
        if (request.getUrl() == null || request.getUrl().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        UrlShortenResponse response = service.shortenUrl(request);
        return ResponseEntity.ok(response);
    }
}
