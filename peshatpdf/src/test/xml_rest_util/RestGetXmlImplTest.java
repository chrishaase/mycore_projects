package test.xml_rest_util;

import main.java.controller.RequestData;
import main.java.xml_rest_util.RestGetXmlImpl;
import org.xml.sax.InputSource;
import java.io.StringReader;

import javax.xml.xpath.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestGetXmlImplTest {

    String urlpath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
    String xmlfilepath = "/mycore";
    String outfilepath = "/mycore";
    String mycoreid = "peshat_bibliographical-sources_00000002";
    String mycoreidwrong = "peshat_bibliographical-sources_00000003";
    RequestData requestData;
    RestGetXmlImpl restService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        requestData = mock(RequestData.class);
        when(requestData.getMycoreid()).thenReturn(mycoreid);
        when(requestData.getOutfilepath()).thenReturn(outfilepath);
        when(requestData.getXmlfilepath()).thenReturn(xmlfilepath);
        when(requestData.getUrlpath()).thenReturn(urlpath);
        restService = new RestGetXmlImpl(requestData);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testHttpGet() {

        // testet ob httpget das richtige XML Dok über rest laedt
        String testmycore = restService.httpGet();


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