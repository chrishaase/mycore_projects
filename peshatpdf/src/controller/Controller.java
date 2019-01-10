/**
 *
 * Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
 * im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
 * Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
 * Nachbedingung: pdf existiert im outfilepath
 */     
package controller;

import xml2pdf_service.Xml2Pdf;
import xml2pdf_service.Xml2PdfTexImpl;
import xml_dao.XmlDao;
import xml_dao.XmlDaoRestImpl;
import java.io.File;

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
        erfolg = xmlDao.getXmlFile(requestData);
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.createPdf(requestData);
        }


        // 3. return erfolgsmeldung (noch checking einbauen)
        return erfolg;
    }
    

    private Xml2Pdf getXml2PDF(RequestData requestData){

                return new Xml2PdfTexImpl();

        }

   private XmlDao getXmlDao (RequestData requestData){

               return new XmlDaoRestImpl();

   }


    public Boolean fileExists(File file){
        boolean bFile = false;
        try {
            bFile = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bFile;
    }

}
