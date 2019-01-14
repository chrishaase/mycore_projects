package main.java.controller;

import java.io.File;

public class RequestData {

   // request information
    private final String mycoreId;

    // Informationen aus web.xml
    private final String outFilePath;
    private final String urlPath;
    private final String xmlFilePath;
    private final String pdfTexCommand;
    private final String xsltFileName;
    private final String resourcePath;

    // created Informationen
    private final String pdfFileName;
    private final String texFileName;
    private final String xmlFileName;
    private final File xmlFile;
    private final File pdfFile;
    private final File texFile;



    RequestData(String mycoreId, String outFilePath, String urlPath, String xmlFilePath, String pdfTexCommand, String xsltFileName, String resourcePath){

        // request information
        this.mycoreId = mycoreId;

        // Informationen aus web.xml
        this.outFilePath = outFilePath;
        this.urlPath = urlPath;
        this.xmlFilePath = xmlFilePath;
        this.pdfTexCommand = pdfTexCommand;
        this.xsltFileName = xsltFileName;
        this.resourcePath = resourcePath;

        // generate file ids and files
        pdfFileName = mycoreId + ".pdf";
        xmlFileName = mycoreId + ".xml";
        texFileName = mycoreId + ".tex";
        xmlFile = new File(xmlFilePath, xmlFileName);
        texFile = new File(outFilePath, texFileName);
        pdfFile = new File(outFilePath, pdfFileName);

    }

    // GETTER

    public String getMycoreId() {
        return mycoreId;
    }

    public String getOutFilePath() {
        return outFilePath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getXmlFilePath() {
        return xmlFilePath;
    }

    public String getPdfTexCommand() {
        return pdfTexCommand;
    }

    public String getXsltFileName() {
        return xsltFileName;
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

    public String getResourcePath() {
        return resourcePath;
    }
}
