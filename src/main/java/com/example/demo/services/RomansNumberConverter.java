package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RomansNumberConverter {

    public String convertNumberToRoman(Integer number) {
        if(number < 4000 && number > 0)
            return toRoman(number);
        else
            return "Invalid number";
    }

    public Integer convertRomanToNumber(String str) {
        Pattern pattern = Pattern.compile("[XMXVCLI]*");
        Matcher matcher = pattern.matcher(str.toUpperCase());
        if(matcher.matches())
            return toNumber(str.toUpperCase());
        else
            return -1;
    }

    private static String toRoman(Integer number) {
        return String.valueOf(new char[number]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    private static Integer toNumber(String roman) {
        return roman.replace("CM", "DCD")
                .replace("M", "DD")
                .replace("CD", "CCCC")
                .replace("D", "CCCCC")
                .replace("XC", "LXL")
                .replace("C", "LL")
                .replace("XL", "XXXX")
                .replace("L", "XXXXX")
                .replace("IX", "VIV")
                .replace("X", "VV")
                .replace("IV", "IIII")
                .replace("V", "IIIII").length();
    }

}
