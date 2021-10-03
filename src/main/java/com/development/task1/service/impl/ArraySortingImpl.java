package com.development.task1.service.impl;

import com.development.task1.service.ArraySorting;

public class ArraySortingImpl implements ArraySorting {
    @Override
    public double[] selectionSort(double[] array) {
        for (int j = 0; j < array.length; j++) {
            double max = array[j];
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] > max) {
                    array[j] = array[i];
                    array[i] = max;
                    max = array[j];
                }
            }
        }
        return array;
    }

    @Override
    public double[] bubbleSort(double[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[j]) {
                    double num = array[j];
                    array[j] = array[i];
                    array[i] = num;
                }
            }
        }
        return array;
    }

    @Override
    public double[] insertionSort(double[] array) {
        for (int j = 1; j < array.length; j++) {
            double num = array[j];
            int i = j - 1;
            while (i >= 0 && num < array[i]) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = num;
        }
        return array;
    }
}
