package main.java.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }

    public void writeString2File(File file, String mcrObjString){

        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(mcrObjString, 0, mcrObjString.length());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
