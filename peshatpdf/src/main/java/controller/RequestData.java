package main.java.controller;

import java.io.File;

public class RequestData {

    private final String mycoreid;
    private final String outfilepath;
    private final String urlpath;
    private final String xmlfilepath;
    private final String pdfTexCommand;
    private final String xsltFile;
    private final String pdfFileName;
    private final String texFileName;
    private final String xmlFileName;
    private final File xmlFile;
    private final File pdfFile;
    private final File texFile;



    RequestData(String mycoreid, String outfilepath, String urlpath,  String xmlfilepath, String pdfTexCommand, String xsltFile){

        this.mycoreid = mycoreid;
        this.outfilepath = outfilepath;
        this.urlpath = urlpath;
        this.xmlfilepath = xmlfilepath;
        this.pdfTexCommand = pdfTexCommand;
        this.xsltFile = xsltFile;
        pdfFileName = mycoreid + ".pdf";
        xmlFileName = mycoreid + ".xml";
        texFileName = mycoreid + ".tex";
        xmlFile = new File(xmlfilepath, xmlFileName);
        texFile = new File(outfilepath, texFileName);
        pdfFile = new File(outfilepath, pdfFileName);

    }

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
