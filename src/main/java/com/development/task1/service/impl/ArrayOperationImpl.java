package com.development.task1.service.impl;

import com.development.task1.entity.CustomArray;
import com.development.task1.service.ArrayOperation;
import com.development.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayOperationImpl implements ArrayOperation {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Override
    public double findMinNumber(CustomArray customArray) {
        double minValue = customArray.getArray().length == 0 ? 0 : customArray.getArray()[0];
        for (int i = 1; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] < minValue) {
                minValue = customArray.getArray()[i];
            }
        }
        return minValue;
    }

    @Override
    public double findMaxNumber(CustomArray customArray) {
        double maxValue = customArray.getArray().length == 0 ? 0 : customArray.getArray()[0];
        for (int i = 1; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] > maxValue) {
                maxValue = customArray.getArray()[i];
            }
        }
        return maxValue;
    }

    @Override
    public CustomArray replaceInPosition(CustomArray customArray, int position, double newValue) {
        if (ArrayValidatorImpl.getInstance().checkPosition(customArray, position)) {
            double[] array = customArray.getArray();
            array[position] = newValue;
            customArray.setArray(array);
        } else {
            LOGGER.error(" position is out of range for current array");
        }
        return customArray;
    }

    @Override
    public double countPositiveNumbers(CustomArray customArray) {
        double amount = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] > 0) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public double countNegativeNumbers(CustomArray customArray) {
        double amount = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] < 0) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public double calculateAverageValue(CustomArray customArray) {
        double result = calculateSummaryValue(customArray);
        if (customArray.getArray().length == 0) {
            result = 0;
        } else {
            result /= customArray.getArray().length;
        }
        return result;
    }

    @Override
    public double calculateSummaryValue(CustomArray customArray) {
        double result = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            result += customArray.getArray()[i];
        }
        return result;
    }
}
