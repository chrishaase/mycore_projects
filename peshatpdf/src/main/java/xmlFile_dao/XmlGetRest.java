package main.java.xmlFile_dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import main.java.controller.AppData;
import main.java.controller.RequestData;
import main.java.util.FileHandler;
import sun.misc.Request;

import java.io.File;

/**
 *
 * @author chase
 */


public class XmlGetRest {


    private final FileHandler fileHandler;
    private final AppData appData;

    public XmlGetRest(FileHandler fileHandler, AppData appData){

        this.fileHandler = fileHandler;
        this.appData = appData;
    }

    public String httpGet (String mycoreid){
       

        String string = "";
        String urlstr = appData.getUrlPath() + mycoreid;
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


    

