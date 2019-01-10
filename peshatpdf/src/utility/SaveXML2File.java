/*
 * 
 */
package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import controller.RequestData;

/**
 *
 * @author chase
 */


public class SaveXML2File {
    
    public void save(RequestData requestData, String mcrObjString){
        
        
        String xmlFileName = requestData.getMycoreid() + ".xml";
	File xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);
        
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
