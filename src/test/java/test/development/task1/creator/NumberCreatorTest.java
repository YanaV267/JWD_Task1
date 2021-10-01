package test.development.task1.creator;

import com.development.task1.creator.impl.ArrayCreatorImpl;
import com.development.task1.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCreatorTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Test
    public void createNumber() {
        double expected = 7;
        ArrayCreatorImpl arrayCreator = new ArrayCreatorImpl();
        double[] actualArray = {4, 7, 3};
        CustomArray customArray = arrayCreator.createArray(actualArray);
        Assert.assertEquals(customArray.getArray()[1], expected);
        LOGGER.info("тест создания объекта массива прошёл успешно");
    }
}
