package main.java.controller;

public class AppData {


    // APP DATA
    private final String outFilePath;
    private final String urlPath;
    private final String xmlFilePath;
    private final String resourcePath;
    private final String pdfTexCommand;
    private final String xsltFileNameTex;
    private final String xsltFileNameFop;
    private final String fopConfigFileName;

    AppData (String urlPath, String xmlFilePath, String outFilePath, String resourcePath,
             String xsltFileNameTex, String texCommand, String xsltFileNameFop, String fopConfigFileName){


        // Informationen aus web.xml
        this.outFilePath = outFilePath;
        this.urlPath = urlPath;
        this.xmlFilePath = xmlFilePath;
        this.pdfTexCommand = texCommand;
        this.xsltFileNameTex = xsltFileNameTex;
        this.xsltFileNameFop = xsltFileNameFop;
        this.resourcePath = resourcePath;
        this.fopConfigFileName = fopConfigFileName;
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

    public String getResourcePath() {
        return resourcePath;
    }

    public String getPdfTexCommand() {
        return pdfTexCommand;
    }

    public String getXsltFileNameTex() {
        return xsltFileNameTex;
    }

    public String getXsltFileNameFop() {
        return xsltFileNameFop;
    }

    public String getFopConfigFileName() {
        return fopConfigFileName;
    }
}
