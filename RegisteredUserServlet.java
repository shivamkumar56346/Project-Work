
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
public class RegisteredUserServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisteredUserServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='green'>");
            out.println("<center>");
            out.println("<h1>"+greet+"</h1>");
            String un = request.getParameter("UserName");
            String up = request.getParameter("UserPass");
            String uc = request.getParameter("UserContact");
            String ue = request.getParameter("UserEmail");
            String ua = request.getParameter("UserAddress");
            try {
                    if(un.isEmpty() && up.isEmpty()){
                        if(uc.isEmpty() && ue.isEmpty()){
                            if(ua.isEmpty()){
                response.sendRedirect("index.jsp");         
                      }
                    }
                 }
                Connection conn = DatabaseConnect.getMyConnection();
                PreparedStatement preStmt = conn.prepareStatement("insert into registereduser values (?,?,?,?,?)");
                preStmt.setString(1, un);
                preStmt.setString(2, up);
                preStmt.setString(3, uc);
                preStmt.setString(4, ue);
                preStmt.setString(5, ua);
                int num = preStmt.executeUpdate();
                if (num > 0) {
                    response.sendRedirect("LoginPage.jsp");
                } else {
                    response.sendRedirect("RegisterPage.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.println("<center>");
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
