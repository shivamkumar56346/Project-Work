
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
public class AdminAddProductInfoServlet extends HttpServlet {

  
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
        
        try (PrintWriter out = response.getWriter()) {
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddProductInfoServlet</title>");            
            out.println("</head>");
            out.println("<body bgcolor='palegreen'>");
            out.println("<center>");
            out.println("<h1>"+greet+"</h1>");
            out.println("<h2>Admin added Product Details!!</h2>");
            int pid=Integer.parseInt(request.getParameter("Product_Id"));
            String pin=request.getParameter("Product_Name");
            int pqty=Integer.parseInt(request.getParameter("Product_Qty"));
            float pp=Float.parseFloat(request.getParameter("Product_Price"));
            String pi=request.getParameter("Product_Image");
            String pd=request.getParameter("Product_Desc");
            int pci=Integer.parseInt(request.getParameter("Product_Cat_Id"));
            try{
            Connection conn=DatabaseConnect.getMyConnection();
            PreparedStatement ps=conn.prepareStatement("insert into productsinfo values(?,?,?,?,?,?,?)");
            ps.setInt(1, pid);
            ps.setString(2,pin);
            ps.setInt(3,pqty);
            ps.setFloat(4, pp);
            ps.setString(5, pi);
            ps.setString(6, pd);
            ps.setInt(7,pci);
            int num=ps.executeUpdate();
            if(num>0){
            response.sendRedirect("AdminDisplayProductServlet");
            }
            else{
            response.sendRedirect("SuccessServlet");
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
