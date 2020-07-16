<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="images/lily.jpg">
    <center>
          <%
           ServletContext ctx=getServletContext();
           String greet=ctx.getInitParameter("greetings");
           out.println("<h1><u>"+greet+"</h1>");   
        %>
        <p><medium><b>Get Started here!!</medium></p>
            <p style="text-align:center"><img src="images/register&login.png" width="500" height="250"/></p> 
            <div style="background-color:lightpink"><hr>
            <form action="RegisteredUserServlet">
             </u> <table border="3" width="400" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Please enter your UserName:<input type="text" name="UserName"/><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Password:<input type="password" name="UserPass"/><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Contact:<input type="number" name="UserContact"/><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Email:<input type="email" name="UserEmail"/><br/></td>
                </tr>
                <tr>
                    <td>Please enter your Address:<input type="text" name="UserAddress"/><br/></td>
                </tr>
            </table>
              <input type="submit" value="Register"/>
            </form><br><br>
            <div style="text-align:center">&copy; 2018 ShivamKumar</div>
    <hr></div>
    </center>
</body>
</html>
