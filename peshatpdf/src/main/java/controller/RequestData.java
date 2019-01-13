package main.java.controller;

public class RequestData {

    private final String mycoreid;
    private final String outfilepath;
    private final String urlpath;
    private final String xmlfilepath;
    private final String pdfTexCommand;
    private final String xsltFile;


    RequestData(String mycoreid, String outfilepath, String urlpath,  String xmlfilepath, String pdfTexCommand, String xsltFile){

        this.mycoreid = mycoreid;
        this.outfilepath = outfilepath;
        this.urlpath = urlpath;
        this.xmlfilepath = xmlfilepath;
        this.pdfTexCommand = pdfTexCommand;
        this.xsltFile = xsltFile;


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
}
