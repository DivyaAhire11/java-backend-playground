//write a JSP program to calculate sum of first and last digit of a give number.
// Display sum in Red Color with font size 18

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum of Digit</title>
    </head>
    <body>
        <h2>Sum of First and Last Digit</h2>
        <form method="post">
            Enter Number : <input type="text" name="num" required >
            <input type="submit" value="Calculate">
        </form>
        
        <br>
        <%
            if(request.getParameter("num") != null){
                int num = Integer.parseInt(request.getParameter("num"));
                int last = num%10;   //last digit
                
                int first = num;
                while(first >= 10){
                    first = first/10;  //get first digit
                }
                
                int sum = first + last; 
           %>     
           
           <h3 style="color:rgb(255, 0, 0); font-size: 18px; font-weight: 900;"> Sum of First and Last Digit = <%= sum %></h3>
           
           <%  } %>
        </body>
</html>
