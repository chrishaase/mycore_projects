package test.xml_rest_util;

import main.java.controller.RequestData;
import main.java.util.FileHandler;
import main.java.util.XmlGetRest;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.StringReader;

import javax.xml.xpath.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestGetXmlImplTest {

    private final String urlpath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
    private final String xmlfilepath = "/mycore";
    private final String outfilepath = "/mycore";
    private final String mycoreid = "peshat_bibliographical-sources_00000002";
    private final String mycoreidwrong = "peshat_bibliographical-sources_00000003";

    private String xmlFileName;
    private File xmlFile;

    private RequestData requestData;
    private XmlGetRest restService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        requestData = mock(RequestData.class);
        when(requestData.getMycoreid()).thenReturn(mycoreid);
        when(requestData.getOutfilepath()).thenReturn(outfilepath);
        when(requestData.getXmlfilepath()).thenReturn(xmlfilepath);
        when(requestData.getUrlpath()).thenReturn(urlpath);

        restService = new XmlGetRest(new FileHandler());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testHttpGet() {

        // testet ob httpget das richtige XML Dok über rest laedt
        String testmycore = restService.httpGet(requestData.getMycoreid(), requestData.getUrlpath());


        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        InputSource source = new InputSource(new StringReader(testmycore));
        String httpid = null;
        try {
            httpid = xpath.evaluate("//mycoreobject/@ID", source);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        assertTrue(!testmycore.isEmpty());
        assertTrue(requestData.getMycoreid().equalsIgnoreCase(httpid));
        assertFalse(mycoreidwrong.equalsIgnoreCase(httpid));

    }

    @org.junit.jupiter.api.Test
    void httpGetAndSave2File() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void fileExists() {
    }
}