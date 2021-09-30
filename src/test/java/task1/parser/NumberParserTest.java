package task1.parser;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.parser.impl.ArrayParserImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Test
    public void parseNumber() throws CustomArrayException {
        double expected = 18;
        String[] actualNumbers = {"15", "0..5", "-3"};
        ArrayParserImpl arrayParser = new ArrayParserImpl();
        CustomArray customArray = arrayParser.parseNumber(actualNumbers);
        Assert.assertEquals(customArray.getArray()[0], expected);
        LOGGER.info("тест извлечения чисел из файла прошёл успешно");
    }
}
