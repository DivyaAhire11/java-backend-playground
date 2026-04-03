<!-- Write a JSP script to accept a String from a user and display it in reverse order -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>String Reverse</title>
    </head>
    <body>
        <h1>Reverse String</h1>
        <form method="post">
            <b> Enter String : </b> <input type="text" name="str" required>
            <input type="submit" value="Reverse">
        </form>
        <br><br>
        
        <%
           if(request.getParameter("str") != null){
               String str = request.getParameter("str");
               String rev = "";
              
               //reverse logic
               for(int i = str.length()-1; i>=0;i--){
                   rev += str.charAt(i);
               }
            %>
            <h3 style="color:blue;">
                Reverse String : <%= rev %>
            </h3>
          <%
           }
        %>
    </body>
</html>
