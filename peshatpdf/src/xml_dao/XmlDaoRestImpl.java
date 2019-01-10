package xml_dao;

import controller.RequestData;
import java.io.File;

public class XmlDaoRestImpl implements XmlDao {


    public Boolean getXmlFile(RequestData requestData){

        boolean b = true;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        File xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

        //. check if xml in xml-filestore
        b = fileExists(xmlFile);

        // if not load from rest service and save to file

        if (true){
            RestGetXml rest = new RestGetXml();
            String xmlString = rest.httpGet(requestData);
            SaveXml2File save = new SaveXml2File();
            save.save(requestData, xmlString);
        }

        // final evaluation ob file jetzt in filestore
        b = fileExists(xmlFile);


        return true;
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
