package main.java.data2xmlDruckvorlage;

import main.java.data2xmlDruckvorlage.Lemma;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Data2XmlDruckvorlage {

    /*
    Wandelt ein DatenObject der Form MCRAbstractObject mit der entsprechenden Definition
    in ein XML Dokument um
    Beispiel: siehe TESTS
     */

    public static void marshall(MCRAbstractObject mcrAbstractObject, File xmlOutput) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MCRAbstractObject.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in console
            jaxbMarshaller.marshal(mcrAbstractObject, System.out);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(mcrAbstractObject, xmlOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
