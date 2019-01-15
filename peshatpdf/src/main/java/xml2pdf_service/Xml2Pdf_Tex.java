package main.java.xml2pdf_service;

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


    public Xml2Pdf_Tex(FileHandler fileHandler, RequestData requestData){

        super(fileHandler, requestData);

    }

    public Boolean transformXmlFile2PdfFile() {

        Boolean b = false;
        try {
            this.transformXml2Tex();
            b = fileHandler.fileExists(requestData.getTexFile());
        } catch(Exception e){
            e.printStackTrace();
        }
        if (b) {
            this.transformTex2PDF();
            b = fileHandler.fileExists(requestData.getPdfFile());}

        return b;
    }

    private void transformXml2Tex() throws IOException {

        // Standard Impl: Replaced by classloaderutil
        // ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // InputStream stylesheet = classLoader.getResourceAsStream(requestData.getResourcePath() + requestData.getXsltFileName());

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(requestData.getResourcePath() + requestData.getXsltFileNameTex(), this.getClass());

        try{

            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getTexFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void transformTex2PDF(){

        ProcessBuilder pb = new ProcessBuilder(requestData.getPdfTexCommand(), "-interaction=nonstopmode",
                requestData.getTexFileName());
        pb.directory(new File(requestData.getOutFilePath()));

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
