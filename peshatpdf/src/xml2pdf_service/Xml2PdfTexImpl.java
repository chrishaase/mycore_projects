package xml2pdf_service;

import controller.RequestData;
import xml2pdf_service.xml2pdfTex.Tex2PDF;
import xml2pdf_service.xml2pdfTex.Xml2Tex;

public class Xml2PdfTexImpl implements Xml2Pdf {

    public Boolean transformXmlFile2PdfFile(RequestData requestData) {

        Boolean b = false;

        // init service objects
        Xml2Tex xml2Tex = new Xml2Tex();
        Tex2PDF tex2PDF = new Tex2PDF();

        //. create Tex
        b= xml2Tex.transform(requestData);

        // create PDF
        if (b) {
            b = tex2PDF.transform(requestData);
        }

       return b;
    }

}
