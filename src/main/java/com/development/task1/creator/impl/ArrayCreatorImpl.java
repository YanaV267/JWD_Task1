package com.development.task1.creator.impl;

import com.development.task1.creator.ArrayCreator;
import com.development.task1.entity.CustomArray;

public class ArrayCreatorImpl implements ArrayCreator {

    @Override
    public CustomArray createArray(double[] array) {
        return new CustomArray(array);
    }
}
