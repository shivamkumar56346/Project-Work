<%-- 
    Document   : LoginPage
    Created on : Jun 13, 2018, 7:56:52 AM
    Author     : Shivam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="images/Tulips.jpg">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");
        %>
        <p><medium><b>Get Started here!!</b></medium></p>
      <p style="text-align:center"><img src="images/Loginhere.jpg" width="800" height="300"/></p> 
      <div style="background-color:yellowgreen"><hr>        
      <span style="color:blueviolet"><b>Login Here!!</span>
            <form action="LoginUserServlet">
                <br>
                </u>
            <table border="3" width="400" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your UserName:<input type="text" name="UserName"/><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Password:<input type="password" name="UserPass"/><br/></td>
                </tr>
            </table>
            <input type="submit" value="Login"/>
        </form>
      <br><br>
    <div style="text-align:center">&copy; 2018 ShivamKumar</div>
    <hr></div>
    </center>
</body>
</html>
