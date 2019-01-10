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

import xml2pdf_service.Xml2Pdf;
import xml2pdf_service.Xml2PdfTexImpl;
import xml_dao.XmlDao;
import xml_dao.XmlDaoImpl;

/**
 *
 * @author chase
 */
public class Controller {
    
    private final RequestData requestData;
    private final Xml2Pdf xml2PDF;
    private final XmlDao xmlDao;
    private Boolean erfolg;
       
        
    public Controller (RequestData requestData) {

        this requestData = requestData;




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
        saveXML2File.save(mycoreid, stringMcrObj, outfilepath);
    }
    
    public void transformSingleXMLFile2PDF_bib_standard(){
        // create_view: create tex.file from xml.file and generate PDF-file from tex
        generateTex.createBibStandardFile(mycoreid, outfilepath);
        generatePDF.createSingleIdFile(mycoreid, outfilepath);
    }
    
    
    
}
