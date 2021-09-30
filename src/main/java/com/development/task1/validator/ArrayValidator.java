package com.development.task1.validator;

import com.development.task1.entity.CustomArray;

import java.io.File;

public class ArrayValidator {
    private static final String NUMBER_REGEX = "[-]?\\d+\\.?\\d*";

    private ArrayValidator() {
    }

    public static boolean checkNumberValue(String numberValue) {
        return numberValue.matches(NUMBER_REGEX);
    }

    public static boolean checkSize(String[] numberArray) {
        return numberArray.length != 0;
    }

    public static boolean checkSize(CustomArray array) {
        return array.getArray().length != 0;
    }

    public static boolean checkArray(CustomArray array, int index) {
        return array.getArray()[index] != 0;
    }

    public static boolean checkPosition(CustomArray array, int position) {
        return position >= 0 && position < array.getArray().length;
    }

    public static boolean checkFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
