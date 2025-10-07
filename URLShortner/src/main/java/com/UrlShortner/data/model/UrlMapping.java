package com.UrlShortner.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "url_mapping")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlMapping {
    @Id
    private String shortKey;
    private String originalUrl;

}
