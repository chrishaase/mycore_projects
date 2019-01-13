package main.java.xmlFile_dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;

import main.java.util.FileHandler;
import main.java.controller.RequestData;
/**
 *
 * @author chase
 */


public class XmlGetRest_util {

    private final RequestData requestData;
    private final File xmlFile;
    private final FileHandler fileHandler = new FileHandler();


    public XmlGetRest_util(RequestData requestData) {

        this.requestData = requestData;
        String xmlFileName = requestData.getMycoreid() + ".xml";
        this.xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);

    }

    public String httpGet (){
       

        String string = "";
        String urlstr = requestData.getUrlpath() + requestData.getMycoreid();
        try {
            HttpResponse<String> response = Unirest
                    .get(urlstr)
                    .header("cache-control", "no-cache")
                    .header("Postman-Token", "59ed9456-7aea-49bf-a1fb-9c536b341b6d")
                    .asString();
            string = response.getBody();
        } catch (UnirestException e) {
            
            e.printStackTrace();
        }
        
        return string;
    }

    public Boolean save (String mcrObjString) {

            fileHandler.writeString2File(xmlFile, mcrObjString);
            return fileHandler.fileExists(xmlFile);
        }

    public Boolean httpGetAndSave2File() {

        String mcrObjString = httpGet();
        return save(mcrObjString);


    }


    }


    

