/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2pdf_service.xml2pdfTex;

import controller.RequestData;
import utility.StreamPrinter;
import java.io.File;

/**
 *
 * @author chase
 */


public class Tex2PDF {
    
    public Boolean createPDFFile(RequestData requestData){

        Boolean b = false;

        String pdfFileName = requestData.getMycoreid() + ".pdf";
        String texFileName = requestData.getMycoreid() + ".tex";
	File pdfFile = new File(requestData.getOutfilepath(), pdfFileName);
        File texFile = new File(requestData.getOutfilepath(), texFileName);
        
     ProcessBuilder pb = new ProcessBuilder("pdflatex", "-interaction=nonstopmode", 
                texFileName);
        pb.directory(new File(requestData.getOutfilepath()));
        try {
            Process p = pb.start();
            StreamPrinter sPrint = new StreamPrinter(p.getInputStream(), false);
            StreamPrinter sError = new StreamPrinter(p.getErrorStream(), false);
            new Thread(sPrint).start();
            new Thread(sError).start();
            p.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // check if file exists
        b = fileExists(pdfFile);

        return b;


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
