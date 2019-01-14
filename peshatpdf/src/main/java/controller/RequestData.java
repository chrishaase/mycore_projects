package main.java.controller;

import java.io.File;

public class RequestData {

   // request information
    private final String mycoreid;

    // Informationen aus web.xml
    private final String outfilepath;
    private final String urlpath;
    private final String xmlfilepath;
    private final String pdfTexCommand;
    private final String xsltFile;

    // created Informationen
    private final String pdfFileName;
    private final String texFileName;
    private final String xmlFileName;
    private final File xmlFile;
    private final File pdfFile;
    private final File texFile;



    RequestData(String mycoreid, String outfilepath, String urlpath,  String xmlfilepath, String pdfTexCommand, String xsltFile){

        // request information
        this.mycoreid = mycoreid;

        // Informationen aus web.xml
        this.outfilepath = outfilepath;
        this.urlpath = urlpath;
        this.xmlfilepath = xmlfilepath;
        this.pdfTexCommand = pdfTexCommand;
        this.xsltFile = xsltFile;

        // generate file ids and files
        pdfFileName = mycoreid + ".pdf";
        xmlFileName = mycoreid + ".xml";
        texFileName = mycoreid + ".tex";
        xmlFile = new File(xmlfilepath, xmlFileName);
        texFile = new File(outfilepath, texFileName);
        pdfFile = new File(outfilepath, pdfFileName);

    }

    // GETTER

    public String getMycoreid() {
        return mycoreid;
    }

    public String getOutfilepath() {
        return outfilepath;
    }

    public String getUrlpath() {
        return urlpath;
    }

    public String getXmlfilepath() {
        return xmlfilepath;
    }

    public String getPdfTexCommand() {
        return pdfTexCommand;
    }

    public String getXsltFile() {
        return xsltFile;
    }

    public String getPdfFileName() {
        return pdfFileName;
    }

    public String getTexFileName() {
        return texFileName;
    }

    public String getXmlFileName() {
        return xmlFileName;
    }

    public File getXmlFile() {
        return xmlFile;
    }

    public File getPdfFile() {
        return pdfFile;
    }

    public File getTexFile() {
        return texFile;
    }
}
