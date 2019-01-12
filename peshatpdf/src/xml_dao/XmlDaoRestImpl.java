package xml_dao;

import controller.RequestData;
import xml_rest_util.RestGetXml;
import xml_rest_util.SaveXml2File;

import java.io.File;

public class XmlDaoRestImpl implements XmlDao {

    private final RequestData requestData;
    private final File xmlFile;
    private final SaveXml2File save;
    private RestGetXml rest;

    public XmlDaoRestImpl (RequestData requestData){
        this.requestData = requestData;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);
        save = new SaveXml2File();

    }

    public Boolean getXmlFileInPath(){

        boolean b = false;

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to filepath

        if (b){
            String xmlString = rest.httpGet(requestData);
            save.save(requestData, xmlString);
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
