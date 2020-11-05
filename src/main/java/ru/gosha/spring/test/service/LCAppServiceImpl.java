package ru.gosha.spring.test.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService{

    public final String LC_APP_FORMULA = "FLAME";

    @Override
    public String calculateLove(String userName, String crushName) {
        int userAndCrushNameCount = (userName + crushName).toCharArray().length;
        int formulaCount = LC_APP_FORMULA.toCharArray().length;
        int reminder = userAndCrushNameCount%formulaCount;
        char resultChar = LC_APP_FORMULA.charAt(reminder);

        String result = WhatsBetweenUs(resultChar);
        return result;
    }

    @Override
    public String WhatsBetweenUs(char calculationResult) {

        switch (calculationResult) {

            case ('F'):
                return LoveCalculatorConstants.F_CHAR_MEANING;
            case ('L'):
                return LoveCalculatorConstants.L_CHAR_MEANING;
            case ('A'):
                return LoveCalculatorConstants.A_CHAR_MEANING;
            case ('M'):
                return LoveCalculatorConstants.M_CHAR_MEANING;
            case ('E'):
                return LoveCalculatorConstants.E_CHAR_MEANING;
            default:
                return null;
        }
    }


}
