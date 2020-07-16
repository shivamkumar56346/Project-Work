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
import javax.servlet.http.HttpSession;
/**
 *
 * @author Shivam
 */
public class BillingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext ctx = getServletContext();
        String greet = ctx.getInitParameter("greetings");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BillingServlet</title>");
            out.println("</head>");
            out.println("<body bgcolor='00FF00'>");
            out.println("<h1>" + greet + "</h1>");
            out.println("<h2>Get your Billing Here!!</h2>");

            Date todayDate = new Date();
            Date dt = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                String strDate = sdf.format(todayDate);
                dt = sdf.parse(strDate);
            } catch (Exception e) {
                System.out.println(e);
            }
            java.sql.Date dt1 = new java.sql.Date(dt.getTime());
            String tty = request.getParameter("Transaction_Type");
            String tcd = request.getParameter("Transaction_CardDetails");
            int tp = Integer.parseInt(request.getParameter("Transaction_Payment"));
            HttpSession session = request.getSession();
            session.setAttribute("Amt",tp);
            try {
                Connection conn = DatabaseConnect.getMyConnection();
                PreparedStatement psmt = conn.prepareStatement("insert into bankingtransaction (Transaction_Id,Transaction_Date,Transaction_Type,Transaction_CardDetails,Transaction_Payment) values(?,?,?,?,?)");
                psmt.setString(1, null);
                psmt.setDate(2, dt1);
                psmt.setString(3, tty);
                psmt.setString(4, tcd);
                psmt.setInt(5, tp);
                int num = psmt.executeUpdate();
                if (num > 0) {
                    out.println("<h2>thanks for shopping with us!!</h2>");
                    response.sendRedirect("Purchase.jsp");
                } else {
                    out.println("<h2>First complete your Shopping!!</h2>");
                    response.sendRedirect("WelcomeMarketPage.jsp");
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
