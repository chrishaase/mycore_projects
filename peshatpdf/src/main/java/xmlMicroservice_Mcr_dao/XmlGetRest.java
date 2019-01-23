package main.java.xmlMicroservice_Mcr_dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import main.java.controller.AppConfigData;
import main.java.util.FileHandler;

import java.io.File;

/**
 *
 * @author chase
 */


public class XmlGetRest {


    private final FileHandler fileHandler;
    private final AppConfigData appConfigData;

    public XmlGetRest(FileHandler fileHandler, AppConfigData appConfigData){

        this.fileHandler = fileHandler;
        this.appConfigData = appConfigData;
    }

    public String httpGet (String mycoreid){
       

        String string = "";
        String urlstr = appConfigData.getUrlPath() + mycoreid;
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

    public Boolean saveXmlStr2File(String mcrObjString, File xmlFile) {

            fileHandler.writeString2File(xmlFile, mcrObjString);
            return fileHandler.fileExists(xmlFile);
        }

    public Boolean httpGetAndSave2File(String mycoreid, File xmlFile) {

        String mcrObjString = httpGet(mycoreid);
        return saveXmlStr2File(mcrObjString, xmlFile);


    }


    }


    

