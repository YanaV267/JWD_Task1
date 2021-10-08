package com.development.task1.parser.impl;

import com.development.task1.creator.impl.ArrayCreatorImpl;
import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.ArrayParser;
import com.development.task1.validator.impl.ArrayValidatorImpl;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser {

    @Override
    public CustomArray parseNumber(String[] numberValues) throws CustomArrayException {
        if (numberValues == null) {
            throw new CustomArrayException("File is empty. No data was found in it.");
        }
        ArrayCreatorImpl arrayCreator = new ArrayCreatorImpl();
        double[] tempArray = new double[numberValues.length];
        int index = 0;
        for (String numberValue : numberValues) {
            if (ArrayValidatorImpl.getInstance().checkNumberValue(numberValue)) {
                tempArray[index++] = Double.parseDouble(numberValue);
            }
        }
        return arrayCreator.createArray(Arrays.copyOf(tempArray, index));
    }
}
