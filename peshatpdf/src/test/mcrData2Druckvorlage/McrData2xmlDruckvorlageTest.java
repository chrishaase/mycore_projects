package test.mcrData2Druckvorlage;


import main.java.controller.AppConfigData;
import main.java.controller.RequestData;
import main.java.mcrData2xmlDruckvorlage.*;
import main.java.util.FileHandler;
import main.java.xmlMicroservice_Mcr_dao.XmlGetRest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class McrData2xmlDruckvorlageTest {


    private FileHandler fileHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {


        fileHandler = new FileHandler();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testObjekts2Xml() {


        // create mock-object and set outputfile name
        MCRLemma MCRLemma1 = MCRMockObject.createMockLemma();
        File xmlOutPut = new File("/mycore/druckvorlage.xml");

        // ensure last out file is deleted
        Boolean b = fileHandler.fileDelete(xmlOutPut);

        //create new out file
        Data2XmlDruckvorlage.marshall(MCRLemma1, xmlOutPut);

        // validate that it exists
        assertTrue(fileHandler.fileExists(xmlOutPut));



    }

}
