package main.java.xml2pdf_service;

import main.java.controller.AppConfigData;
import main.java.controller.RequestData;
import main.java.util.ClassLoaderUtil;
import main.java.util.FileHandler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import java.io.*;

/**
 * Wandelt xml in PDF
 * Bietet zwei Methoden an: die erste Methode wandelt ein einzel MCR-XML-File in FO und dann PDF um
 * Die zweite Methode wandelt eine vereinfachte xml-Druckvorlage in ein FO-File und ein PDF um
 * Vorbedingung: valides XML-ist vorhanden im Filepath, valide xsl-Transformer-Stylesheets existieren fuer alle, fo installiert, Schriften vorhanden (siehe readme)
 * Nachbedingung: FO, Tex und PDF-Files existieren
 */
public class Xml2Pdf_Fop extends Xml2Pdf {



    public Xml2Pdf_Fop(FileHandler fileHandler, AppConfigData appConfigData){

       super(fileHandler, appConfigData);
    }

    public Boolean transformDruckvorlageXmlFile2PdfFile(RequestData requestData){

        transformDruckvorlageXml2FoFile(requestData);

       return this.transformFoFile2PdfFile(requestData);

    }

    public Boolean transformMcrXmlFile2PdfFile(RequestData requestData) {

       transformMcrXml2FoFile(requestData);

        return this.transformFoFile2PdfFile(requestData);


    }

    private void transformDruckvorlageXml2FoFile(RequestData requestData){

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(appConfigData.getResourcePath() + appConfigData.getXsltDruckvorlageXml2Fo(), this.getClass());

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getDruckvorlageXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getFoFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void transformMcrXml2FoFile(RequestData requestData){

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(appConfigData.getResourcePath() + appConfigData.getXsltFileNameFop(), this.getClass());

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getMcrXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getFoFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Boolean transformFoFile2PdfFile(RequestData requestData)  {

        if (fileHandler.fileExists(requestData.getFoFile())) {

            try {

                FopFactory fopFactory = FopFactory.newInstance(new File(requestData.getAppConfigData().getFopConfigResource()));
                FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

                OutputStream out = new FileOutputStream(requestData.getPdfFile());
                out = new BufferedOutputStream(out);

                // Construct fop with desired output format
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

                // Setup JAXP using identity transformer
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(); // identity transformer

                // Setup input stream
                Source src = new StreamSource(requestData.getFoFile());

                // Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new SAXResult(fop.getDefaultHandler());

                // Start XSLT transformation and FOP processing
                transformer.transform(src, res);

                // Result processing
                out.close();

            } catch (Exception e) {
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        } else {
            return false;
        }

        if(fileHandler.fileExists(requestData.getPdfFile())){
            return true;}
        else {
            return false;
        }

    }

    }
