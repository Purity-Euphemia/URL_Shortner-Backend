package com.UrlShortner.util;

import java.security.SecureRandom;

public class KeyGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;
    private static final SecureRandom random = new SecureRandom();

    public static String generateKey(){
        StringBuilder builder = new StringBuilder(LENGTH);
        for(int count = 0; count < LENGTH; count++){
            int index = random.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(index));
        }
        return builder.toString();
    }
}
