package com.MyPackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Shivam
 */
public class SuccessServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuccessServlet</title>");            
            out.println("</head>");
            out.println("<body background='images/welcome.png'>");
            out.println("<center>");
            out.println("<h1><u>"+greet+"</h1>");
            out.println("<h2 style='color:orangered'><b>Welcome to My Market!!</h2>");
            out.println("<br/><img src='images/ShivamScooty.jpg' width='500' height='250'><br/><br/><br/>");
             out.println("<div style='background-color:orange'><hr>");
            out.println("</u><table border='3' width='300' cellspacing='2' cellpadding='2'>");
            out.println("<thead>");
            out.println("<th>Click here on the below links</th>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr><td><a href='AddAdmin_ProductCat_Page.jsp'>Click here to AddProducts</a><br/></td></tr>");
            out.println("<tr><td><a href='AdminDisplayProductServlet'>Click here to DisplayProducts</a><br/></td></tr>");
            out.println("<tr><td><a href='DeleteAdmin_ProductInfo_Page.jsp'>Click here to DeleteProducts</a><br/></td></tr>");
            out.println("<tr><td><a href='AdminUpdateProduct_Page.jsp'>Click here to UpdateProducts</a><br/></td></tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("<br>");
            out.println("<a href='LoginPage.jsp'>Click to LogOut!</a>");
             out.println("<hr></div>");
            out.println("<div style='text-align:center'>&copy;2018 ShivamKumar</div>");
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
