package main.java.mcrData2xmlDruckvorlage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Data2XmlDruckvorlage {

    /*
    Wandelt ein DatenObject der Form MCRLemma-Objekt, in ein XML Dokument um
    (hier KEIN abstract objects ODER interfaces uebergeben -> marshall error)
    Beispiel: siehe TESTS / MCRMockObject
     */

    public static void marshall(MCRLemma mcrLemma, File xmlOutput) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MCRLemma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the list in file
            jaxbMarshaller.marshal(mcrLemma, xmlOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
