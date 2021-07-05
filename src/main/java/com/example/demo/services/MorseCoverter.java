package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCoverter {

    private static HashMap<String, String> values = insertValues(new HashMap<String, String>());

    private static HashMap<String, String> insertValues(HashMap<String, String> values) {
        values.put(".-", "A");
        values.put("-...", "B");
        values.put("-.-.", "C");
        values.put("-..", "D");
        values.put(".", "E");
        values.put("..-.", "F");
        values.put("--.", "G");
        values.put("....", "H");
        values.put("..", "I");
        values.put(".---", "J");
        values.put("-.-", "K");
        values.put(".-..", "L");
        values.put("--", "M");
        values.put("-.", "N");
        values.put("---", "O");
        values.put(".--.", "P");
        values.put("--.-", "Q");
        values.put(".-.", "R");
        values.put("...", "S");
        values.put("-", "T");
        values.put("..-", "U");
        values.put("...-", "V");
        values.put(".--", "W");
        values.put("-..-", "X");
        values.put("-.--", "Y");
        values.put("--..", "Z");
        values.put(".----", "1");
        values.put("..---", "2");
        values.put("...--", "3");
        values.put("....-", "4");
        values.put(".....", "5");
        values.put("-....", "6");
        values.put("--...", "7");
        values.put("---..", "8");
        values.put("----.", "9");
        values.put("-----", "0");
        return values;
    }

    public static String convertMorseToString(String morseCode){
        String[] codes = morseCode.split(" ");
        String[] sentence = new String[codes.length];
        for (int i=0; i < codes.length; i++) {
            if (codes[i].isBlank()) {
                sentence[i] = " ";
            } else {
                for(Map.Entry<String, String> el : values.entrySet()) {
                    if(el.getKey().compareTo(codes[i]) == 0) {
                        sentence[i] = el.getValue();
                    }
                }
            }
        }
        return String.join("", sentence);
    }
}
