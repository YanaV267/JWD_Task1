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
        String[] lineOfNumbers = null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String fileData;
            if ((fileData = reader.readLine()) != null) {
                lineOfNumbers = fileData.split(DELIMITER);
            }
        } catch (IOException exception) {
            throw new CustomArrayException("error was found while reading " + path, exception);
        }
        return lineOfNumbers;
    }
}
