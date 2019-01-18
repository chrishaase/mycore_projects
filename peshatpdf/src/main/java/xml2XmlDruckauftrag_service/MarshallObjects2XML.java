package main.java.xml2XmlDruckauftrag_service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import main.java.xml2XmlDruckauftrag_service.Lemma;


public class MarshallObjects2XML {

    /*
    For example of creating Objekt-Geflecht - see Tests
     */

    public void marshall(Lemma lemma1, File xmlOutput) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Lemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(lemma1, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(lemma1, xmlOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
