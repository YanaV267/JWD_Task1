package com.development.task1.parser.impl;

import com.development.task1.creator.impl.ArrayCreatorImpl;
import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.ArrayParser;
import com.development.task1.validator.ArrayValidator;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser {
    private final ArrayCreatorImpl arrayCreator = new ArrayCreatorImpl();

    @Override
    public CustomArray parseNumber(String[] numberValues) throws CustomArrayException {
        if (numberValues == null) {
            throw new CustomArrayException("File is empty. No data was found in it.");
        }
        double[] tempArray = new double[numberValues.length];
        int index = 0;
        for (String numberValue : numberValues) {
            if (ArrayValidator.checkNumberValue(numberValue)) {
                tempArray[index++] = Double.parseDouble(numberValue);
            }
        }
        return arrayCreator.createArray(Arrays.copyOf(tempArray, index));
    }
}
