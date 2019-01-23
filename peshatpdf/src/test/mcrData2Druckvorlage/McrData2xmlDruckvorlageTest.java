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

    private final String urlpath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
    private final String xmlfilepath = "/mycore";
    private final String outfilepath = "/mycore";
    private final String mycoreid = "peshat_bibliographical-sources_00000002";
    private final String mycoreidwrong = "peshat_bibliographical-sources_00000003";

    private String xmlFileName;
    private File xmlFile;

    private RequestData requestData;
    private XmlGetRest restService;
    private AppConfigData appConfigData;
    private FileHandler fileHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        requestData = mock(RequestData.class);
        appConfigData = mock(AppConfigData.class);
        when(requestData.getMycoreId()).thenReturn(mycoreid);
        when(appConfigData.getOutFilePath()).thenReturn(outfilepath);
        when(appConfigData.getUrlPath()).thenReturn(urlpath);

        restService = new XmlGetRest(new FileHandler(), appConfigData);
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
