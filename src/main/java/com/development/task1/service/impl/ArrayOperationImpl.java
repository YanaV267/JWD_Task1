package com.development.task1.service.impl;

import com.development.task1.entity.CustomArray;
import com.development.task1.service.ArrayOperation;
import com.development.task1.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayOperationImpl implements ArrayOperation {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Override
    public double findMinNumber(CustomArray customArray) {
        double minValue = customArray.getArray()[0];
        for (int i = 1; i < customArray.getArray().length && ArrayValidator.checkArray(customArray, i); i++) {
            if (customArray.getArray()[i] < minValue) {
                minValue = customArray.getArray()[i];
            }
        }
        return minValue;
    }

    @Override
    public double findMaxNumber(CustomArray customArray) {
        double maxValue = ArrayValidator.checkArray(customArray, 0) ? customArray.getArray()[0] : 0;
        for (int i = 1; i < customArray.getArray().length && ArrayValidator.checkArray(customArray, i); i++) {
            if (customArray.getArray()[i] > maxValue) {
                maxValue = customArray.getArray()[i];
            }
        }
        return maxValue;
    }

    @Override
    public CustomArray replaceInPosition(CustomArray customArray, int position, double newValue) {
        if (!ArrayValidator.checkPosition(customArray, position)) {
            LOGGER.error(" заданная позиция не входит в диапазон допустимых для данного массива");
        } else {
            double[] array = customArray.getArray();
            array[position] = newValue;
            customArray.setArray(array);
        }
        return customArray;
    }

    @Override
    public double countPositiveNumbers(CustomArray customArray) {
        double amount = 0;
        for (int i = 0; i < customArray.getArray().length && ArrayValidator.checkArray(customArray, i); i++) {
            if (customArray.getArray()[i] > 0) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public double countNegativeNumbers(CustomArray customArray) {
        double amount = 0;
        for (int i = 0; i < customArray.getArray().length && ArrayValidator.checkArray(customArray, i); i++) {
            if (customArray.getArray()[i] < 0) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public double calculateAverageValue(CustomArray customArray) {
        double result = calculateSummaryValue(customArray);
        if (!ArrayValidator.checkSize(customArray)) {
            result = 0;
        } else {
            result /= customArray.getArray().length;
        }
        return result;
    }

    @Override
    public double calculateSummaryValue(CustomArray customArray) {
        double result = 0;
        for (int i = 0; i < customArray.getArray().length && ArrayValidator.checkArray(customArray, i); i++) {
            result += customArray.getArray()[i];
        }
        return result;
    }
}
