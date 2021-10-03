package com.development.task1.validator;

import com.development.task1.entity.CustomArray;

public interface ArrayValidator {
    boolean checkNumberValue(String numberValue);
    boolean checkPosition(CustomArray array, int position);
}
