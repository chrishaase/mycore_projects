package test.xml_rest_util;

import main.java.controller.RequestData;
import main.java.xml_rest_util.RestGetXmlImpl;
import sun.misc.Request;

import static org.junit.jupiter.api.Assertions.*;

class RestGetXmlImplTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        String urlpath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
        String xmlfilepath = "/mycore";
        String outfilepath = "/mycore";
        String mycoreid = "peshat_bibliographical-sources_00000002";
        RequestData requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);
        RestGetXmlImpl restService = new RestGetXmlImpl(requestData);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void httpGet() {
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