
package controller;

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
        
        String filepath = getServletContext().getInitParameter("filepath");
        String urlpath = getServletContext().getInitParameter("urlpath");
       
        String mycoreid = request.getParameter("mycoreid");
        String formatid = request.getParameter("formatid");

        
        //2. Create Subcontroller fuer AufgabenAbarbeitung - 
        Controller controller = new Controller (filepath, urlpath, mycoreid, formatid);
        Boolean erfolg = controller.createPDF();
        
                              
       // 3. checken, dass pdf kreiert wurde und ausgabe
       if (erfolg) {
        sendPDFResponse(response, mycoreid, filepath);
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
      
      protected void sendPDFResponse (HttpServletResponse response, String mycoreid, String filepath){
       
        String pdfFileName = mycoreid + ".pdf";
        File pdfFile = new File(filepath, pdfFileName);
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
