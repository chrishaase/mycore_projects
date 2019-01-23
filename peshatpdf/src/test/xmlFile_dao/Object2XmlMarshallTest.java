package test.xmlFile_dao;


import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.mcrData2xmlDruckvorlage.*;
import main.java.util.FileHandler;
import main.java.xmlMicroservice_Mcr_dao.XmlGetRest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

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
    private AppData appData;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        requestData = mock(RequestData.class);
        appData = mock(AppData.class);
        when(requestData.getMycoreId()).thenReturn(mycoreid);
        when(appData.getOutFilePath()).thenReturn(outfilepath);
        when(appData.getXmlFilePath()).thenReturn(xmlfilepath);
        when(appData.getUrlPath()).thenReturn(urlpath);

        restService = new XmlGetRest(new FileHandler(), appData);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testObjekts2Xml() {



        Lemma lemma1 = CreateMockObject.createMockLemma();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Lemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(lemma1, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(lemma1, new File("/mycore/druckvorlage.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
