package main.java.xml_rest_util;

import main.java.controller.RequestData;

import java.io.File;

public abstract class RestGetXml {

    protected final RequestData requestData;
    protected final File xmlFile;


    public RestGetXml(RequestData requestData) {

        this.requestData = requestData;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        this.xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

    }


    public abstract String httpGet ();
    public abstract Boolean save(String xmlobject);
    public abstract Boolean httpGetAndSave2File();
}