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
public class AdminUpdateProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext ctx = getServletContext();
        String greet = ctx.getInitParameter("greetings");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminUpdateProductServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='FF00FF'>");
            out.println("<h1>" + greet + "</h1>");
            out.println("<h2>AdminUpdateProduct!!</h2>");
            out.println("<center>");

            try {

                System.out.println("Info");
                
                System.out.println(request.getParameter("Product_Cat_Id"));
                System.out.println(request.getParameter("Product_Id"));
                System.out.println(request.getParameter("Product_Qty"));
                System.out.println(request.getParameter("Product_Price"));
                
                
                int cad = Integer.parseInt(request.getParameter("Product_Cat_Id"));
                int cid = Integer.parseInt(request.getParameter("Product_Id"));
                int cqty = Integer.parseInt(request.getParameter("Product_Qty"));
                float cpr = Float.parseFloat(request.getParameter("Product_Price"));
                System.out.println("--------------------------------------------");
                System.out.println(cad);
                System.out.println(cid);
                System.out.println(cqty);
                System.out.println(cpr);
                System.out.println("--------------------------------------------");

                Connection con = DatabaseConnect.getMyConnection();
                PreparedStatement pst = con.prepareStatement("update productsinfo set Product_Qty=?,Product_Price=? where Product_Id=? and Product_Cat_Id=?");
                pst.setInt(1, cqty);
                pst.setFloat(2, cpr);
                pst.setInt(3, cid);
                pst.setInt(4, cad);

                int num = pst.executeUpdate();
                if (num > 0) {
                    out.println("updated Succesfully!!<br/><br/>");
                    out.println("<a href='AdminDisplayProductServlet'>Click here to display an update product</a><br/>");
                } else {
                    out.println("No need to update details of products!!");
                    out.println("<a href='SuccessServlet'>Click here to Welcome Page</a><br/>");
                }
            } catch (Exception e) {
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
