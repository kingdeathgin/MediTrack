package com.example.meditrack;

import java.util.Random;

public class RandomString {

    private final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String NUMBER = "1234567890";

    private final char[] totalnumber = (LETTERS+LETTERS.toUpperCase()+NUMBER).toCharArray();

    public String generateAlphabetNumber (int length) {
        StringBuilder result = new StringBuilder();
        for( int i=0; i<length ; i++){
            result.append(totalnumber[new Random().nextInt(totalnumber.length)]);
        }
        return result.toString();
    }


}
