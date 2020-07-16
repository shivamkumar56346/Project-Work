
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shivam
 */
public class LoginUserServlet extends HttpServlet {

    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace", "null"})
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
        
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginUserServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='yellow'>");
            out.println("<h1>"+greet+"</h1>");
            
            String un=request.getParameter("UserName");
             String up=request.getParameter("UserPass");
             HttpSession session=request.getSession();
             session.setAttribute("userN", un);
             
            try {
                if(un.isEmpty() && up.isEmpty()){
                response.sendRedirect("index.jsp");
                }
                if (un.equals("Admin") && up.equals("Admin")) {
                    response.sendRedirect("SuccessServlet");
                } else {
                    Connection conn = DatabaseConnect.getMyConnection();
                    PreparedStatement preStmt = conn.prepareStatement("select * from registereduser where UserName = ? and UserPass = ?");
                    preStmt.setString(1, un);
                    preStmt.setString(2, up);
                    ResultSet rsltSet = preStmt.executeQuery();
                    if (rsltSet.next()) {
                        response.sendRedirect("WelcomeMarket_Page.jsp");
                    } else {
                        response.sendRedirect("ErrorPage.jsp");
                    }
                }
            } catch (Exception e) {
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
