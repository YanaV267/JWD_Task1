package com.development.task1.validator.impl;

import com.development.task1.entity.CustomArray;
import com.development.task1.validator.ArrayValidator;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final ArrayValidatorImpl instance = new ArrayValidatorImpl();

    private static final String NUMBER_REGEX = "[-]?\\d+\\.?\\d*";

    private ArrayValidatorImpl(){

    }

    public static ArrayValidatorImpl getInstance(){
        return instance;
    }

    @Override
    public boolean checkNumberValue(String numberValue) {
        return numberValue.matches(NUMBER_REGEX);
    }

    @Override
    public boolean checkPosition(CustomArray array, int position) {
        return position >= 0 && position < array.getArray().length;
    }
}
