package task1.reader;

import com.development.task1.entity.CustomArray;
import com.development.task1.exception.CustomArrayException;
import com.development.task1.reader.impl.ArrayReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberReaderTest {
    static final Logger LOGGER = LogManager.getLogger(CustomArray.class.getSimpleName());

    @Test
    public void readNumbers() throws CustomArrayException {
        String expected = "18";
        ArrayReaderImpl numberReader = new ArrayReaderImpl();
        String[] readNumbers = numberReader.readNumbers("src/main/resources/data/numbers.txt");
        Assert.assertEquals(readNumbers[0], expected);
        LOGGER.info("тест извлечения чисел из файла прошёл успешно");
    }
}
