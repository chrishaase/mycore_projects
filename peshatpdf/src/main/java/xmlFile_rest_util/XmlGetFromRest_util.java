package main.java.xmlFile_rest_util;

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



public class XmlGetFromRest_util {

    private final RequestData requestData;
    private final File xmlFile;


    public XmlGetFromRest_util(RequestData requestData) {

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

    public Boolean httpGetAndSave2File() {

        String mcrObjString = httpGet();
        Boolean b = save(mcrObjString);

        return b;

    }

    private Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }
    }


    

