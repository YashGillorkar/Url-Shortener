package com.yash.shortly.service;

import com.yash.shortly.dto.UrlRequestDTO;
import com.yash.shortly.dto.UrlResponseDTO;

import jakarta.validation.Valid;

public interface UrlServiceI {

	UrlResponseDTO shortenUrl(@Valid UrlRequestDTO request, String username);

	String getOriginalUrl(String shortUrl);

}
