package com.UrlShortner.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "url_mapping")
@Data
public class UrlMapping {
    @Id
    private String shortKey;
    private String originalUrl;
}
