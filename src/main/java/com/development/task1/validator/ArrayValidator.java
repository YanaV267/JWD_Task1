package com.development.task1.validator;

import com.development.task1.entity.CustomArray;

public class ArrayValidator {
    private static final String NUMBER_REGEX = "[-]?\\d+\\.?\\d*";

    private ArrayValidator() {
    }

    public static boolean checkNumberValue(String numberValue) {
        return numberValue.matches(NUMBER_REGEX);
    }

    public static boolean checkPosition(CustomArray array, int position) {
        return position >= 0 && position < array.getArray().length;
    }
}
