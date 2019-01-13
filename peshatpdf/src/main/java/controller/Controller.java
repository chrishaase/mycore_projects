/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.xml2pdf_service.Xml2Pdf;
import main.java.xml2pdf_service.Xml2Pdf_Tex;
import main.java.xmlFile_dao.XmlFile_dao;
import main.java.xmlFile_dao.XmlGetRest_util;


/**
 *
 * @author chase
 */
class Controller {
    
    private final Xml2Pdf xml2PDF;
    private final XmlFile_dao xmlDao;

        
    public Controller (RequestData requestData) {

        // verdrahtet alle Services mit Implementationen (app laueft ohne DI Framework...)
        // noch implementieren: falls Apache-FO implementiert wird: factory fuer xml2pdf
        this.xml2PDF = new Xml2Pdf_Tex(requestData);
        this.xmlDao = new XmlFile_dao(requestData, new XmlGetRest_util(requestData));
    }
    
    Boolean createPDF(){

        Boolean erfolg;

        //1. ensure xml.file is loaded to xmlfilepath
        erfolg = xmlDao.getXmlFileInPath();
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformXmlFile2PdfFile();
        }

        // 3. return erfolgsmeldung
        return erfolg;
    }



}
