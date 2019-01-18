/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.requestdata_model.CreateMockObject;
import main.java.requestdata_model.Lemma;
import main.java.util.FileHandler;
import main.java.xml2pdf_service.Data2XmlDruckvorlage;
import main.java.xml2pdf_service.Xml2Pdf;
import main.java.xml2pdf_service.Xml2Pdf_Fop;
import main.java.xml2pdf_service.Xml2Pdf_Tex;
import main.java.xmlMyCoRe_dao.XmlFile_dao;
import main.java.xmlMyCoRe_dao.XmlGetRest;

import java.io.File;


/**
 *
 * @author chase
 */
class RequestController {
    
    private final Xml2Pdf xml2PDF;
    private final XmlFile_dao xmlDao;
    private final RequestData requestData;
    private final FileHandler fileHandler;


        
    public RequestController(RequestData requestData, AppData appData) {

        this.requestData = requestData;

        // verdrahtet alle Services mit Implementationen (app laueft ohne DI Framework...)

        fileHandler = new FileHandler();
        xml2PDF = getXml2PDF(requestData, appData, fileHandler);
        XmlGetRest rest = new XmlGetRest(fileHandler, appData);
        xmlDao = new XmlFile_dao(rest, fileHandler, appData);


    }

    Boolean createPDFFromHelperObject(){

        Boolean erfolg = null;

        //0.get Helper Object
        Lemma lemma1 = CreateMockObject.createMockLemma();

        //1. transform Helper-Object to xml-DruckVorlage

        File xmlOutputFile = requestData.getDruckvorlageXmlFile();
        Data2XmlDruckvorlage.marshall(lemma1, xmlOutputFile);

        // check that file exists
        erfolg = fileHandler.fileExists(xmlOutputFile);

        //2. transform Vorlage 2 pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformDruckvorlageXmlFile2PdfFile(requestData);
        }

        // 3. return erfolgsmeldung
        return erfolg;

    }


    
    Boolean createPDFFromSingleLemmaID(){

        Boolean erfolg = null;

        //1. ensure main xml.file is loaded to xmlfilepath
        erfolg = xmlDao.getXmlFileInPath(requestData.getMycoreId(), requestData.getMcrXmlFile());

        // TODO ensure linked files are looaded to xmlfilepath
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformMcrXmlFile2PdfFile(requestData);
        }

        // 3. return erfolgsmeldung
        return erfolg;
    }


    private Xml2Pdf getXml2PDF(RequestData requestData, AppData appData, FileHandler fileHandler){
        switch(requestData.getPdfEngine()){
            case "tex":
                return new Xml2Pdf_Tex(fileHandler, appData);
            case "fop":
                return new Xml2Pdf_Fop(fileHandler, appData);
            default:
                return new Xml2Pdf_Tex(fileHandler, appData);
        }

    }


}
