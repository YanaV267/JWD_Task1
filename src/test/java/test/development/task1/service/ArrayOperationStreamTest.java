package test.development.task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.impl.ArrayParserImpl;
import com.development.task1.reader.impl.ArrayReaderImpl;
import com.development.task1.service.impl.ArrayOperationStreamImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayOperationStreamTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());
    private final ArrayOperationStreamImpl arrayOperation = new ArrayOperationStreamImpl();
    private CustomArray customArray;

    @BeforeTest
    public void init() {
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        ArrayParserImpl arrayParser = new ArrayParserImpl();
        try {
            String[] readNumbers = arrayReader.readNumbers("data/numbers.txt");
            customArray = arrayParser.parseNumber(readNumbers);
        } catch (CustomArrayException exception) {
            LOGGER.error("error of extracting numbers: " + exception.getMessage());
        }
    }

    @Test
    public void findMinNumber() throws CustomArrayException {
        double expected = 5;
        double actual = arrayOperation.findMinNumber(customArray);
        Assert.assertEquals(actual, expected, "min number is invalid");
    }

    @Test
    public void findMaxNumber() throws CustomArrayException {
        double expected = 18;
        double actual = arrayOperation.findMaxNumber(customArray);
        Assert.assertEquals(actual, expected, "max number is invalid");
    }

    @Test
    public void replaceInPosition() {
        double newValue = 11;
        int position = 3;
        customArray = arrayOperation.replaceInPosition(customArray, position, newValue);
        Assert.assertEquals(customArray.getArray()[position], newValue, "replacement is invalid");
    }

    @Test
    public void countPositiveNumbers() {
        double expected = 3;
        double actual = arrayOperation.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected, "positive numbers amount is invalid");
    }

    @Test
    public void countNegativeNumbers() {
        double expected = 1;
        double actual = arrayOperation.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected, "negative numbers amount is invalid");
    }

    @Test
    public void calculateAverageValue() {
        double expected = 4.5;
        double actual = arrayOperation.calculateAverageValue(customArray);
        Assert.assertEquals(actual, expected, "average value of numbers is invalid");
    }

    @Test
    public void calculateSummaryValue() {
        double expected = 15;
        double actual = arrayOperation.calculateSummaryValue(customArray);
        Assert.assertEquals(actual, expected, "summary of numbers is invalid");
    }
}
