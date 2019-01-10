/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2pdf_service.xml2pdfTex;

import controller.RequestData;

import java.io.File;
import java.io.InputStream;
import javax.xml.transform.stream.StreamSource; 
import javax.xml.transform.stream.StreamResult; 
import javax.xml.transform.*;



/**
 * Diese klasse muss noch an verschiedene Typen angepasst werden - stylesheets je nach DatenTyp
 * @author chase
 */
public class Xml2Tex {
     
    public Boolean transform(RequestData requestData)  {

        Boolean b = false;

        String texFileName = requestData.getMycoreid() + ".tex";
	String xmlFileName = requestData.getMycoreid() + ".xml";
        File texFile = new File(requestData.getOutfilepath(), texFileName);
        File xmlFile = new File(requestData.getXmlfilepath(), xmlFileName);
        InputStream stylesheet = Xml2Tex.class.getResourceAsStream("XML2Tex_bib_standard.xsl");
                
        
        // 1. create the .tex file
                         
        try{
        Source             xslt        = new StreamSource(stylesheet);
        Source             text        = new StreamSource(xmlFile);
        TransformerFactory factory     = TransformerFactory.newInstance();
        Transformer        transformer = factory.newTransformer(xslt);
        
        transformer.transform(text, new StreamResult(texFile));
        } catch (Exception e){
            e.printStackTrace();
        }

        b = fileExists(texFile);

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
