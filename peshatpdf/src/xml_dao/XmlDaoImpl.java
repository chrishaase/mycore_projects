package xml_dao;

import controller.RequestData;
import java.io.File;
import java.io.IOException;
import utility.SaveXML2File;
import utility.RestGetXML;

public class XmlDaoImpl implements XmlDao {


    public Boolean getXmlFile(RequestData requestData){

        boolean b = false;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        File xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to file

        if (!b){
            RestGetXML rest = new RestGetXML();
            String xmlString = rest.httpGet(requestData);
            SaveXML2File save = new SaveXML2File();
            save.save(requestData, xmlString);
        }

        // final evaluation ob file jetzt in filestore
        b = fileExists(xmlFile);


        return b;
    }

    Boolean fileExists(File xmlFile){
        boolean bfileexists;
        try {
            bfileexists = xmlFile.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bfileexists;
    }

}
