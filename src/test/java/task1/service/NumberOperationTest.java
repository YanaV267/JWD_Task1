package task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.impl.ArrayParserImpl;
import com.development.task1.reader.impl.ArrayReaderImpl;
import com.development.task1.service.impl.ArrayOperationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOperationTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());
    private final ArrayOperationImpl numberOperation = new ArrayOperationImpl();
    private CustomArray customArray;

    {
        ArrayReaderImpl numberReader = new ArrayReaderImpl();
        ArrayParserImpl numberParser = new ArrayParserImpl();
        try {
            String[] readNumbers = numberReader.readNumbers("src/main/resources/data/numbers.txt");
            customArray = numberParser.parseNumber(readNumbers);
        } catch (CustomArrayException exception) {
            LOGGER.error("ошибка извлечения чисел " + exception.getMessage());
        }
    }

    @Test
    public void findMinNumber() {
        double expected = 5;
        double actual = numberOperation.findMinNumber(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест поиска минимального значения массива прошёл успешно");
    }

    @Test
    public void findMaxNumber() {
        double expected = 18;
        double actual = numberOperation.findMaxNumber(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест поиска максимального значения массива прошёл успешно");
    }

    @Test
    public void replaceInPosition() {
        double newValue = 14;
        int position = 3;
        customArray = numberOperation.replaceInPosition(customArray, position, newValue);
        Assert.assertEquals(customArray.getArray()[position], newValue);
        LOGGER.info("тест замены числа на определённой позиции в массиве прошёл успешно");
    }

    @Test
    public void countPositiveNumbers() {
        double expected = 3;
        double actual = numberOperation.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест подсчёта количества отрицательных чисел прошёл успешно");
    }

    @Test
    public void countNegativeNumbers() {
        double expected = 1;
        double actual = numberOperation.countPositiveNumbers(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест подсчёта количества отрицательных чисел прошёл успешно");
    }

    @Test
    public void calculateAverageValue() {
        double expected = 15;
        double actual = numberOperation.calculateAverageValue(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест подсчёта среднего значения элементов массива прошёл успешно");
    }

    @Test
    public void calculateSummaryValue() {
        double expected = 15;
        double actual = numberOperation.calculateSummaryValue(customArray);
        Assert.assertEquals(actual, expected);
        LOGGER.info("тест подсчёта суммы всех элементов массива прошёл успешно");
    }
}
