<!-- 
   Write JSP script to accept username and password from user , if they are same ten display 
   "Login Successfully" message in Login.html file ow display "Login Failed" message in Error.html file
-->
   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login and SignUp</h1>
        <form method="post">
            <b>Username: </b>
            <input type="text" name="user" > <br><br>
            
            <b>Password :  </b>
            <input type="password" name="pass" > <br><br>
            
            <input type="submit" name="Login" >
        </form>
        <% 
          if(request.getParameter("user") != null){

             String u = request.getParameter("user");
             String p = request.getParameter("pass");
             
             if(u.equals(p)){
                 response.sendRedirect("success.html");
             }else{
                 response.sendRedirect("error.html");
             }
             
          }
        %>
    </body>
</html>
