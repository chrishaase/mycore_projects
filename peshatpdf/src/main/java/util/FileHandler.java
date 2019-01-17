package main.java.util;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

        try (FileWriter writer = new FileWriter(file, false)){

            writer.write(mcrObjString, 0, mcrObjString.length());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void resourceFile2ServerFile(String resourceFileWithPath, String serverFileWithPath) {

        Path resourceFilePath = Paths.get("/");
                // GET CORRECT PATH OF RESOURCE FILE
        try {
            URL url = ClassLoaderUtil.getResource(resourceFileWithPath, this.getClass());
            resourceFilePath = Paths.get(url.toURI());
            System.out.println(url.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        // COPY RESOURCE FILE TO OUTPUT-serverFileWithPath

        File inputFile = resourceFilePath.toFile();
        try (InputStream streamIn = new FileInputStream(inputFile)){
            Files.copy(streamIn, Paths.get(serverFileWithPath), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
