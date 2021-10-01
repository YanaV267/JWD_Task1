package test.development.task1.reader;

import com.development.task1.exception.CustomArrayException;
import com.development.task1.reader.impl.ArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NumberReaderTest {

    @Test
    public void readNumbers() throws CustomArrayException {
        String expected = "18";
        ArrayReaderImpl numberReader = new ArrayReaderImpl();
        String[] readNumbers = numberReader.readNumbers("data/numbers.txt");
        Assert.assertEquals(readNumbers[0], expected);
    }
}
