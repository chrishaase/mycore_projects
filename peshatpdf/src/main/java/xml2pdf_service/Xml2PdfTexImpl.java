package main.java.xml2pdf_service;

import main.java.controller.RequestData;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


public class Xml2PdfTexImpl implements Xml2Pdf {

    private final RequestData requestData;
    private final File pdfFile;
    private final File texFile;
    private final File xmlFile;
    private final String texFileName;
    private final String xsl_standard = "xml2tex_bib_standard.xsl";



    public Xml2PdfTexImpl (RequestData requestData){

        this.requestData = requestData;
        String pdfFileName = requestData.getMycoreid() + ".pdf";
        texFileName = requestData.getMycoreid() + ".tex";
        String xmlFileName = requestData.getMycoreid() + ".xml";
        pdfFile = new File(requestData.getOutfilepath(), pdfFileName);
        texFile = new File(requestData.getOutfilepath(), texFileName);
        xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);


    }

    public Boolean transformXmlFile2PdfFile() {

        Boolean b = false;

         //. create Tex using Standard-Bib-xsl and check if file is present
        transformXml2Tex(xsl_standard);
        // check if file exists
        b = fileExists(texFile);

        // create PDF if Tex present and check if present
        if (b) {
            transformTex2PDF();
            b = fileExists(pdfFile);
        }

       return b;
    }

    public void transformXml2Tex(String xml2TexResource)  {


        InputStream stylesheet = Xml2PdfTexImpl.class.getResourceAsStream(xml2TexResource);


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

        ProcessBuilder pb = new ProcessBuilder("pdflatex", "-interaction=nonstopmode",
                texFileName);
        pb.directory(new File(requestData.getOutfilepath()));
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
