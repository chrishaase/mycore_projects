package main.java.xml2pdf_service;

import main.java.controller.AppData;
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


public class Xml2Pdf_Fop extends Xml2Pdf {



    public Xml2Pdf_Fop(FileHandler fileHandler, AppData appData){

        super(fileHandler, appData);




    }

    public Boolean transformXmlFile2PdfFile(RequestData requestData) {

        transformXml2FoFile(requestData);
        Boolean b = fileHandler.fileExists(requestData.getFoFile());

        if (b) {
            try {
                this.transformFoFile2PdfFile(requestData);
            } catch (Exception e){
                e.printStackTrace();
            }
            b = fileHandler.fileExists(requestData.getPdfFile());}

        return b;

    }

    private void transformXml2FoFile(RequestData requestData){

        InputStream stylesheet = ClassLoaderUtil.getResourceAsStream(appData.getResourcePath() + appData.getXsltFileNameFop(), this.getClass());

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(requestData.getXmlFile());
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(text, new StreamResult(requestData.getFoFile()));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void transformFoFile2PdfFile(RequestData requestData)  {


        try {

            FopFactory fopFactory = FopFactory.newInstance(new File(appData.getFopConfigResource()));
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


    }

    }
