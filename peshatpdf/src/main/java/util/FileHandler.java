package main.java.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

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

    public void resourceFile2ServerFile(String resourceFileWithPath, String serverFileWithPath) {

        URL url = ClassLoaderUtil.getResource(resourceFileWithPath, this.getClass());

        try {

            String string = url.toURI().toString();
            String substring = string.substring(5); // cut-off first five characters = "file:"
            FileReader filein = new FileReader(substring);
            FileWriter output = new FileWriter(serverFileWithPath);
            int c;
            while ((c = filein.read()) != -1) {
                output.write(c);
            }
            filein.close();
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
