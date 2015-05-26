<%-- 
    Document   : index
    Created on : Oct 6, 2012, 7:08:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        
        <h1>Welcome</h1>
        <span><a href="Login.jsp">Login</a></span><span>&nbsp;&nbsp;<a href="logout">Logout</a></span>
            <form  method="post" action="NameServlet">
            Enter Your Name: <input type="text" name="name">
            <input type="submit" value="OK">
     </form>
           
    </body>
</html>