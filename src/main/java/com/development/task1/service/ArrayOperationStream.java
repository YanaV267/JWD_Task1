package com.development.task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;

public interface ArrayOperationStream {
    double findMinNumber(CustomArray customArray) throws CustomArrayException;
    double findMaxNumber(CustomArray customArray) throws CustomArrayException;
    CustomArray replaceInPosition(CustomArray customArray, int position, double newValue);
    double calculateAverageValue(CustomArray customArray);
    double calculateSummaryValue(CustomArray customArray);
    double countPositiveNumbers(CustomArray customArray);
    double countNegativeNumbers(CustomArray customArray);
}
