package test.xmlFile_dao;


import main.java.controller.AppConfigData;
import main.java.controller.RequestData;
import main.java.mcrData2xmlDruckvorlage.*;
import main.java.util.FileHandler;
import main.java.xmlMicroservice_Mcr_dao.XmlGetRest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Object2XmlMarshallTest {

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

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        requestData = mock(RequestData.class);
        appConfigData = mock(AppConfigData.class);
        when(requestData.getMycoreId()).thenReturn(mycoreid);
        when(appConfigData.getOutFilePath()).thenReturn(outfilepath);
       when(appConfigData.getUrlPath()).thenReturn(urlpath);

        restService = new XmlGetRest(new FileHandler(), appConfigData);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testObjekts2Xml() {



        MCRLemma MCRLemma1 = MCRMockObject.createMockLemma();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MCRLemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal  in console
            jaxbMarshaller.marshal(MCRLemma1, System.out);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
