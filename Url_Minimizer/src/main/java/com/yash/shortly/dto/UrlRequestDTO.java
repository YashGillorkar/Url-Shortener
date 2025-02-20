package com.yash.shortly.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class UrlRequestDTO {

    @NotNull(message = "Original URL cannot be null")
    @URL(message = "Invalid URL format")
    private String longUrl;

    private String customShortUrl; // Optional: For custom short URLs (only for logged-in users)
}
