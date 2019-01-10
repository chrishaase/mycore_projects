/*
  Controlled Ausfuehrung der xml2pdf conversion und stellt pdf im outfilepath bereit
  im Momemt implementiert: pdf-creation via "tex" / dao via "rest" (siehe factory)
  Vorbedingung: mycoreid - correct - noch einbauen und xml-objekt mit mycore-id available in xmlfilepath oder on rest
  Nachbedingung: pdf existiert im outfilepath
 */     
package controller;

import xml2pdf_service.Xml2Pdf;
import xml2pdf_service.Xml2PdfTexImpl;
import xml_dao.XmlDao;
import xml_dao.XmlDaoRestImpl;


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
        this.xml2PDF = getXml2PDF();
        this.xmlDao = getXmlDao();
    }
    
    public Boolean createPDF(){
        
        //1. ensure xml.file is loaded to xmlfilepath
        erfolg = xmlDao.getXmlFileInPath(requestData);
       
        //2. transform to pdf and ensure pdf is created in outfilepath
        if (erfolg) {
            erfolg= xml2PDF.transformXmlFile2PdfFile(requestData);
        }


        // 3. return erfolgsmeldung (noch checking einbauen)
        return erfolg;
    }
    

    private Xml2Pdf getXml2PDF(){

                return new Xml2PdfTexImpl();

        }

   private XmlDao getXmlDao (){

               return new XmlDaoRestImpl();

   }


}
