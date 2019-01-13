package main.java.xml_rest_util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.java.controller.RequestData;



/**
 *
 * @author chase
 */



public class RestGetXmlImpl extends RestGetXml{

    public RestGetXmlImpl(RequestData requestData) {

        super(requestData);

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

    public Boolean httpGetAndSave2File() {

        String mcrObjString = httpGet();
        Boolean b = save(mcrObjString);

        return b;

    }

        public Boolean save (String mcrObjString) {


            FileWriter writer = null;
            try {
                writer = new FileWriter(xmlFile, false);
                writer.write(mcrObjString, 0, mcrObjString.length());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            return fileExists(xmlFile);
        }
    Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }
    }


    

