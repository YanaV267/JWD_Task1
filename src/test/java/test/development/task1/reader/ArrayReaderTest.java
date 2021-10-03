package test.development.task1.reader;

import com.development.task1.exception.CustomArrayException;
import com.development.task1.reader.impl.ArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayReaderTest {

    @Test
    public void readNumbers() throws CustomArrayException {
        String expected = "18";
        ArrayReaderImpl numberReader = new ArrayReaderImpl();
        String[] readNumbers = numberReader.readNumbers("data/numbers.txt");
        Assert.assertEquals(readNumbers[0], expected);
    }
}
