package com.development.task1.service.impl;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.service.ArrayOperation;
import com.development.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.DoubleStream;

public class ArrayOperationImpl implements ArrayOperation {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Override
    public double findMinNumber(CustomArray customArray) throws CustomArrayException {
        return DoubleStream.of(customArray.getArray())
                .min()
                .orElseThrow(CustomArrayException::new);
    }

    @Override
    public double findMaxNumber(CustomArray customArray) throws CustomArrayException {
        return DoubleStream.of(customArray.getArray())
                .max()
                .orElseThrow(CustomArrayException::new);
    }

    @Override
    public CustomArray replaceInPosition(CustomArray customArray, int position, double newValue) {
        ArrayValidatorImpl arrayValidator = new ArrayValidatorImpl();
        if (!arrayValidator.checkPosition(customArray, position)) {
            LOGGER.error(" position is out of range for current array");
        }
        double value = customArray.getArray()[position];
        customArray.setArray(DoubleStream.of(customArray.getArray()).map(num -> num == value? newValue:num).toArray());
        return customArray;
    }

    @Override
    public double countPositiveNumbers(CustomArray customArray) {
        return DoubleStream.of(customArray.getArray())
                .filter(num -> num > 0)
                .count();
    }

    @Override
    public double countNegativeNumbers(CustomArray customArray) {
        return DoubleStream.of(customArray.getArray())
                .filter(num -> num < 0)
                .count();
    }

    @Override
    public double calculateAverageValue(CustomArray customArray) {
        return calculateSummaryValue(customArray) / DoubleStream.of(customArray.getArray()).count();
    }

    @Override
    public double calculateSummaryValue(CustomArray customArray) {
        return DoubleStream.of(customArray.getArray()).sum();
    }
}
