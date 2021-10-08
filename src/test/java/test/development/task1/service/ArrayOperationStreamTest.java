package test.development.task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.service.impl.ArrayOperationStreamImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayOperationStreamTest {
    private ArrayOperationStreamImpl arrayOperationStream;
    private CustomArray customArray;

    @BeforeTest
    public void init() {
        arrayOperationStream = new ArrayOperationStreamImpl();
        customArray = new CustomArray(9, -4, 0, 17, 2.4);
    }

    @Test
    public void findMinNumber() throws CustomArrayException {
        double expected = -4;
        double actual = arrayOperationStream.findMinNumber(customArray);
        Assert.assertEquals(actual, expected, "min number is invalid");
    }

    @Test
    public void findMaxNumber() throws CustomArrayException {
        double expected = 18;
        double actual = arrayOperationStream.findMaxNumber(customArray);
        Assert.assertEquals(actual, expected, "max number is invalid");
    }

    @Test
    public void replaceInPosition() {
        double newValue = 11;
        int position = 3;
        customArray = arrayOperationStream.replaceInPosition(customArray, position, newValue);
        Assert.assertEquals(customArray.getArray()[position], newValue, "replacement is invalid");
    }

    @Test
    public void countPositiveNumbers() {
        double expected = 3;
        double actual = arrayOperationStream.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected, "positive numbers amount is invalid");
    }

    @Test
    public void countNegativeNumbers() {
        double expected = 1;
        double actual = arrayOperationStream.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected, "negative numbers amount is invalid");
    }

    @Test
    public void calculateAverageValue() {
        double expected = 4.5;
        double actual = arrayOperationStream.calculateAverageValue(customArray);
        Assert.assertEquals(actual, expected, "average value of numbers is invalid");
    }

    @Test
    public void calculateSummaryValue() {
        double expected = 24.4;
        double actual = arrayOperationStream.calculateSummaryValue(customArray);
        Assert.assertEquals(actual, expected, "summary of numbers is invalid");
    }
}
