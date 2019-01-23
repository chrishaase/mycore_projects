/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.mcrData2xmlDruckvorlage.MCRMockObject;
import main.java.mcrData2xmlDruckvorlage.MCRLemma;
import main.java.util.FileHandler;
import main.java.mcrData2xmlDruckvorlage.Data2XmlDruckvorlage;
import main.java.xml2pdf_service.Xml2Pdf;
import main.java.xml2pdf_service.Xml2Pdf_Fop;
import main.java.xml2pdf_service.Xml2Pdf_Tex;
import main.java.xmlMicroservice_Mcr_dao.XmlFile_dao;
import main.java.xmlMicroservice_Mcr_dao.XmlGetRest;

import java.io.File;


/**
 * Der RequestController (vergleichbar mit einer Stripes-Action-Bean oder JSF-ManagedBean)
 * steuert die BusinessLogiken zur Erstellung eines PDFs. Er kreiiert und instanziiert
 * einen FileHandler, sowie
 * einen xml2PDF und einen XML-dao service.
 * Er benötigt die beiden Klassen (beans) AppConfigData und RequestData. *
 * Status: 0.1.: Der Controller ist so angelegt, dass die App sowohl integriet in MCR werden kann (dann wuerden die DAO-Controller vom MCR-Modell verwandt werden
 * oder dass es ein MicroService wird (dann muss der eigene DAO-Service noch ausgebaut werden, alle verlinkten Dokumente von der REST-API zu ziehen)
 *
 * @author chase
 */
class RequestController {
    
    private final Xml2Pdf xml2PDF;
    private final XmlFile_dao xmlDao;
    private final RequestData requestData;
    private final FileHandler fileHandler;


        
    public RequestController(RequestData requestData) {

        this.requestData = requestData;

        // verdrahtet alle Services mit Implementationen

        fileHandler = new FileHandler();
        xml2PDF = getXml2PDF(requestData, requestData.getAppConfigData(), fileHandler);
        XmlGetRest rest = new XmlGetRest(fileHandler, requestData.getAppConfigData());
        xmlDao = new XmlFile_dao(rest, fileHandler, requestData.getAppConfigData());


    }

    Boolean createPDFFromHelperObject(){

        Boolean erfolg = null;

        //1.Init
        File xmlOutputFile = requestData.getDruckvorlageXmlFile();

        //2. transform Helper-Object to xml-DruckVorlage
        // TODO replace MOCK with REAL OBJECT
        MCRLemma MCRLemma1 = MCRMockObject.createMockLemma();

        Data2XmlDruckvorlage.marshall(MCRLemma1, xmlOutputFile);

        //2. transform Vorlage 2 pdf and ensure pdf is created in outfilepath
        if (fileHandler.fileExists(xmlOutputFile)) {
            return xml2PDF.transformDruckvorlageXmlFile2PdfFile(requestData);
        } else {
            return false; // Misserfolg da xmlOutputFile nicht existiert
        }


    }


    
    Boolean createPDFFromSingleLemmaID(){

        //ensure main xml.file is loaded to outfilepath and return rueckmeldung von xml2pdf transformation

        if(xmlDao.getXmlFileInPath(requestData.getMycoreId(), requestData.getMcrXmlFile())){

            return xml2PDF.transformMcrXmlFile2PdfFile(requestData);
        } else {
            return false;
        }


    }


    private Xml2Pdf getXml2PDF(RequestData requestData, AppConfigData appConfigData, FileHandler fileHandler){
        switch(requestData.getPdfEngine()){
            case "tex":
                return new Xml2Pdf_Tex(fileHandler, appConfigData);
            case "fop":
                return new Xml2Pdf_Fop(fileHandler, appConfigData);
            default:
                return new Xml2Pdf_Tex(fileHandler, appConfigData);
        }

    }


}
