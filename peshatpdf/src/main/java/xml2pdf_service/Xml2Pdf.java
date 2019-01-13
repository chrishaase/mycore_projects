package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileHandler;

import java.io.File;

public abstract class Xml2Pdf {

   protected final RequestData requestData;
   protected FileHandler fileHandler;


   public Xml2Pdf(RequestData requestData){

      this.requestData = requestData;

   }

   public abstract Boolean transformXmlFile2PdfFile();

   public void setFileHandler(FileHandler fileHandler) {
      this.fileHandler = fileHandler;
   }
}
