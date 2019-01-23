package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Data2XmlDruckvorlage {

    /*
    Wandelt ein DatenObject der Form MCRLemma-Objekt mit der entsprechenden MCRDefinition
    in ein XML Dokument um (hier KEIN abstract object uebergeben -> marshall error)
    Beispiel: siehe TESTS / MCRMockObject
     */

    public static void marshall(MCRLemma MCRLemma, File xmlOutput) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MCRLemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(MCRLemma, xmlOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
