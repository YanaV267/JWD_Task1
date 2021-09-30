package com.development.task1.parser;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;

public interface ArrayParser {
    CustomArray parseNumber(String[] numberValues) throws CustomArrayException;
}
