package main.java.xmlFile_dao;

import main.java.util.FileHandler;
import main.java.controller.RequestData;
import main.java.util.XmlGetRest;

import java.io.File;

public class XmlFile_dao {

    private final RequestData requestData;
    private final XmlGetRest rest;
    private FileHandler fileHandler;

    public XmlFile_dao(RequestData requestData, XmlGetRest rest){

        this.requestData = requestData;
        this.rest = rest;

    }

    public Boolean getXmlFileInPath(){

        //. check if xml in xml-filestore
        Boolean b = fileHandler.fileExists(requestData.getXmlFile());

        // if not present, load from rest service and saveXmlStr2File to filepath
        if (!b){
          b = rest.httpGetAndSave2File(requestData.getMycoreid(), requestData.getUrlpath(), requestData.getXmlFile());
        }

        // final evaluation ob file jetzt in filestore
        b = fileHandler.fileExists(requestData.getXmlFile());

        return b;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }
}
