
package com.MyPackage;

import com.db.DatabaseConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam
 */
public class WelcomeMarket_Servlet extends HttpServlet {


    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
        
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WelcomeMarket_Servlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='pink'>");
            out.println("<center>");
            out.println("<h1>"+greet+"</h1>");           
            out.println("<h2>Welcome to MyShopping Market !!!</h2>");
            out.println("<img src='images/ShivamScooty.jpg' width'500' height='250'/>");
            try {
                Connection conn = DatabaseConnect.getMyConnection();
                PreparedStatement preStmt = conn.prepareStatement("select * from productcategory");
                ResultSet rsltSet = preStmt.executeQuery();
                
                out.println("<br/><br/><center>");
                out.println("<table border='5' width='500' cellpadding='2' cellspacing='10'>");
                out.println("<thead>");
                out.println("<th>Click here on the below links</th><br/>");
                out.println("</thead>");
                while(rsltSet.next())
                {
                   out.println("<tbody>");
                    out.println("<tr>");
                    out.println("<td><center><a href='"+rsltSet.getString(2)+"Servlet?catId="+rsltSet.getInt(1)+"'>For Purchase of "+rsltSet.getString(2)+"</a></center></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                }
                rsltSet.close();
                preStmt.close();
                out.println("</table>");
                out.println("</center>");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception ="+e);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
