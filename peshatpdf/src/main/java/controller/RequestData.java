package main.java.controller;

public class RequestData {

    private final String mycoreid;
    private final String outfilepath;
    private final String urlpath;
    private final String xmlfilepath;


    public RequestData(String mycoreid, String outfilepath, String urlpath,  String xmlfilepath){

        this.mycoreid = mycoreid;
        this.outfilepath = outfilepath;
        this.urlpath = urlpath;
        this.xmlfilepath = xmlfilepath;


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


}
