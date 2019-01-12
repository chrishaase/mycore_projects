package xml2pdfTex_util;

import controller.RequestData;
import xml2pdf_service.Xml2Pdf;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

public class Xml2PdfTexImpl implements Xml2Pdf {

    private final RequestData requestData;
    private final File pdfFile;
    private final File texFile;
    private final File xmlFile;
    private final String texFileName;
    private final String xsl_standard = "xml2pdf_bib_standard.xsl";



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


    Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }



}
