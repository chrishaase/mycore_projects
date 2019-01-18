package test.xmlFile_dao;

import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.util.FileHandler;
import main.java.xmlMyCoRe_dao.XmlFile_dao;
import main.java.xmlMyCoRe_dao.XmlGetRest;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class XmlFile_daoTest {

    private final String urlpath = "https://peshat.gwiss.uni-hamburg.de/api/v1/objects/";
    private final String xmlfilepath = "/mycore";
    private final String outfilepath = "/mycore";
    private final String mycoreid = "peshat_lemmas_00000002";
    private final String resourcePath ="main/resources/";
    private final File xmlFile = new File("/mycore/peshat_lemmas_00000002.xml");
    private final File xmlLinksFile = new File ("/mycore/peshat_lemmas_00000002_links.xml");
    private final String mycoreidwrong = "peshat_lemmas_00000003";


    private XmlGetRest restService;
    private AppData appData;
    private XmlFile_dao xmlFile_dao;
    private FileHandler fileHandler;
    private RequestData requestData;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        //requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath);

        appData = mock(AppData.class);
        when(appData.getOutFilePath()).thenReturn(outfilepath);
        when(appData.getXmlFilePath()).thenReturn(xmlfilepath);
        when(appData.getUrlPath()).thenReturn(urlpath);
        when(appData.getResourcePath()).thenReturn(resourcePath);
        when(appData.getFopConfigResource()).thenReturn("fop.xconf");
        when(appData.getPdfTexCommand()).thenReturn("xelatex");
        when(appData.getXsltFileNameFop()).thenReturn("mcrXml2Fo_lemma.xsl");
        when(appData.getXsltFileNameTex()).thenReturn("xml2tex_lemma_xelatex");


        requestData = new RequestData(mycoreid, "fop", appData);
        fileHandler = new FileHandler();
        restService = new XmlGetRest(new FileHandler(), appData);
        xmlFile_dao = new XmlFile_dao(restService, fileHandler, appData);

    }
    @Test
    void getLinkedFilesinPlacTest(){

        xmlFile_dao.getLinkedFilesinPath(requestData.getMcrXmlLinksFile(), requestData.getMcrXmlFile());


    }

    void unmarshallLinkedfiled(){

        xmlFile_dao.unmarshalXmlFileLinkFiles(requestData.getMcrXmlLinksFile());
    }

}
