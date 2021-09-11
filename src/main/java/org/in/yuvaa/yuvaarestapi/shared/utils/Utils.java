package org.in.yuvaa.yuvaarestapi.shared.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new Random();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String randomPublicId(int length) {
        return generateRandomPublicId(length);
    }

    private String generateRandomPublicId(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(returnValue);
    }
}
