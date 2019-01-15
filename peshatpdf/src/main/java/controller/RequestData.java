package main.java.controller;

import java.io.File;

public class RequestData {

   // request information
    private final String mycoreId;
    private final String pdfEngine;

    // Informationen aus web.xml
    // pathes
    private final String outFilePath;
    private final String urlPath;
    private final String xmlFilePath;
    private final String resourcePath;
    // tex and fop config
    private final String pdfTexCommand;
    private final String xsltFileNameTex;
    private final String xsltFileNameFop;
    private final String fopConfigFileName;

    // created Informationen
    private final String pdfFileName;
    private final String texFileName;
    private final String xmlFileName;
    private final String foFileName;
    private final File xmlFile;
    private final File pdfFile;
    private final File texFile;
    private final File foFile;



    RequestData(String mycoreId, String pdfEngine, String urlPath, String xmlFilePath, String outFilePath, String resourcePath,
                String xsltFileNameTex, String texCommand, String xsltFileNameFop, String fopConfigFileName){

        // request information
        this.mycoreId = mycoreId;

        // Informationen aus web.xml
        this.outFilePath = outFilePath;
        this.urlPath = urlPath;
        this.xmlFilePath = xmlFilePath;
        this.pdfTexCommand = texCommand;
        this.xsltFileNameTex = xsltFileNameTex;
        this.xsltFileNameFop = xsltFileNameFop;
        this.resourcePath = resourcePath;
        this.pdfEngine = pdfEngine;
        this.fopConfigFileName = fopConfigFileName;

        // generate file ids and files
        pdfFileName = mycoreId + ".pdf";
        xmlFileName = mycoreId + ".xml";
        texFileName = mycoreId + ".tex";
        foFileName = mycoreId + ".fo";
        xmlFile = new File(xmlFilePath, xmlFileName);
        texFile = new File(outFilePath, texFileName);
        pdfFile = new File(outFilePath, pdfFileName);
        foFile = new File(outFilePath, foFileName);

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

    public String getFoFileName() {
        return foFileName;
    }

    public File getFoFile() {
        return foFile;
    }

    public String getFopConfigFileName() {
        return fopConfigFileName;
    }

    public String getPdfEngine() {
        return pdfEngine;
    }

    public String getXsltFileNameTex() {
        return xsltFileNameTex;
    }

    public String getXsltFileNameFop() {
        return xsltFileNameFop;
    }
}
