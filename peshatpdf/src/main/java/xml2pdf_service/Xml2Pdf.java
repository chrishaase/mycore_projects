package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileChecker;

import java.io.File;

public abstract class Xml2Pdf {

   protected final RequestData requestData;
   protected final File pdfFile;
   protected final File xmlFile;
   protected final String xsl_standard;

   protected final FileChecker fileChecker = new FileChecker();


   public Xml2Pdf(RequestData requestData){

      this.requestData = requestData;
      String pdfFileName = requestData.getMycoreid() + ".pdf";
      String xmlFileName = requestData.getMycoreid() + ".xml";
      pdfFile = new File(requestData.getOutfilepath(), pdfFileName);
      xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);
      xsl_standard = requestData.getXsltFile();

   }

   public abstract Boolean transformXmlFile2PdfFile();
}
