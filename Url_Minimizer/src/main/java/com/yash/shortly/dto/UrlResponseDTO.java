package com.yash.shortly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlResponseDTO {
    private String longUrl;
    private String shortUrl;
}
