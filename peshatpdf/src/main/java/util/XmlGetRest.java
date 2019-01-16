package main.java.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import main.java.controller.AppData;
import main.java.controller.RequestData;
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

    public String httpGet (RequestData requestData){
       

        String string = "";
        String urlstr = appData.getUrlPath() + requestData.getMycoreId();
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

    public Boolean saveXmlStr2File(String mcrObjString, RequestData requestData) {

            fileHandler.writeString2File(requestData.getXmlFile(), mcrObjString);
            return fileHandler.fileExists(requestData.getXmlFile());
        }

    public Boolean httpGetAndSave2File(RequestData requestData) {

        String mcrObjString = httpGet(requestData);
        return saveXmlStr2File(mcrObjString, requestData);


    }


    }


    

