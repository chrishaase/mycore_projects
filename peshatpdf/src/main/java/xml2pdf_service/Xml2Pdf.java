package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileHandler;

import java.io.File;

public abstract class Xml2Pdf {


   protected FileHandler fileHandler;
   protected RequestData requestData;

   public Xml2Pdf(FileHandler fileHandler, RequestData requestData) {
      this.fileHandler = fileHandler;
      this.requestData =  requestData;
   }

   public abstract Boolean transformXmlFile2PdfFile();


}
