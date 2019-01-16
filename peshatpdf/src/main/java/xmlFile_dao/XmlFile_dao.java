package main.java.xmlFile_dao;

import main.java.util.FileHandler;
import main.java.controller.RequestData;
import main.java.util.XmlGetRest;

public class XmlFile_dao {

    private final XmlGetRest rest;
    private final FileHandler fileHandler;

    public XmlFile_dao(XmlGetRest rest, FileHandler fileHandler){

        this.fileHandler = fileHandler;
        this.rest = rest;

    }

    public Boolean getXmlFileInPath(RequestData requestData){

        //. check if xml in xml-filestore
        Boolean b = fileHandler.fileExists(requestData.getXmlFile());

        // if not present, load from rest service and saveXmlStr2File to filepath
        if (!b){
          b = rest.httpGetAndSave2File(requestData);
        }

        // final evaluation ob file jetzt in filestore
        b = fileHandler.fileExists(requestData.getXmlFile());

        return b;
    }


}
