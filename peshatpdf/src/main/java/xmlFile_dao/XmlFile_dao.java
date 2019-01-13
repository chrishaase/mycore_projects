package main.java.xmlFile_dao;

import main.java.controller.RequestData;
import main.java.xmlFile_rest_util.XmlGetFromRest_util;

import java.io.File;

public class XmlFile_dao {

    private final RequestData requestData;
    private final File xmlFile;
    private final XmlGetFromRest_util rest;

    public XmlFile_dao(RequestData requestData, XmlGetFromRest_util rest){
        this.requestData = requestData;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);
        this.rest = rest;
    }

    public Boolean getXmlFileInPath(){

        boolean b = false;

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to filepath
        if (!b){
           b = rest.httpGetAndSave2File();
        }

        // final evaluation ob file jetzt in filestore
        b = fileExists(xmlFile);

        return b;
    }

    private Boolean fileExists(File xmlFile){
        boolean bFile = false;
        try {
            bFile = xmlFile.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }


}
