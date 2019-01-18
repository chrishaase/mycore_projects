package main.java.controller;

import java.io.File;

public class RequestData {

    // REQUEST DATA
    private final String mycoreId;
    private final String pdfEngine;

    // APP-REQUEST created DATA
    private final String pdfFileName;
    private final String texFileName;
    private final String mcrXmlFileName;
    private final String mcrXmlFileLinksName;
    private final String foFileName;
    private final String druckvorlageXmlFileName;
    private final File mcrXmlFile;
    private final File mcrXmlLinksFile;
    private final File pdfFile;
    private final File texFile;
    private final File foFile;
    private final File druckvorlageXmlFile;




    public RequestData(String mycoreId, String pdfEngine, AppData appData){

        // request information
        this.mycoreId = mycoreId;
        this.pdfEngine = pdfEngine;

        // generate file ids and files
        pdfFileName = mycoreId + ".pdf";
        mcrXmlFileName = mycoreId + ".xml";
        mcrXmlFileLinksName = mycoreId + "_links" + ".xml";
        texFileName = mycoreId + ".tex";
        foFileName = mycoreId + ".fo";
        druckvorlageXmlFileName = mycoreId + "_druckvorlage.xml";

        // Files
        mcrXmlFile = new File(appData.getXmlFilePath(), mcrXmlFileName); // mycore xml-input FILE
        mcrXmlLinksFile = new File (appData.getXmlFilePath(), mcrXmlFileLinksName); // file mit links des mycore xml-input File
        texFile = new File(appData.getOutFilePath(), texFileName); // tex-master-vorlage output file
        pdfFile = new File(appData.getOutFilePath(), pdfFileName); // pdf-final
        foFile = new File(appData.getOutFilePath(), foFileName); // fo-master-vorlage output file
        druckvorlageXmlFile = new File(appData.getOutFilePath(), druckvorlageXmlFileName); // druckvorlage


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

    public String getMcrXmlFileName() {
        return mcrXmlFileName;
    }

    public String getFoFileName() {
        return foFileName;
    }

    public File getMcrXmlFile() {
        return mcrXmlFile;
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

    public String getMcrXmlFileLinksName() {
        return mcrXmlFileLinksName;
    }

    public File getMcrXmlLinksFile() {
        return mcrXmlLinksFile;
    }

    public String getDruckvorlageXmlFileName() {
        return druckvorlageXmlFileName;
    }

    public File getDruckvorlageXmlFile() {
        return druckvorlageXmlFile;
    }
}
