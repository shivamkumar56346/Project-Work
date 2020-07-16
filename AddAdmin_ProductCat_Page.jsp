<%-- 
    Document   : AdminAddProduct
    Created on : Jun 14, 2018, 3:46:20 PM
    Author     : Shivam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body background="images/sunrise.jpg">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>

        <h2 style="color:blue"><b>Add your Product Here!!</h2>
 <p style="text-align:center"><img src="images/Additem.png" width="500" height="250"/></p>
           <div style="background-color:burlywood"><hr>
         <form action="AdminAddProductServlet">
         </u><table border="3" width="500" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your Product Category ID:<input type="number" name="Category_Id"/><br/></td>
                </tr>
                <tr>
                     <td>Please enter your Product Category Name:<input type="text" name="Category_Name"/><br/></td>
                </tr>
                   </table>
                <input type="submit" value="Submit"/>
         </form>
     <br/><br/> 
        <a href="AddAdmin_ProductInfo_Page.jsp">Click here to add details of Product in Product_Category!!</a> 
        <br><br><br>
         <hr> </div>
          <div style="text-align:center">&copy;2018 ShivamKumar</div>
    </center>
    </body>
</html>
