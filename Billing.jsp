<%-- 
    Document   : Billing
    Created on : Jun 27, 2018, 4:45:29 PM
    Author     : Shivam
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.DatabaseConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="images/sunrise.jpg">
    <center>

        <%            ServletContext ctx = getServletContext();
            String greet = ctx.getInitParameter("greetings");
            out.println("<h1><u>" + greet + "</h1>");
        %>

        <%!
            int pp;
        %>
        <%
            pp = Integer.parseInt(request.getParameter("Product_Price"));
        %>

        <h2 style="color:orangered"><b>Choose your CheckOut Here!!</h2>
   <p style="text-align:center"><img src="images/billing.png" width="300" height="300"/></p>
    <div style="background-color:aquamarine"><hr>     
   <form action="BillingServlet">
            </u>
            <table border="3" width="400" cellspacing="2" cellpadding="2">
                <tbody>
                    <tr>
                        <td>Please enter Transaction type: <select name="Transaction_Type">
                                <option value="UNKNOWN">Select...</option>
                                <option value="CreditCardPayment">Credit Card</option>
                                <option value="DebitCardPayment">Debit Card</option>
                                <option value="CashPayment">Cash On Delivery</option>
                             </select>  
                          </td> 
                    </tr> 
                    <tr>
                        <td>Please enter Card Number:<input type="text" name="Transaction_CardDetails"/></td>
                    </tr>
                    <tr>
                        <td>Please enter Payment Amount:<input type="text" readonly value="<%=pp%>" name="Transaction_Payment"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit"/>
        </form>
                    <br>
                    <div style="text-align:center">&copy;2018 ShivamKumar</div>
     <hr></div>
    </center>
</body>
</html>
