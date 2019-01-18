package main.java.xml2pdf_service;

import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.util.FileHandler;

public abstract class Xml2Pdf {


   protected FileHandler fileHandler;
   protected AppData appData;

   public Xml2Pdf(FileHandler fileHandler, AppData appData) {
      this.fileHandler = fileHandler;
      this.appData =  appData;
   }

   public abstract Boolean transformMcrXmlFile2PdfFile(RequestData requestData);


}
