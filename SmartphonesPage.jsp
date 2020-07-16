<%-- 
    Document   : SmartphonesPage
    Created on : Jun 17, 2018, 7:19:11 PM
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
    <body background="images/system.jpg">
    <center>
        <form action="Billing.jsp">
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>
          <h2 style="color:blue"><b>Shop here at Smartphones Gallery!!</h2>
        <%!
            int catId;
            Connection conn;
        
        %> 
        
        <%
               catId = Integer.parseInt(request.getParameter("catId"));
              // HttpSession sess=request.getSession();
                //sess.setAttribute("CiD",catId);
            try {
                 conn = DatabaseConnect.getMyConnection();
                  PreparedStatement preStmt = conn.prepareStatement("select * from productsinfo where Product_Cat_Id=?");
                    preStmt.setInt(1, catId);
                    ResultSet rsltSet = preStmt.executeQuery();
                        %>
                        <div style="background-color:burlywood"><hr>
                         </u>
                         <table border="3" width='0%'>
                             <thead>
                                     <th>Product_Name</th>
                                     <th>Product_Qty</th>
                                     <th>Product_Price/Qty</th>
                                     <th>Product_Image</th>
                                     <th>Product_Description</th>
                                     <th>Click on Product</th>
                             </thead>          
                             <%   while (rsltSet.next()) {
                                 %>
                           <tbody>
                               <tr>
                                   <td><%=rsltSet.getString(2)%></td>
                                   <td><%=rsltSet.getInt(3)%></td>
                                   <td><%=rsltSet.getInt(4)%></td>
                                   <td><img src="<%=rsltSet.getString(5)%>" width="120" height="80"/></td>
                                   <td><%=rsltSet.getString(6)%></td>
                                   <td><input type="checkbox" name="Product_Price" value="<%=rsltSet.getInt(4)%>"/></td>
                               </tr> 
                           </tbody>
                     <%   }  %>  
                           </table>
                           <input type="submit" value="CheckOut"/>          
                           
                     <%
                         rsltSet.close();
                         preStmt.close();
            } catch (Exception e) {
                e.printStackTrace();
}
        %>
        <hr>  
         </div>    
        </form>               
         <div style="text-align:center">&copy; 2018 ShivamKumar</div>
    </center>  
    </body>
</html>
