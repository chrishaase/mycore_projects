/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texpdf_view;

import java.io.File;

/**
 *
 * @author chase
 */


public class Tex2PDF {
    
    public void createSingleIdFile (String mycoreid, String filepath){
        
        String pdfFileName = mycoreid + ".pdf";
        String texFileName = mycoreid + ".tex";
	File pdfFile = new File(filepath, pdfFileName);
        File texFile = new File(filepath, texFileName);
        
     ProcessBuilder pb = new ProcessBuilder("pdflatex", "-interaction=nonstopmode", 
                texFileName);
        pb.directory(new File(filepath));
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
    }
}
