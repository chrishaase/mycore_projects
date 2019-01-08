/**
 *
 * fuehrt Programme aus - in naechster Version sollten hier Verzweigungen fuer 
 * verschiedene Programm-formatierungen stehen
 * Es muss sowohl a) der Datentyp rausgezogen werden aus XML
 * als auch b) mglw. ein Formatierungstyp (etwa Style 1 oder 2) berücksichtigt werden
 * Vorbedingung: mycoreid - correct - noch einbauen
 * Nachbedingung: pdf kreiert - noch einbauen
 */     
package controller;

import xmltex_modell.RestGetXML;
import xmltex_modell.SaveXML2File;
import texpdf_view.Tex2PDF;
import xmltex_modell.XML2Tex;
/**
 *
 * @author chase
 */
public class Controller {
    
    private final String mycoreid;
    private final String filepath;
    private final String urlpath;
    private final String formatid;
    private final Tex2PDF generatePDF;
    private final XML2Tex generateTex;
    private final RestGetXML rest;
    private final SaveXML2File saveXML2File;
    private Boolean erfolg;
       
        
    public Controller (String filepath, String urlpath, String mycoreid, String formatid) {
        
        this.filepath = filepath;
        this.urlpath = urlpath;
        this.mycoreid = mycoreid;
        this.formatid = formatid;
        this.generatePDF = new Tex2PDF();
        this.generateTex = new XML2Tex();
        this.rest = new RestGetXML();
        this.saveXML2File = new SaveXML2File();
    }
    
    public Boolean createPDF(){
        
        //1. get from rest api
        getSingleXML2File();
       
        //2. transform to pdf
        transformSingleXMLFile2PDF_bib_standard();     
                        
               
        // 3. return erfolgsmeldung (noch checking einbauen)
        erfolg = true;
        return erfolg;
    }
    
    public void getSingleXML2File(){
        // load_modell: load mycoreid xmlString Obj from rest service and save2file
        String stringMcrObj = rest.httpGet(mycoreid, urlpath);
        saveXML2File.save(mycoreid, stringMcrObj, filepath);
    }
    
    public void transformSingleXMLFile2PDF_bib_standard(){
        // create_view: create tex.file from xml.file and generate PDF-file from tex
        generateTex.createBibStandardFile(mycoreid, filepath);
        generatePDF.createSingleIdFile(mycoreid, filepath); 
    }
    
    
    
}
