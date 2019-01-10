/**
 *
 * fuehrt Programme aus -
 * im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
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

        this.requestData = requestData;
        this.xml2PDF = getXml2PDF(requestData);
        this.xmlDao = getXmlDao(requestData);
    }
    
    public Boolean createPDF(){
        
        //1. ensure xml.file is loaded to xmlfilepath
        // implement via xmlDao();
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        // implmenent via xml2pdf
                        
               
        // 3. return erfolgsmeldung (noch checking einbauen)
        erfolg = true;
        return erfolg;
    }
    

    public Xml2Pdf getXml2PDF(RequestData requestData){
        switch (requestData.getXmlpdfservice()) {
            case "tex":
                return new Xml2PdfTexImpl();
            default:
                return new Xml2PdfTexImpl;
        }
        }

   public XmlDao getXmlDao (RequestData requestData){
       switch (requestData.getXmldao()) {
           case "rest":
               return new XmlDaoImpl();
           default:
               return new XmlDaoImpl();
       }
   }
    
}
