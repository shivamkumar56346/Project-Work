
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
public class LEDsServlet extends HttpServlet {

   
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
            out.println("<title>Servlet LEDsServlet</title>");            
            out.println("</head>");
            out.println("<body bgcolor='orangered'>");
             out.println("<center>");
            out.println("<h1><u>"+greet+"</h1>");
            out.println("<span style='color:blueviolet'><b>Admin LEDs Gallery!!</span>");
             out.println("<div style='background-color:palegreen'><hr>");
           int catId=Integer.parseInt(request.getParameter("catId"));
             try{
             Connection conn=DatabaseConnect.getMyConnection();
             PreparedStatement preStmt=conn.prepareStatement("select * from productsinfo where Product_Cat_Id=?");
               preStmt.setInt(1, catId);
               ResultSet rsltSet=preStmt.executeQuery();
                out.println("</u><table border='3' width='0%'>");
                  out.println("<thead>");
                    out.println("<th>Product_Id</th>");
                             out.println("<th>Product_Name</th>");
                                     out.println("<th>Product_Qty</th>");
                                      out.println("<th>Product_Price/Qty</th>");
                                       out.println("<th>Product_Image</th>");
                                        out.println("<th>Product_Description</th>");
                                       // out.println("<th>Click on Product</th>");
                             out.println("</thead>");
                while(rsltSet.next()){
                out.println("<tbody>");
                    out.println("<tr>");
                 out.println("<td>"+rsltSet.getInt(1)+"</td>");   
                 out.println("<td>"+rsltSet.getString(2)+"</td>");
                 out.println("<td>"+rsltSet.getInt(3)+"</td>");
                 out.println("<td>"+rsltSet.getInt(4)+"</td>");
                 out.println("<td><img src='"+rsltSet.getString(5)+"' width='120' height='80'/></td>");
                 out.println("<td>"+rsltSet.getString(6)+"</td>");
                 //out.println("<td><input type='checkbox' name=''/></td>");
                 out.println("</tr>");
                 out.println("</tbody>");
                }
                out.println("</table>");
                out.println("<hr></div>");
                out.println("<div style='text-align:center'>&copy;2018 ShivamKumar</div>");
         rsltSet.close();
         preStmt.close();
             }catch(Exception e){
             e.printStackTrace();
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
