<%-- 
    Document   : AdminUpdateProduct_Page
    Created on : Jun 20, 2018, 5:43:32 PM
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
        <h2 style="color:orange"><b>Update your Product here!!</h2>
        <p style="text-align:center"><img src="images/Update.png" width="500" height="250"/></p>
          <div style="background-color:salmon"><hr>
        <form action="AdminUpdateProductServlet">
        </u> <table border="3" width="400" cellpadding="2" cellspacing="2">
                <tbody>
                    <tr>
                        <td>Please enter Product CatId:<input type="number" name="Product_Cat_Id"/><br/></td>
                    </tr>
                    <tr>
                        <td>Please enter Product Id:<input type="number" name="Product_Id"/><br/></td>
                    </tr>
                    <tr>
                        <td>Please enter Product Qty:<input type="number" name="Product_Qty"/><br/></td>
                    </tr>
                    <tr>
                        <td>Please enter Product Price:<input type="number" name="Product_Price"/><br/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit"/>
        </form><br>
     <hr></div>
        <br>
        <div style="text-align:center">&copy;2018 ShivamKumar</div>
    </center>
</body>
</html>
