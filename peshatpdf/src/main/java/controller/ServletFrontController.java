
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
        // Variablen-Abarbeitung in Methode and passing on is Threadsafe

        String mycoreId = request.getParameter("mycoreId");
        String pdfEngine = request.getParameter("pdfEngine");
        String urlPath = getServletContext().getInitParameter("urlPath");
        String xmlFilePath = getServletContext().getInitParameter("xmlFilePath");
        String outFilePath = getServletContext().getInitParameter("outFilePath");
        String resourcePath = getServletContext().getInitParameter("resourcePath");
        String xsltFileNameTex = getServletContext().getInitParameter("xsltFileNameTex");
        String texCommand = getServletContext().getInitParameter("texCommand");
        String xsltFileNameFop = getServletContext().getInitParameter("xsltFileNameFop");
        String fopConfigFileName = getServletContext().getInitParameter("fopConfigFileName");
        RequestData requestData = new RequestData(mycoreId, pdfEngine, urlPath, xmlFilePath, outFilePath, resourcePath, xsltFileNameTex, texCommand, xsltFileNameFop, fopConfigFileName);

        //2. Create Subcontroller fuer AufgabenAbarbeitung und Verdrahtung (kein DI-Framework)
        Controller controller = new Controller (requestData);

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
       
        String pdfFileName = requestData.getMycoreId() + ".pdf";
        File pdfFile = new File(requestData.getOutFilePath(), pdfFileName);
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
