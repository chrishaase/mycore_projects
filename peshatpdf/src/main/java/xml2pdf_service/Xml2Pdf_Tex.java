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


public class Xml2Pdf_Tex extends Xml2Pdf {


    public Xml2Pdf_Tex(FileHandler fileHandler, AppData appData){

        super(fileHandler, appData);

    }

    public Boolean transformDruckvorlageXmlFile2PdfFile(RequestData requestData){
        Boolean b = null;

        return b;
    }

    public Boolean transformMcrXmlFile2PdfFile(RequestData requestData) {

        Boolean b = false;
        try {
            this.transformXml2Tex(requestData);
            b = fileHandler.fileExists(requestData.getTexFile());
        } catch(Exception e){
            e.printStackTrace();
        }
        if (b) {
            this.transformTex2PDF(requestData);
            b = fileHandler.fileExists(requestData.getPdfFile());}

        return b;
    }

    private void transformXml2Tex(RequestData requestData) throws IOException {

        // Standard Impl: Replaced by classloaderutil
        // ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // InputStream stylesheet = classLoader.getResourceAsStream(appData.getResourcePath() + appData.getXsltFileNameTex());

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
