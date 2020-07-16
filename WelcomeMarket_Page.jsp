<%-- 
    Document   : WelcomeMarket_Page
    Created on : Jun 19, 2018, 3:58:39 PM
    Author     : Shivam
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.db.DatabaseConnect"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body background="images/Lighthouse.jpg"> 
    <center>
           <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
          out.println("<h1><u>"+greet+"</h1>");
           %>
           <p><b></p>
       <h2 style="color:orangered"<b>Welcome to your Shopping Market!!</h2>
        <p style="text-align:center"><img src="images/shoppingmarket.png" width="500" height="200"/></p>
        <div style="background-color:sandybrown">  
        <%!
            Connection conn;

        %>

        <%
            try {
                conn = DatabaseConnect.getMyConnection();
                PreparedStatement preStmt = conn.prepareStatement("select * from productcategory");
                ResultSet rsltSet = preStmt.executeQuery();
        %> 
    </u>
    <table border='3' width='500' cellpadding='2' cellspacing='10'>
                <thead>
                <th>Click here on the below links</th><br/>
                </thead>
                <%   while (rsltSet.next()) {
                %>
                <tbody>
                    <tr>
                        <%
                            String query = rsltSet.getString(2)+"Page.jsp?catId="+rsltSet.getInt(1);
                        %>
                        <td><center><a href="<%=(query)%>">For Purchase of "<%=rsltSet.getString(2)%>"</a></center></td>
                </tr>
                </tbody>
                <%   }
                    rsltSet.close();
                    preStmt.close();
                %>
            </table>
           
        <%
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception =" + e);
            }
        %>
        <br>
        <a href="LoginPage.jsp">Click to Logout!</a>   
        <div style="text-align:center"><br>&copy; 2018 ShivamKumar</div>
              <hr></div> 
</center>
</body>
</html>
