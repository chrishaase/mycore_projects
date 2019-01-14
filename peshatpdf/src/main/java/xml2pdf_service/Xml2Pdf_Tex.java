package main.java.xml2pdf_service;

import main.java.controller.RequestData;
import main.java.util.FileHandler;
import main.java.util.StreamPrinter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;

public class Xml2Pdf_Tex extends Xml2Pdf {


    public Xml2Pdf_Tex(FileHandler fileHandler){

        super(fileHandler);

    }

    public Boolean transformXmlFile2PdfFile(RequestData requestData) {

        transformXml2Tex(requestData);
        Boolean b = fileHandler.fileExists(requestData.getTexFile());

        if (b) {
            transformTex2PDF(requestData);
            b = fileHandler.fileExists(requestData.getPdfFile());}

        return b;
    }

    private void transformXml2Tex(RequestData requestData)  {


        InputStream stylesheet = Xml2Pdf_Tex.class.getResourceAsStream(requestData.getXsltFile());

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


    private void transformTex2PDF(RequestData requestData){

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
