package test.xmlFile_dao;


import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.xml2XmlDruckauftrag_service.Definition;
import main.java.xml2XmlDruckauftrag_service.Lemma;
import main.java.xml2XmlDruckauftrag_service.Quotation;
import main.java.xml2XmlDruckauftrag_service.Source;
import main.java.util.FileHandler;
import main.java.xmlMyCoRe_dao.XmlGetRest;

import java.io.File;
import java.util.ArrayList;

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


        Source source1 = new Source();
        source1.setMycoreid("testid");
        source1.setAuthor("Author1");
        source1.setYear("1993");
        source1.setTitle("TestTitle");
        source1.setPlace("testplace");
        source1.setPublisher("testpublisher");


        Quotation quote1 = new Quotation();
        quote1.setMycoreid("test_quote_id");
        quote1.setQuotation("test bla");
        quote1.setSources(new ArrayList<Source>());
        quote1.getSources().add(source1);

        Definition definition1 = new Definition();
        definition1.setQuotations(new ArrayList<Quotation>());
        definition1.getQuotations().add(quote1);

        Lemma lemma1 = new Lemma();
        lemma1.setGender("M");
        lemma1.setVocalizedSpelling("vocalizedSpelling");
        lemma1.setListDefinitions(new ArrayList<Definition>());
        lemma1.setListSources(new ArrayList<Source>());
        lemma1.getListDefinitions().add(definition1);
        lemma1.getListSources().add(source1);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Lemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(lemma1, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(lemma1, new File("/mycore/employees.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    /*
    Beispiel Programm
    {
        employees.setEmployees(new ArrayList<Employee>());
        //Create two employees
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstName("Lokesh");
        emp1.setLastName("Gupta");
        emp1.setIncome(100.0);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setFirstName("John");
        emp2.setLastName("Mclane");
        emp2.setIncome(200.0);

        //Add the employees in list
        employees.getEmployees().add(emp1);
        employees.getEmployees().add(emp2);
    }

    private static void marshalingExample() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(employees, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(employees, new File("c:/temp/employees.xml"));
    }

    */

}
