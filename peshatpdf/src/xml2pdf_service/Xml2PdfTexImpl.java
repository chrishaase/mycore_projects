package xml2pdf_service;

import controller.RequestData;
import xml2pdf_service.xml2pdfTex.Tex2PDF;
import xml2pdf_service.xml2pdfTex.Xml2Tex;

public class Xml2PdfTexImpl implements Xml2Pdf {

    public Boolean createPdf(RequestData requestData) {

        Boolean b = false;

        // init service objects
        Xml2Tex generateTex = new Xml2Tex();
        Tex2PDF generatePDF = new Tex2PDF();

        //. create Tex
        b= generateTex.createTexFile(requestData);

        // create PDF
        if (b) {
            b = generatePDF.createPDFFile(requestData);
        }

       return b;
    }

}
