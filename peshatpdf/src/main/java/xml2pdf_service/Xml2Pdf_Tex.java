package main.java.xml2pdf_service;

import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.util.FileHandler;
import main.java.util.StreamPrinter;
import main.java.util.ClassLoaderUtil;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;

/**
 * Wandelt xml in PDF um via Tex-Command-Line
 * Bietet zwei Methoden an: die erste Methode wandelt ein einzel MCR-XML-File in ein Tex und dann PDF um
 * Die zweite Methode wandelt eine vereinfachte xml-Druckvorlage in ein Tex-File und ein PDF um
 * Vorbedingung: valides XML-ist vorhanden im Filepath, valide xsl-Transformer-Stylesheets existieren fuer alle, tex installiert, Schriften installiert (siehe readme)
 * Nachbedingung: Tex und PDF-Files existieren
 */


public class Xml2Pdf_Tex extends Xml2Pdf {


    public Xml2Pdf_Tex(FileHandler fileHandler, AppData appData){

        super(fileHandler, appData);

    }

    public Boolean transformDruckvorlageXmlFile2PdfFile(RequestData requestData){

        /*
        Neue Methode noch implementieren - Druckvorlage to Tex und dann zu PDF - erfordert anderes XSL in resources, dass noch nicht existiert
         */

        Boolean b = null;

        return b;
    }

    public Boolean transformMcrXmlFile2PdfFile(RequestData requestData) {

        Boolean b = false;
        try {
            this.transformMcrXml2Tex(requestData);
            b = fileHandler.fileExists(requestData.getTexFile());
        } catch(Exception e){
            e.printStackTrace();
        }
        if (b) {
            this.transformTex2PDF(requestData);
            b = fileHandler.fileExists(requestData.getPdfFile());}

        return b;
    }

    private void transformMcrXml2Tex(RequestData requestData) throws IOException {

        /**
         * Alte Methode: WANDELT EINZEL XML to TEX
         */

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(appData.getResourcePath() + appData.getXsltFileNameTex(), this.getClass());

        try{

            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getMcrXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getTexFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void transformTex2PDF(RequestData requestData){

        ProcessBuilder pb = new ProcessBuilder(appData.getPdfTexCommand(), "-interaction=nonstopmode",
                requestData.getTexFileName());
        pb.directory(new File(appData.getOutFilePath()));

        try {
            Process p = pb.start();
            StreamPrinter sPrint = new StreamPrinter(p.getInputStream(), false);
            StreamPrinter sError = new StreamPrinter(p.getErrorStream(), false);
            new Thread(sPrint).start();
            new Thread(sError).start();
            p.waitFor();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}
