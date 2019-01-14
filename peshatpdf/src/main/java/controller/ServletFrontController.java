
package main.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
            response)
    {
        //1. init: Get init url&filepaths from web.xml and mycore ID from HTTP-request

        String mycoreid = request.getParameter("mycoreid"); // id des auszudruckenden Objektes
        String outfilepath = getServletContext().getInitParameter("outfilepath"); // directory for pdfs
        String xmlfilepath = getServletContext().getInitParameter("xmlfilepath"); // directory for xml-files (model)
        String urlpath = getServletContext().getInitParameter("urlpath");
        String xsltfile = getServletContext().getInitParameter("xsltfile");
        String texcommand = getServletContext().getInitParameter("texcommand");
        RequestData requestData = new RequestData(mycoreid, outfilepath, urlpath, xmlfilepath, texcommand, xsltfile);

        //2. Create Subcontroller fuer AufgabenAbarbeitung und Verdrahtung (kein DI-Framework)
        Controller controller = new Controller ();

       // 3. kreiere pdf und checke, dass pdf kreiert wurde und ausgabe
        Boolean erfolg = controller.createPDF(requestData);
       if (erfolg) {
        sendPDFResponse(response, requestData);
       } else {
        sendErrorHTMLResponse(response);
       }
       
}
      private void sendErrorHTMLResponse  (HttpServletResponse response) {
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
      
      private void sendPDFResponse (HttpServletResponse response, RequestData requestData){
       
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
            response)
    {
        doGet(request, response);
    }
    
    
  
    
}
