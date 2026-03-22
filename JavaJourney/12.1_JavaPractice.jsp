<!--
  PERFECT NUMBER
  A perfect Number is a number whose : 
       Sum of all its proper divisors = the number itself

  eg: number      Divisor         Sum
       6          1,2,3           6
       28         1,2,4,7,14      28
       496        1,2,4,8,16      496
                  31,62,124,248 
  
-->

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Perfect Number</title>
    </head>
    <body>
        <h2>Check Perfect Number</h2>
        <form method="post" >
            Enter Number : 
            <input type="text" name="num" required>
            <input type="submit" value="Check" >
        </form>
        <br> 
        <%
            //Run Logic only after form submitting
            if (request.getParameter("num") != null) {
                int num = Integer.parseInt(request.getParameter("num"));
                int sum = 0;

                //Find sum of proper divisors
                for (int i = 1; i <= num / 2; i++) {
                    if (num % i == 0) {
                        sum += i;
                    }
                }
                //Check perfect number
                if (sum == num) {
        %>
             <h3 style="color:green;">
                <%= num%> is a Perfect Number
              </h3>
        <% } else { %>

              <h3 style="color:red;">
                 <%= num%> is NOT a perfect Number
              </h3>
        <% } %>
        <% } %>
    </body>
</html>
