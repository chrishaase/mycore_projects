/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package main.java.controller;

import main.java.util.ClassLoaderUtil;
import main.java.util.FileHandler;
import main.java.xml2pdf_service.Xml2Pdf;
import main.java.xml2pdf_service.Xml2Pdf_Fop;
import main.java.xml2pdf_service.Xml2Pdf_Tex;
import main.java.xmlFile_dao.XmlFile_dao;
import main.java.util.XmlGetRest;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.nio.file.StandardCopyOption;


/**
 *
 * @author chase
 */
class Controller {
    
    private final Xml2Pdf xml2PDF;
    private final XmlFile_dao xmlDao;

        
    public Controller (RequestData requestData) {

        // verdrahtet alle Services mit Implementationen (app laueft ohne DI Framework...)
        // Factory fuer Conversion-Service (fop oder tex)
        FileHandler fileHandler = new FileHandler();
        xml2PDF = getXml2PDF(requestData, fileHandler);
        XmlGetRest rest = new XmlGetRest(fileHandler);
        xmlDao = new XmlFile_dao(rest, fileHandler);


    }
    
    Boolean createPDF(RequestData requestData){

        Boolean erfolg;

        //1. ensure xml.file is loaded to xmlfilepath
        erfolg = xmlDao.getXmlFileInPath(requestData);
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformXmlFile2PdfFile(requestData);
        }

        // 3. return erfolgsmeldung
        return erfolg;
    }


    private Xml2Pdf getXml2PDF(RequestData requestData, FileHandler fileHandler){
        switch(requestData.getConversionService()){
            case "tex":
                return new Xml2Pdf_Tex(fileHandler);
            case "fop":
                return new Xml2Pdf_Fop(fileHandler);
            default:
                return new Xml2Pdf_Tex(fileHandler);
        }

    }


}
