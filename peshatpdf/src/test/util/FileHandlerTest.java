package test.util;

import main.java.util.FileHandler;
import org.junit.jupiter.api.Test;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.StringReader;

import javax.xml.xpath.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileHandlerTest {

    @Test
    public void resourceFile2ServerFileTest(){

        // init test
        String resourceFileWithPath="main/resources/fop.xconf";
        String serverFileWithPath="/mycore/fop.xconf";
        FileHandler fileHandler = new FileHandler();
        File testFile = new File(serverFileWithPath);

        // delete previous file
        Boolean b = fileHandler.fileDelete(testFile);

        // create new one
        fileHandler.resourceFile2ServerFile(resourceFileWithPath, serverFileWithPath);

        // assert it exists
        assertTrue(testFile.exists());

    }


}
