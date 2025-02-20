package com.yash.shortly.utils;

import java.security.SecureRandom;
import java.util.Random;

public class UrlShorteningUtil {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 7;
    private static final Random RANDOM = new SecureRandom();

    /**
     * Generates a random short URL string of fixed length.
     *
     * @return A randomly generated short URL.
     */
    public static String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return shortUrl.toString();
    }
}
