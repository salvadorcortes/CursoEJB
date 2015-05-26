<%-- 
    Document   : Login
    Created on : Oct 6, 2012, 8:54:42 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Security Web App login page</title>
  </head>
  <body bgcolor="#cccccc"> 
  <blockquote>
  
  <h2>Please enter your user name and password:</h2>
  <p>
  <form method="POST" action="LoginServlet">
  <table border=1>
    <tr>
      <td>Username:</td>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td colspan=2 align=right><input type=submit
                                     value="Submit"></td>
    </tr>
  </table>
  </form>
  </blockquote>
  </body>
</html>