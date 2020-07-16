<%-- 
    Document   : Purchase
    Created on : Jun 27, 2018, 5:57:29 PM
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
            ServletContext ctx = getServletContext();
            String greet = ctx.getInitParameter("greetings");
            out.println("<h1><u>" + greet + "</h1>");
        %>

        <%!
            String pay;
            String name;
        %>

        <%
            try {
                HttpSession ses = request.getSession();
                pay = ses.getAttribute("Amt").toString();
                HttpSession se=request.getSession();
                name=se.getAttribute("userN").toString();
            
            //    pid=request.getParameter("Product_Name");
              //  HttpSession obj=request.getSession();
                // pid=obj.getAttribute("CiD").toString();
                //out.println("Value is  = " + pay);

               // System.out.println("Value is  = " + pay);

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        <h2 style="color:orangered"><b>Here is your Purchase Details!!</h2>
    <p style="text-align:center"><img src="images/purchasing.jpg" width="600" height="200"/></p>
      <div style="background-color:orchid"><hr>    
    <form action="SuccessBillingServlet"></u>
            <table border="3" width="400" cellspacing="2" cellpadding="2">
                <tbody>

                    <tr>
                        <td>Please enter product amount:<input type="text" readonly value="<%=pay%>" name="ProductAmount"/></td>
                    </tr>
                    <tr>
                        <td>Please enter product quantity:<input type="text" readonly value="1" name="ProductCount"/></td>
                    </tr>
                    <tr>
                        <td>Please enter product name:<input type="text" name="ProductType"/></td>
                    </tr>
                    <tr>
                        <td>Please enter customer name:<input type="text" readonly value="<%=name%>" name="CustomerName"/></td>
                    </tr>
                </tbody>
            </table>
                    <input type="submit" value="Submit">
        </form>
                 <hr></div><br><br>
                    <div style="text-align:center">&copy;2018 ShivamKumar</div>
            </center>
</body>
</html>
