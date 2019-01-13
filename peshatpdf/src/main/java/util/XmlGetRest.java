package main.java.util;

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


public class XmlGetRest {

    private final RequestData requestData;
    private FileHandler fileHandler;


    public XmlGetRest(RequestData requestData) {

        this.requestData = requestData;


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

            fileHandler.writeString2File(requestData.getXmlFile(), mcrObjString);
            return fileHandler.fileExists(requestData.getXmlFile());
        }

    public Boolean httpGetAndSave2File() {

        String mcrObjString = httpGet();
        return save(mcrObjString);


    }
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    }


    

