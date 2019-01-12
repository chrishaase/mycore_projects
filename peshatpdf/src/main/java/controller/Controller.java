/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.xml2pdf_service.Xml2Pdf;
import main.java.xml2pdf_service.Xml2PdfTexImpl;
import main.java.xml_dao.XmlDao;
import main.java.xml_dao.XmlDaoRestImpl;
import main.java.xml_rest_util.RestGetXml;
import main.java.xml_rest_util.RestGetXmlImpl;


/**
 *
 * @author chase
 */
public class Controller {
    
    private final RequestData requestData;
    private final Xml2Pdf xml2PDF;
    private final XmlDao xmlDao;
    private Boolean erfolg;
       
        
    public Controller (RequestData requestData) {

        this.requestData = requestData;

        // verdrahtet alle Services mit Implementationen (app laueft ohne DI Framework...)
        this.xml2PDF = new Xml2PdfTexImpl(requestData);
        this.xmlDao = new XmlDaoRestImpl(requestData);
        RestGetXml rest = new RestGetXmlImpl();
        xmlDao.setRest(rest);

    }
    
    public Boolean createPDF(){
        
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
