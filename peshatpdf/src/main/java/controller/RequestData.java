package main.java.controller;

import java.io.File;

public class RequestData {

    // REQUEST DATA
    private final String mycoreId;
    private final String pdfEngine;

    // APP-REQUEST created DATA
    private final String pdfFileName;
    private final String texFileName;
    private final String xmlFileName;
    private final String xmlFileLinksName;
    private final String foFileName;
    private final File xmlFile;
    private final File xmlLinksFile;
    private final File pdfFile;
    private final File texFile;
    private final File foFile;




    public RequestData(String mycoreId, String pdfEngine, AppData appData){

        // request information
        this.mycoreId = mycoreId;
        this.pdfEngine = pdfEngine;

        // generate file ids and files
        pdfFileName = mycoreId + ".pdf";
        xmlFileName = mycoreId + ".xml";
        xmlFileLinksName = mycoreId + "_links" + ".xml";
        texFileName = mycoreId + ".tex";
        foFileName = mycoreId + ".fo";
        xmlFile = new File(appData.getXmlFilePath(), xmlFileName);
        xmlLinksFile = new File (appData.getXmlFilePath(), xmlFileLinksName);
        texFile = new File(appData.getOutFilePath(), texFileName);
        pdfFile = new File(appData.getOutFilePath(), pdfFileName);
        foFile = new File(appData.getOutFilePath(), foFileName);


    }

    // GETTER

    public String getMycoreId() {
        return mycoreId;
    }

    public String getPdfEngine() {
        return pdfEngine;
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

    public String getFoFileName() {
        return foFileName;
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

    public File getFoFile() {
        return foFile;
    }

    public String getXmlFileLinksName() {
        return xmlFileLinksName;
    }

    public File getXmlLinksFile() {
        return xmlLinksFile;
    }
}
