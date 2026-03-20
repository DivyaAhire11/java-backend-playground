/* JSP Prime Number Check

<%@page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prime Number Check</title>
    </head>
    <body>
        <h2>Check Prime Number</h2>
        <form method="post">
            Enter a Number : <input type="text" name="num" />
            <input type="submit" value="Check" />
        </form>
        <%
            String numStr = request.getParameter("num");
            if(numStr != null){
                int num = Integer.parseInt(numStr);
                boolean isPrime = true;
                
                if(num <= 1){
                    isPrime = false;
                }else{
                    for(int i=2; i <= num/2;i++){
                        if(num %i == 0){
                            isPrime = false;
                            break;
                        }
                    }
                }
            
         %>
         <p style="color:red"; ">
             <%
                if(isPrime){
                    out.println(num +" is a Prime Number.");
                }else{
                    out.println(num + " is NOT a Prime Number.");
                }    
             %>
         </p>
         <%
             }
          %>
        </form>
    </body>
</html>


*/