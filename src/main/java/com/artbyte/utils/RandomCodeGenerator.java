package com.artbyte.utils;

import java.security.SecureRandom;

public class RandomCodeGenerator {

    public static String generateSeatingCode(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();

        for(int i = 0; i < 30; i++){
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }
        return code.toString();
    }

}
