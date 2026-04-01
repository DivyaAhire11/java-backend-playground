<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Greeting Page</h2>
        <form method="post">
            Enter Name : <input type="text" name="uname" required>
            <input type="submit" value="Submit">
        </form>
        
        <br><br>
        <%
            if(request.getParameter("uname") != null){
                String name = request.getParameter("uname");
                //Get current hour
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                
                String msg;
                if(hour < 12)
                    msg = "Good Morning";
                else if(hour < 18)
                    msg = "Good Afternoon";
                else
                    msg = "Good Evening";
           %> 
           <h3 style="color: blue"><%=  msg %>, <%= name %></h3>
           <p style="color: #1a5ed8;">Timing : </p>
           <p><%=  hour %></p>
           <%
              } 
            %>
    </body>
</html>
