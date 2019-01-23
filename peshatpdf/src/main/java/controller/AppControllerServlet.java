
package main.java.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front-Servlet Controller -
 * beauftragt einen Request-Controller mit der Abarbeitung des Druckauftrages
 * gibt PDF aus bei Erfolg, ansonsten eine Fehler-HTML
 * Vorbedingung: App konfiguriert (see Readme), RequestData (mycoreID, pdfEngine) valide
 * Nachbedingung: PDF ausgegeben oder Fehler-HTML ausgegeben
 * @author chase
 */

public class AppControllerServlet extends HttpServlet {
    
               
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse 
            response)
    {
        // 1. Create Request-Data and Request-Controller
        String mycoreId = request.getParameter("mycoreId");
        String pdfEngine = request.getParameter("pdfEngine");
        AppConfigData appConfigData = new AppConfigData();
        RequestData requestData = new RequestData(mycoreId, pdfEngine, appConfigData);

        RequestController requestController = new RequestController(requestData);

       // 2. kreiere pdf und checke, dass pdf kreiert wurde und ausgabe
        // TODO replace Mock Object
        Boolean erfolg = requestController.createPDFFromHelperObject();
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
