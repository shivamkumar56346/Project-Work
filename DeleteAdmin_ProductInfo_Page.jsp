<%-- 
    Document   : DeleteAdmin_ProductInfo_Page
    Created on : Jun 18, 2018, 1:04:42 PM
    Author     : Shivam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="images/boat.jpg">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>
        <h2 style="color:blue"><b>Delete Product Details!!</h2>
        <p style="text-align:center"><img src="images/BasketRemove.png" width="400" height="250"></p>
         <div style="background-color:lightskyblue"><hr>
        <form action="AdminDeleteProductInfoServlet">
        </u>
            <table border="3" width="500" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your Product Category Id: <input type="number" name="Product_Cat_Id"></td>
                </tr>
            </table> 
            <input type="submit" value="Submit">
        </form>
         <br/><br/><a href="DeleteAdmin_ProductCat_Page.jsp">Click here to delete Product Category!!</a>  
         <br>
         <br>
         <br><br>
          <hr></div>
         <div style="text-align:center">&copy;2018 ShivamKumar</div>
    </center> 
    </body>
</html>
