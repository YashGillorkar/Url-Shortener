package com.yash.shortly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.shortly.dto.UrlRequestDTO;
import com.yash.shortly.dto.UrlResponseDTO;
import com.yash.shortly.entity.Url;
import com.yash.shortly.entity.User;
import com.yash.shortly.repository.UrlRepository;
import com.yash.shortly.repository.UserRepository;
import com.yash.shortly.service.UrlServiceI;
import com.yash.shortly.utils.UrlShorteningUtil;

@Service
public class UrlServiceImpl implements UrlServiceI {

	@Autowired
	private UrlRepository urlRepository;
	@Autowired
	private UserRepository userRepository;

	public UrlResponseDTO shortenUrl(UrlRequestDTO request, String username) {
		String shortUrl = (request.getCustomShortUrl() != null) ? request.getCustomShortUrl()
				: UrlShorteningUtil.generateShortUrl();
		if (urlRepository.existsByShortUrl(shortUrl)) {
		    throw new RuntimeException("Short URL already exists. Please choose a different one.");
		}
		User user = username != null ? userRepository.findByUsername(username).orElseThrow() : null;
		Url url = new Url(null, request.getLongUrl(), shortUrl, user);
		urlRepository.save(url);
		return new UrlResponseDTO(shortUrl, request.getLongUrl());
	}

	public String getOriginalUrl(String shortUrl) {
	    return urlRepository.findByShortUrl(shortUrl)
	        .map(Url::getLongUrl)
	        .orElseThrow(() -> new RuntimeException("Short URL not found"));
	}


}
