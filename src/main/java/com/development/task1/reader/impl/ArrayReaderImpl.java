package com.development.task1.reader.impl;

import com.development.task1.exception.CustomArrayException;
import com.development.task1.reader.ArrayReader;
import com.development.task1.validator.ArrayValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayReaderImpl implements ArrayReader {
    private static final String DELIMITER = "/";

    @Override
    public String[] readNumbers(String path) throws CustomArrayException {
        if (!ArrayValidator.checkFile(path)) {
            throw new CustomArrayException("файл " + path + " в заданной директории не существует");
        }
        String[] lineOfNumbers = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String fileData;
            while ((fileData = reader.readLine()) != null && lineOfNumbers == null) {
                lineOfNumbers = fileData.split(DELIMITER);
            }
        } catch (IOException exception) {
            throw new CustomArrayException("ошибка чтения файла " + path, exception);
        }
        return lineOfNumbers;
    }
}
