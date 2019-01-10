
package controller;

import sun.misc.Request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chase
 */

public class ServletFrontController extends HttpServlet {
    
               
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException
    {
        //1. init: Get init url&filepaths from web.xml and mycore ID from HTTP-request
        
        String outfilepath = getServletContext().getInitParameter("outfilepath"); // directory for pdfs
        String xmlfilepath = getServletContext().getInitParameter("xmlfilepath"); // directory for xml-files (model)
        String mycoreid = request.getParameter("mycoreid"); // id des auszudruckenden Objektes

        //1.b. Set init-params for mycore-rest-service (if this pdf-printer is implemented on external-server)
        String urlpath = getServletContext().getInitParameter("urlpath");
        String xmldao = "rest"; // can be later changed/switched to "filestore" - attempts to load missing xml-file from rest

        //1.c. Set init-params for xml2pdf_service-conversion service: first impl via "tex"
        String xmlpdfservice = "tex";

        //1.d. create RequestData object
        RequestData requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath, xmldao, xmlpdfservice);
        
        //2. Create Subcontroller fuer AufgabenAbarbeitung - and initiate controller.createpdf
        Controller controller = new Controller (requestData);
        Boolean erfolg = controller.createPDF();

       // 3. checken, dass pdf kreiert wurde und ausgabe
       if (erfolg) {
        sendPDFResponse(response, requestData);
       } else {
        sendErrorHTMLResponse(response);
       }
       
}
      protected void sendErrorHTMLResponse  (HttpServletResponse response) {
        try{
          response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();  
        out.println("<b>Error! Please press your browser's back button and try again!</b>"); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      }
      
      protected void sendPDFResponse (HttpServletResponse response, RequestData requestData){
       
        String pdfFileName = requestData.getMycoreid() + ".pdf";
        File pdfFile = new File(requestData.getOutfilepath(), pdfFileName);
        try{
        response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "attachment; "
                        + "filename=" + pdfFileName);
        response.setContentLength((int) pdfFile.length());
        FileInputStream fileInputStream = new FileInputStream(pdfFile);
	OutputStream responseOutputStream = response.getOutputStream();
	int bytes;
	while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
        fileInputStream.close();
        responseOutputStream.flush();
        responseOutputStream.close();
        }
        catch (Exception e){
                    e.printStackTrace();
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException
    {
        doGet(request, response);
    }
    
    
  
    
}
