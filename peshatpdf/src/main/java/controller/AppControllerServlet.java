
package main.java.controller;

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

public class AppControllerServlet extends HttpServlet {
    
               
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse 
            response)
    {
        // 0. Get App-Parameter
        String urlPath = getServletContext().getInitParameter("urlPath");
        String xmlFilePath = getServletContext().getInitParameter("xmlFilePath");
        String outFilePath = getServletContext().getInitParameter("outFilePath");
        String resourcePath = getServletContext().getInitParameter("resourcePath");
        String xsltFileNameTex = getServletContext().getInitParameter("xsltFileNameTex");
        String texCommand = getServletContext().getInitParameter("texCommand");
        String xsltFileNameFop = getServletContext().getInitParameter("xsltFileNameFop");
        String fopConfigFileName = getServletContext().getInitParameter("fopConfigFileName");
        AppData appData = new AppData (urlPath, xmlFilePath, outFilePath, resourcePath, xsltFileNameTex, texCommand, xsltFileNameFop, fopConfigFileName);

        // 1. Get Request-Parameter
        String mycoreId = request.getParameter("mycoreId");
        String pdfEngine = request.getParameter("pdfEngine");
        RequestData requestData = new RequestData(mycoreId, pdfEngine, appData);

        //2. Create Subcontroller fuer AufgabenAbarbeitung und Verdrahtung
        RequestController requestController = new RequestController(requestData, appData);

       // 3. kreiere pdf und checke, dass pdf kreiert wurde und ausgabe
        Boolean erfolg = requestController.createPDF();
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
       

        try{
        response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "attachment; "
                        + "filename=" + requestData.getPdfFileName());
        response.setContentLength((int) requestData.getPdfFile().length());
        FileInputStream fileInputStream = new FileInputStream(requestData.getPdfFile());
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
