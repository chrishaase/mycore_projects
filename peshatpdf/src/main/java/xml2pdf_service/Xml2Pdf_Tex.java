package main.java.xml2pdf_service;

import main.java.controller.RequestData;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class Xml2Pdf_Tex extends Xml2Pdf {

    protected final File texFile;
    protected final String xsl_standard;
    protected final String texCommand;

    public Xml2Pdf_Tex(RequestData requestData){
        super(requestData);
        texFile = new File(requestData.getOutfilepath(), texFileName);
        xsl_standard = requestData.getPdfTexXslFile();
        texCommand = requestData.getPdfTexCommand();

    }

    public Boolean transformXmlFile2PdfFile() {

        Boolean b = false;

        //. create Tex using Standard-Bib-xsl and check if file is present
        transformXml2Tex();
        // check if file exists
        b = fileExists(texFile);

        // create PDF if Tex present and check if present
        if (b) {
            transformTex2PDF();
            b = fileExists(pdfFile);
        }

        return b;
    }

    public void transformXml2Tex()  {


        InputStream stylesheet = Xml2Pdf_Tex.class.getResourceAsStream(xsl_standard);


        // 1. create the .tex file

        try{
            Source xslt        = new StreamSource(stylesheet);
            Source             text        = new StreamSource(xmlFile);
            TransformerFactory factory     = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xslt);

            transformer.transform(text, new StreamResult(texFile));
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public void transformTex2PDF(){

        ProcessBuilder pb = new ProcessBuilder(texCommand, "-interaction=nonstopmode",
                texFileName);
        pb.directory(new File(requestData.getOutfilepath()));
        try {
            Process p = pb.start();
            Xml2Pdf_Tex.StreamPrinter sPrint = new Xml2Pdf_Tex.StreamPrinter(p.getInputStream(), false);
            Xml2Pdf_Tex.StreamPrinter sError = new Xml2Pdf_Tex.StreamPrinter(p.getErrorStream(), false);
            new Thread(sPrint).start();
            new Thread(sError).start();
            p.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }

    class StreamPrinter implements Runnable {

        private final InputStream inputStream;

        private boolean print;

        public StreamPrinter(InputStream inputStream, boolean print) {
            this.inputStream = inputStream;
            this.print = print;
        }

        private BufferedReader getBufferedReader(InputStream is) {
            return new BufferedReader(new InputStreamReader(is));
        }

        @Override
        public void run() {
            BufferedReader br = getBufferedReader(inputStream);
            String line = "";
            try {
                while ((line = br.readLine()) != null) {
                    if (print) {
                        System.out.println(line);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}