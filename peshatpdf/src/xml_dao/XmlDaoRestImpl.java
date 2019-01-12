package xml_dao;

import controller.RequestData;
import xml_rest_util.RestGetXml;

import java.io.File;

public class XmlDaoRestImpl implements XmlDao {

    private final RequestData requestData;
    private final File xmlFile;
    private RestGetXml rest;

    public XmlDaoRestImpl (RequestData requestData){
        this.requestData = requestData;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);


    }

    public Boolean getXmlFileInPath(){

        boolean b = false;

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to filepath

        if (b){
            rest.httpGetAndSave2File(requestData.getUrlpath(), requestData.getMycoreid(), requestData.getXmlfilepath());
        }

        // final evaluation ob file jetzt in filestore
        b = fileExists(xmlFile);


        return b;
    }

    Boolean fileExists(File xmlFile){
        boolean bFile = false;
        try {
            bFile = xmlFile.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }
    public void setRest(RestGetXml rest) {
        this.rest = rest;
    }


}
