package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileHandler;

/*
not yet implemented
 */


public class Xml2Pdf_Fop extends Xml2Pdf {

    Xml2Pdf_Fop(FileHandler fileHandler){
        super(fileHandler);
    }

    public Boolean transformXmlFile2PdfFile(RequestData requestData){
        return false;
    }
}
