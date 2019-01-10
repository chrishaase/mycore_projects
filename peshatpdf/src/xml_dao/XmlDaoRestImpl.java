package xml_dao;

import controller.RequestData;
import xml_dao.xml_util.RestGetXml;
import xml_dao.xml_util.SaveXml2File;

import java.io.File;

public class XmlDaoRestImpl implements XmlDao {


    public Boolean getXmlFileInPath(RequestData requestData){

        boolean b = false;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        File xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to filepath

        if (b){
            RestGetXml rest = new RestGetXml();
            String xmlString = rest.httpGet(requestData);
            SaveXml2File save = new SaveXml2File();
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

}
