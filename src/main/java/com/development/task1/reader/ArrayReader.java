package com.development.task1.reader;

import com.development.task1.exception.CustomArrayException;

public interface ArrayReader {
    String[] readNumbers(String path) throws CustomArrayException;
}
