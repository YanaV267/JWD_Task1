package com.development.task1.reader.impl;

import com.development.task1.exception.CustomArrayException;
import com.development.task1.reader.ArrayReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ArrayReaderImpl implements ArrayReader {
    private static final String DELIMITER = "/";

    @Override
    public String[] readNumbers(String path) throws CustomArrayException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new CustomArrayException("file " + path + " doesn't exits in this directory");
        }
        String[] arrayOfNumbers;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            arrayOfNumbers = reader.lines()
                    .findFirst()
                    .map(line -> line.split(DELIMITER)).orElse(null);
        } catch (IOException exception) {
            throw new CustomArrayException("error was found while reading " + path, exception);
        }
        return arrayOfNumbers;
    }
}
