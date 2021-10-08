package test.development.task1.service;

import com.development.task1.entity.CustomArray;
import com.development.task1.service.impl.ArraySortingImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArraySortingTest {
    private ArraySortingImpl arraySorting;
    private CustomArray customArray;

    @BeforeTest
    public void init() {
        arraySorting = new ArraySortingImpl();
        customArray = new CustomArray(9, -4, 0, 17, 2.4);
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
