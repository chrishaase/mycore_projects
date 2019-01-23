package main.java.xml2pdf_service;

import main.java.controller.AppConfigData;
import main.java.controller.RequestData;
import main.java.util.FileHandler;


/**
 * Wandelt xml in PDF um v
 * Bietet zwei Methoden an: die erste Methode wandelt ein einzel MCR-XML-File in  PDF um
 * Die zweite Methode wandelt eine vereinfachte xml-Druckvorlage in  ein PDF um
 * Vorbedingung: valides XML-ist vorhanden im Filepath, valide xsl-Transformer-Stylesheets existieren fuer alle, )
 * Nachbedingung: Tex und PDF-Files existieren
 *
 * ZWEI IMPLEMENTIERUNGEN DER ABSTRAKTEN KLASSE: BISHER: via Tex und via FO
 */

public abstract class Xml2Pdf {


   protected FileHandler fileHandler;
   protected AppConfigData appConfigData;

   public Xml2Pdf(FileHandler fileHandler, AppConfigData appConfigData) {
      this.fileHandler = fileHandler;
      this.appConfigData = appConfigData;
   }

   public abstract Boolean transformMcrXmlFile2PdfFile(RequestData requestData);

   public abstract Boolean transformDruckvorlageXmlFile2PdfFile(RequestData requestData);


}
