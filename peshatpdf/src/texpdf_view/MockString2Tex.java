/*
 * author chase
 */
package texpdf_view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ahzch
 */
public class MockString2Tex {
     
    public void createFile(String mycoreid, String filepath) {

        
        String texFileName = mycoreid + ".tex";
	File texFile = new File(filepath, texFileName);
        
        // 1. create the .tex file
        String newLineWithSeparation = System.getProperty("line.separator") 
                + System.getProperty("line.separator");
        String mycore = "";
        mycore += "\\documentclass{article}" + newLineWithSeparation;
        mycore += "\\usepackage[pdftex]{graphicx}" + newLineWithSeparation;
        mycore += "\\usepackage[T1]{fontenc}" + newLineWithSeparation;
        mycore += "\\usepackage{pslatex}" + newLineWithSeparation;
        mycore += "\\usepackage[hebrew, english]{babel}" + 
                newLineWithSeparation;
        mycore += "\\usepackage{cjhebrew}" + newLineWithSeparation;
        mycore += "\\begin{document}" + newLineWithSeparation;
        mycore += "Hi "+  newLineWithSeparation;
        mycore += "\\begin{cjhebrew}" + newLineWithSeparation;
        mycore += "br+syt br' 'lhym" + newLineWithSeparation;
        mycore += "\\end{cjhebrew}" + newLineWithSeparation;
        mycore += "\\begin{flushright}" + newLineWithSeparation;
        mycore += "When God began"+newLineWithSeparation;
        mycore += "\\end{flushright}" + newLineWithSeparation;
        mycore += "\\end{document}";

        // 2. Save the .tex file
        FileWriter writer = null;
        try {
            writer = new FileWriter(texFile, false);
            writer.write(mycore, 0, mycore.length());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
       
              

    }
    
}
