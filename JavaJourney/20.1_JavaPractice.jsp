<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number to Word</title>
    </head>
    <body>
        <h2>Number to Words</h2>
        <form method="post">
            Enter Number :  <input type="text" name="num" required>
            <input type="submit" value="Convert">
                    
        </form>
        <br>
       <%
          if(request.getParameter("num")  != null){
              String num = request.getParameter("num");
              String words = "";
              
              for(int i=0;i<num.length(); i++){
                  char ch = num.charAt(i);
                  
                  switch(ch){
                      case '0' : words += " Zero";
                                 break;
                      case '1' : words += " One ";
                                 break;
                      case '2' : words += " Two ";
                                 break;
                      case '3' : words += " Three ";
                                 break;
                      case '4' : words += " Four ";
                                 break;
                      case '5' : words += " Five ";
                                 break;
                      case '6' : words += " Six ";
                                 break;
                      case '7' : words += " Seven ";
                                 break;
                      case '8' : words += " Eight ";
                                 break;
                      case '9' : words += " Nine ";
                                 break;
                  }
              }
              %>
              <h3 style="color:green;">
                  <%= words %>
                  <br>
              </h3>
              
              
          <%
              }
          %>
    
    
    </body>
</html>
