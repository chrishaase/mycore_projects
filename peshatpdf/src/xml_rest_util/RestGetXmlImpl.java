package xml_rest_util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author chase
 */



public class RestGetXmlImpl implements RestGetXml{



    public String httpGet (String urlpath, String id){
       
        
        
        String string = "";
        String urlstr = urlpath + id;
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

    public void httpGetAndSave2File(String urlpath, String id, String filepath){

        String mcrObjString = httpGet(urlpath, id);

        String xmlFileName = id + ".xml";
        File xmlFile = new File(filepath, xmlFileName);

        FileWriter writer = null;
        try {
            writer = new FileWriter(xmlFile, false);
            writer.write(mcrObjString, 0, mcrObjString.length());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    
}
