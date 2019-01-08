/*
 * 
 */
package xmltex_modell;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author chase
 */


public class SaveXML2File {
    
    public void save(String mycoreid, String mcrObjString, String filepath){
        
        
        String xmlFileName = mycoreid + ".xml";
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
