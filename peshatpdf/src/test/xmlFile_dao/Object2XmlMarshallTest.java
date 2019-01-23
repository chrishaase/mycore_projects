package test.xmlFile_dao;


import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.requestdata_entity.Definition;
import main.java.requestdata_entity.Lemma;
import main.java.requestdata_entity.Quotation;
import main.java.requestdata_entity.BibliographicalSource;
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


        BibliographicalSource bibliographicalSource0149 = new BibliographicalSource();
        bibliographicalSource0149.setMycoreid("peshat_bibliographical-sources_00000149");
        bibliographicalSource0149.setAuthor("ha-Levi");
        bibliographicalSource0149.setYear("1868");
        bibliographicalSource0149.setTitle("Das Buch Kuzari");
        bibliographicalSource0149.setPlace("Leipzig");
        bibliographicalSource0149.setPublisher("Verlag von Fr. Voigt's Buchhandlung");

        BibliographicalSource bibliographicalSource0012 = new BibliographicalSource();
        bibliographicalSource0012.setMycoreid("peshat_bibliographical-sources_00000012");
        bibliographicalSource0012.setAuthor("אברהם בן דאוד בן הלוי");
        bibliographicalSource0012.setYear("1852");
        bibliographicalSource0012.setTitle("ספר האמונה הרמה");
        bibliographicalSource0012.setPlace("Frankfurt am Main");
        bibliographicalSource0012.setPublisher("Typographische Anstalt");


        Quotation quotation0028 = new Quotation();
        quotation0028.setMycoreid("peshat_quotations_00000028");
        quotation0028.setQuotationText_he("אבות המעלות והחסרונות שלש");
        quotation0028.setBibliographicalSources(new ArrayList<BibliographicalSource>());
        quotation0028.getBibliographicalSources().add(bibliographicalSource0012);

        Quotation quotation5734 = new Quotation();
        quotation5734.setMycoreid("peshat_quotations_00005734");
        quotation5734.setQuotationText_he(" סברתך ומחשבתך כאשר תרחיק המחשבה והסברא העדר הרקות וההקשות השכליות מחייבות זה וכאשר תרחיק הסברא שיכול להתחלק הגוף אין תכלית וההקשה השכלית מחייבת זה וכאשר תרחיק המחשבה שהארץ כדורית ושהיא חלק אחד ממאה וששים ושש פעמים מעגול השמש וכל מה שיש במופתי התכונה ממה שתרחיקהו המחשבה");
        quotation5734.setBibliographicalSources(new ArrayList<BibliographicalSource>());
        quotation5734.getBibliographicalSources().add(bibliographicalSource0012);

        Definition definition4668 = new Definition();
        definition4668.setMycoreid("peshat_definitions_00004668");
        definition4668.setDefinition_en("foundation, principle from which other things are derived");
        definition4668.setQuotations(new ArrayList<Quotation>());
        definition4668.getQuotations().add(quotation5734);

        Definition definition4669 = new Definition();
        definition4669.setMycoreid("peshat_definitions_00004669");
        definition4669.setDefinition_en("something which encompasses many things (as a metaphor for abstract and spiritual things)");
        definition4669.setQuotations(new ArrayList<Quotation>());


        Definition definition0013 = new Definition();
        definition0013.setMycoreid("peshat_definitions_00000013");
        definition0013.setDefinition_en("origin, cause");
        definition0013.setQuotations(new ArrayList<Quotation>());
        definition0013.getQuotations().add(quotation0028);

        Lemma lemma1 = new Lemma();
        lemma1.setMycoreid("peshat_lemmas_00000002");
        lemma1.setGender("M");
        lemma1.setVocalizedSpelling("אָב");
        lemma1.setRoot("אבי");
        lemma1.setVerbStem("Noun");
        lemma1.setListDefinitions(new ArrayList<Definition>());
        lemma1.getListDefinitions().add(definition4668);
        lemma1.getListDefinitions().add(definition4669);
        lemma1.getListDefinitions().add(definition0013);
        lemma1.setListBibliographicalSources(new ArrayList<BibliographicalSource>());
        lemma1.getListBibliographicalSources().add(bibliographicalSource0149);

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
