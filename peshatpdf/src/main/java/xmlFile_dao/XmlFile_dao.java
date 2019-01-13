package main.java.xmlFile_dao;

import main.java.util.FileChecker;
import main.java.controller.RequestData;

import java.io.File;

public class XmlFile_dao {


    private final File xmlFile;
    private final XmlGetRest_util rest;
    private final FileChecker fileChecker = new FileChecker();

    public XmlFile_dao(RequestData requestData, XmlGetRest_util rest){

        this.rest = rest;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

    }

    public Boolean getXmlFileInPath(){

        //. check if xml in xml-filestore
        Boolean b = fileChecker.fileExists(xmlFile);

        // if not present, load from rest service and save to filepath
        if (!b){
          b = rest.httpGetAndSave2File();
        }

        // final evaluation ob file jetzt in filestore
        b = fileChecker.fileExists(xmlFile);

        return b;
    }



}
