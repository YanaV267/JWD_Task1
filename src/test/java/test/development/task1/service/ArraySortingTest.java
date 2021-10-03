package test.development.task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.impl.ArrayParserImpl;
import com.development.task1.reader.impl.ArrayReaderImpl;
import com.development.task1.service.impl.ArraySortingImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArraySortingTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());
    private final ArraySortingImpl arraySorting = new ArraySortingImpl();
    private CustomArray customArray;

    @BeforeTest
    public void init() {
        ArrayReaderImpl numberReader = new ArrayReaderImpl();
        ArrayParserImpl numberParser = new ArrayParserImpl();
        try {
            String[] readNumbers = numberReader.readNumbers("data/numbers.txt");
            customArray = numberParser.parseNumber(readNumbers);
        } catch (CustomArrayException exception) {
            LOGGER.error("error of extracting numbers " + exception.getMessage());
        }
    }

    @Test
    public void selectionSort(){
        double[] array = arraySorting.selectionSort(customArray.getArray());
        double expected = 18;
        double actual = array[0];
        Assert.assertEquals(actual, expected, "selection sort is invalid");
    }

    @Test
    public  void bubbleSort(){
        double[] array = arraySorting.bubbleSort(customArray.getArray());
        double expected = -8;
        double actual = array[0];
        Assert.assertEquals(actual, expected, "bubble sort is invalid");
    }

    @Test
    public void insertionSort(){
        double[] array = arraySorting.insertionSort(customArray.getArray());
        double expected = 0;
        double actual = array[0];
        Assert.assertEquals(actual, expected, "insertion sort is invalid");
    }
}
