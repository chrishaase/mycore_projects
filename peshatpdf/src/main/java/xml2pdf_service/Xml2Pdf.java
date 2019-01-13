package main.java.xml2pdf_service;

import main.java.controller.RequestData;

import java.io.File;

public abstract class Xml2Pdf {

   protected final RequestData requestData;
   protected final File pdfFile;

   protected final File xmlFile;
   protected final String texFileName;

   public Xml2Pdf(RequestData requestData){

      this.requestData = requestData;
      String pdfFileName = requestData.getMycoreid() + ".pdf";
      texFileName = requestData.getMycoreid() + ".tex";
      String xmlFileName = requestData.getMycoreid() + ".xml";
      pdfFile = new File(requestData.getOutfilepath(), pdfFileName);

      xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

   }

   public abstract Boolean transformXmlFile2PdfFile();
}
