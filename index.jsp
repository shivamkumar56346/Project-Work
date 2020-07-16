<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!--<body bgcolor="orchid"> -->
    <body background="images/scenario.jpg">
    <center>
        <%
            ServletContext ctx = getServletContext();
            String greet = ctx.getInitParameter("greetings");
            out.println("<h1><u>" + greet + "</h1>");
        %>
        <p><medium><b>Get Started here!!</b></medium></p>
        <p style="text-align:center"><img src="images/welcome.png" width="600" height="300"/></p>        
        <div style="background-color:orange"><hr> 
        <span style="color:blueviolet"><b>Welcome to your Shopping Market!!</span>
        <br>   
        <br>
        <br>
        <a href="RegisterPage.jsp">Click here for Register!!</a><br/><br/>
        <br>       
        <a href="LoginPage.jsp">Click here for Login!!</a><br/><br/><br>
    <div style="text-align:center">&copy; 2018 ShivamKumar</div>
    <hr></div>
</center>
</body>
</html>
