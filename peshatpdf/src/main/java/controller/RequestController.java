/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.util.FileHandler;
import main.java.druckvorlage2pdf_service.Xml2Pdf;
import main.java.druckvorlage2pdf_service.Xml2Pdf_Fop;
import main.java.druckvorlage2pdf_service.Xml2Pdf_Tex;
import main.java.xmlMyCoRe_dao.XmlFile_dao;
import main.java.xmlMyCoRe_dao.XmlGetRest;


/**
 *
 * @author chase
 */
class RequestController {
    
    private final Xml2Pdf xml2PDF;
    private final XmlFile_dao xmlDao;
    private final RequestData requestData;


        
    public RequestController(RequestData requestData, AppData appData) {

        this.requestData = requestData;

        // verdrahtet alle Services mit Implementationen (app laueft ohne DI Framework...)

        FileHandler fileHandler = new FileHandler();
        xml2PDF = getXml2PDF(requestData, appData, fileHandler);
        XmlGetRest rest = new XmlGetRest(fileHandler, appData);
        xmlDao = new XmlFile_dao(rest, fileHandler, appData);


    }
    
    Boolean createPDF(){

        Boolean erfolg;

        //1. ensure xml.file is loaded to xmlfilepath
        erfolg = xmlDao.getXmlFileInPath(requestData.getMycoreId(), requestData.getXmlFile());
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformXmlFile2PdfFile(requestData);
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
