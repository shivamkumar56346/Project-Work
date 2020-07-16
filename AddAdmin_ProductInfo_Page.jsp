<%-- 
    Document   : AdminProductInfo
    Created on : Jun 14, 2018, 6:07:56 PM
    Author     : Shivam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body background="images/snowday.jpg">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>
     
        <h2 style="color:orangered"><b>Add some more Product Details!!</h2>
  <p style="text-align:center"><img src="images/BasketAdd.png" width="400" height="200"/></p>
          <div style="background-color:lightcoral"><hr>
             <form action="AdminAddProductInfoServlet">
        </u><table border="3" width="450" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your Product Id: <input type="number" name="Product_Id"><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Product Name: <input type="text" name="Product_Name"><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Product Quantity: <input type="number" name="Product_Qty"><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Product Price: <input type="number" name="Product_Price"></td>
                </tr>
                <tr>
                    <td>Please enter your Product Image: <input type="text" name="Product_Image"></td>                                             
                </tr>
                <tr>
                    <td>Please enter your Product Description: <input type="text" name="Product_Desc"></td>
                </tr>
                <tr>
                    <td>Please enter your Product Category Id: <input type="number" name="Product_Cat_Id"></td>
                </tr>
            </table> 
            <input type="submit" value="Submit">
        </form>
             <hr></div>
        <div style="text-align:center">&copy;2018 ShivamKumar</div>
    </center>
    </body>
</html>
