package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Data2XmlDruckvorlage {

    /*
    Wandelt ein DatenObject der Form Lemma-Objekt mit der entsprechenden Definition
    in ein XML Dokument um (hier KEIN abstract object uebergeben -> marshall error)
    Beispiel: siehe TESTS / CreateMockObject
     */

    public static void marshall(Lemma lemma, File xmlOutput) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Lemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(lemma, xmlOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
