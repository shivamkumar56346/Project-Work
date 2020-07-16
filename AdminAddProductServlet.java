
package com.MyPackage;

import com.db.DatabaseConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivam
 */
public class AdminAddProductServlet extends HttpServlet {

   
    
   
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
        
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddProductServlet</title>");            
            out.println("</head>");
            out.println("<body bgcolor='orange'>");
            out.println("<center>");
             out.println("<h1>"+greet+"</h1>");
            out.println("<h2>Admin added Product Category!!</h2>");
            int cid=Integer.parseInt(request.getParameter("Category_Id"));
            String cin=request.getParameter("Category_Name");
           try{
               if(cin.isEmpty()){
                   response.sendRedirect("SuccessServlet");
                    }
           Connection conn=DatabaseConnect.getMyConnection();
           PreparedStatement pre=conn.prepareStatement("insert into productcategory values(?,?)");
           pre.setInt(1, cid);
           pre.setString(2, cin);
            int num=pre.executeUpdate();
          if(num>0)
          { 
            response.sendRedirect("AddAdmin_ProductInfo_Page.jsp");
          }
          else{
                response.sendRedirect(" SuccessServlet");
          }
           }
            catch(Exception e){
                e.printStackTrace();
            }
         
      
            out.println("</center>");
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
