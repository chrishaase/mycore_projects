package xml_dao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import controller.RequestData;


/**
 *
 * @author chase
 */



public class RestGetXml {
    
       
    public String httpGet (RequestData requestData){
       
        
        
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
    
    
}
