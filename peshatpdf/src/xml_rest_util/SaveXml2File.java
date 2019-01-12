/*
 * 
 */
package xml_rest_util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import controller.RequestData;

/**
 *
 * @author chase
 */


public class SaveXml2File {
    
    public void save(String mcrId, String mcrObjString, String filepath){
        
        
        String xmlFileName = mcrId + ".xml";
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
