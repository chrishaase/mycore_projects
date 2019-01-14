package main.java.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;

/**
 *
 * @author chase
 */


public class XmlGetRest {


    private FileHandler fileHandler;


    public String httpGet (String mycoreid, String urlpath){
       

        String string = "";
        String urlstr = urlpath + mycoreid;
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

    public Boolean httpGetAndSave2File(String mycoreid, String urlpath, File xmlFile) {

        String mcrObjString = httpGet(mycoreid, urlpath);
        return saveXmlStr2File(mcrObjString, xmlFile);


    }
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    }


    

