package com.yash.shortly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.shortly.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
	
	Optional<Url> findByShortUrl(String shortUrl);

	boolean existsByShortUrl(String shortUrl);
}
