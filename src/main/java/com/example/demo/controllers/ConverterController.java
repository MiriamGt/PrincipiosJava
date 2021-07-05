package com.example.demo.controllers;

import com.example.demo.services.MorseCoverter;
import com.example.demo.services.RomansNumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/converter")
public class ConverterController {

    @Autowired
    private RomansNumberConverter romansConverter;
    private MorseCoverter morseConverter;

    @GetMapping("/number-to-roman")
    public String numberToRoman(@RequestParam Integer number) {
        return romansConverter.convertNumberToRoman(number);
    }

    @GetMapping("/roman-to-number")
    public Integer romanToNumber(@RequestParam String roman) {
        return romansConverter.convertRomanToNumber(roman);
    }

    @GetMapping("/morse-converter")
    public String morseConverter(@RequestParam String str) {
        return morseConverter.convertMorseToString(str);
    }
}
