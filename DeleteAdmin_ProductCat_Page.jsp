<%-- 
    Document   : DeleteAdmin_ProductCat_Page
    Created on : Jun 18, 2018, 1:03:57 PM
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
        
        <h2 style="color:blueviolet"><b>Delete your Product Here!!</h2>
        
         <p style="text-align:center"><img src="images/BagRemove.png" width="600" height="300"/></p>
        <div style="background-color:goldenrod"><hr>     
         <form action="AdminDeleteProductServlet">
         </u>
            <table border="3" width="450" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your Product Category ID:<input type="number" name="Category_Id"/><br/></td>
                </tr>
                   </table>
                <input type="submit" value="Submit"/>
         </form>
            <br><br><br>
             <hr></div>
         <br>
        <div style="text-align:center">&copy;2018 ShivamKumar</div>
        </center>
    </body>
</html>
