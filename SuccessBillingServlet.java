package com.MyPackage;
import com.db.DatabaseConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Shivam
 */
public class SuccessBillingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext ctx = getServletContext();
        String greet = ctx.getInitParameter("greetings");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuccessBillingServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='pink'>");
            out.println("<h1>" + greet + "</h1>");
            out.println("<h2>Thanks for Shopping with us!!</h2>");

            Date todayDate = new Date();
            Date dt=null;
            try{
                SimpleDateFormat sdf=new SimpleDateFormat("yy-mm-dd");
                String s=sdf.format(todayDate);
                dt=sdf.parse(s);
            }
           catch(Exception e){
            e.printStackTrace();
           }
            @SuppressWarnings("null")
            java.sql.Date date=new java.sql.Date(dt.getTime());
            
             int pad = Integer.parseInt(request.getParameter("ProductAmount"));
             int pct = Integer.parseInt(request.getParameter("ProductCount"));
             String pty = request.getParameter("ProductType");
             String cin = request.getParameter("CustomerName");
            try {
                Connection conn = DatabaseConnect.getMyConnection();
                PreparedStatement psmt = conn.prepareStatement("insert into salesinfoproduct (Sales_Id,SaleDateOfPurchase,ProductAmount,ProductCount,ProductType,CustomerName) values(?,?,?,?,?,?)");
                psmt.setString(1, null);
                psmt.setDate(2, date);
                psmt.setInt(3, pad);
                psmt.setInt(4, pct);
                psmt.setString(5, pty);
                psmt.setString(6, cin);
                int num = psmt.executeUpdate();
                if (num > 0) {
                    response.sendRedirect("WelcomeMarket_Page.jsp");
                } else {
                    response.sendRedirect("Billing.jsp");
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
