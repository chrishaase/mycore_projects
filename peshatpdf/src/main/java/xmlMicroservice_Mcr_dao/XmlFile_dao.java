package main.java.xmlMicroservice_Mcr_dao;

import main.java.controller.AppConfigData;
import main.java.util.ClassLoaderUtil;
import main.java.util.FileHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

/**
 * METHODE FUER EXTERNE (MICROSERVICE) IMPLEMENTATION DES PESHAT_PDF_PRINTERS
 * Bietet Services an, xml-Mycore-Objekte über die Rest-Api in den Filepath zu bekommen
 *
 */

public class XmlFile_dao {

    private final XmlGetRest rest;
    private final FileHandler fileHandler;
    private final AppConfigData appConfigData;
    private XmlFileLinks xmlFileLinks;

    public XmlFile_dao(XmlGetRest rest, FileHandler fileHandler, AppConfigData appConfigData){

        this.fileHandler = fileHandler;
        this.rest = rest;
        this.appConfigData = appConfigData;

    }

    public Boolean getXmlFileInPath(String mycoreid, File xmlFile){



        // if not present, load from rest service and saveXmlStr2File to filepath
        if (!fileHandler.fileExists(xmlFile)){
          return rest.httpGetAndSave2File(mycoreid, xmlFile);
        } else {
            return true;
        }


    }


    // TODO Methode ALL_BASE_FILES: BASE-FILES DOWNLOADEN - Datamodels, Peshatclasses

    public void getLinkedFilesinPath(File xmlLinksFile, File xmlFile) {

        //1. CallTransformerFactory xml2xmlLinkFile

        this.extractDefinitionLinksfromMcrXML2XmlDefLinkFile(xmlLinksFile, xmlFile);

        //2. Unmarshal to Object-Array

        this.unmarshalXmlFileLinkFiles(xmlLinksFile);

        // rename to LemmaID_DefinitionsLinksFile


        // 3. Call all File-Objects and getxmlFileinPath

        for (XmlFileLink fileLink : xmlFileLinks.getFileLinks()) {

            String newXmlFileName = fileLink.getLink() + ".xml";
            File newXmlFile = new File(appConfigData.getOutFilePath(), newXmlFileName);

            Boolean b = getXmlFileInPath(fileLink.getLink(), newXmlFile );

        }
    }


    private void extractDefinitionLinksfromMcrXML2XmlDefLinkFile(File xmlLinksFile, File xmlFile){

        /* Die Methode extrahiert die DefinitionsLinks aus dem xml-document des requests
        mithilfe  des XSL-Stylesheets mcrXml2Xml_deflinkExtract.xsl (der in resources zu finden ist)
        und speichert sie in dem file xmlLinksFile.xml im outpath (spezifiziert in Web.xml)
        */

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream("main/resources/mcrXml2Xml_deflinkExtract.xsl", this.getClass());

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(xmlFile);
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(xmlLinksFile));

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // ALTERNATIV: GET FROM FILEPATH - PATH RESOLVER
    // Construct path from link
    // 1. substring minus peshat_ at front
    // 2. substring minus _12345678 am Ende
    // 3 Substring DataType / 1234 / 56 / mycoreID.xml
    // 4.Substring Folder= 1234 / 56 /
    // 5.xml-path home/ahzch/shutmnt/data/metadata/peshat/datatype/[datatype]/1234/56/mycoreID.xml

    public void unmarshalXmlFileLinkFiles(File xmlLinksFile){

        /*
        Methode unmarshalled Links aus einem XmlLinkedLinks fiel
         */

        try {

            File file = xmlLinksFile;
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlFileLinks.class);


            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            xmlFileLinks = (XmlFileLinks) jaxbUnmarshaller.unmarshal(file);


            } catch (JAXBException e1) {
            e1.printStackTrace();
        }



    }








}
