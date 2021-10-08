package com.development.task1.service;

import com.development.task1.entity.CustomArray;

public interface ArrayOperationStream {
    double findMinNumber(CustomArray customArray);
    double findMaxNumber(CustomArray customArray);
    CustomArray replaceInPosition(CustomArray customArray, int position, double newValue);
    double calculateAverageValue(CustomArray customArray);
    double calculateSummaryValue(CustomArray customArray);
    double countPositiveNumbers(CustomArray customArray);
    double countNegativeNumbers(CustomArray customArray);
}
