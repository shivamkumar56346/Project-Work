<%-- 
    Document   : ErrorPage
    Created on : Jun 13, 2018, 8:54:35 AM
    Author     : Shivam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightgreen">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>
       
        <span style="color:blueviolet"><b>You are on ErrorPage!!</span><br/><br/>
        <div style="background-color:lightpink"><hr>
            <p style="text-align:center"><img src="images/shivamcar.png" width="400" height="200"/></p>
        <a href="LoginPage.jsp">Click here to go to Login Credentials</a><br/>
        <hr></div>
        <br><br>
        <div style="text-align:center">&copy;2018 ShivamKumar</div>
    </center>
    </body>
</html>
