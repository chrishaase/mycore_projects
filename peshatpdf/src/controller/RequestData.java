package controller;

public class RequestData {

    private final String mycoreid;
    private final String outfilepath;
    private final String urlpath;
    private final String xmlfilepath;
    private final String xmldao; // values can be "filestore" or "rest" depending on where to get xml-file from
    private final String xmlpdfservice; // values can be "tex" or "fo" depending on the transform-path and according services

    public RequestData(String mycoreid, String outfilepath, String urlpath,  String xmlfilepath, String xmldao, String xmlpdfservice){

        this.mycoreid = mycoreid;
        this.outfilepath = outfilepath;
        this.urlpath = urlpath;
        this.xmlfilepath = xmlfilepath;
        this.xmldao = xmldao;
        this.xmlpdfservice = xmlpdfservice;

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

    public String getXmldao() {
        return xmldao;
    }

    public String getXmlpdfservice() {
        return xmlpdfservice;
    }
}
