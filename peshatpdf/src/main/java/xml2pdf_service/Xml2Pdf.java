package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileHandler;

import java.io.File;

public abstract class Xml2Pdf {


   protected FileHandler fileHandler;

   public Xml2Pdf(FileHandler fileHandler) {this.fileHandler = fileHandler;}

   public abstract Boolean transformXmlFile2PdfFile(RequestData requestData);


}
