<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voter Eligibility Check</title>
        <style>
            body{
                height: 100vh;
                width : 100vw;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
            }
            form{
                height: 200px;
                width: 250px;
                border-radius: 16px;
                box-shadow: 10px 10px 20px gray;
                padding: 2rem;
                gap: 30px;
                margin: 30px;
            }
            button{
                background-color: black;
                padding: 1rem 2rem;
                font-weight: 700;
                color: white;
                border-radius: 9rem;
            }
        </style>
    </head>
    <body>
        <form method="post" >
            <b>Name : </b> <input type="text" name="name" required><br><br>     
            <b>Age : </b> <input type="text" name="age" required><br><br>
            <button type="submit">Check</button>
        </form>
        <br>
        
        <% 
           if(request.getParameter("name") != null){
               String name = request.getParameter("name");
               int age = Integer.parseInt(request.getParameter("age"));
               
               if(age >= 18){
         %>
         
         <h3 style="color:green;"><%= name  %> is Eligible for Voting</h3>
         <%
             }else{   
          %>
          <h3 style="color: red;"><%= name %> is NOT Eligible for Voting</h3>
         <%
               }
           }
        
        %>
    </body>
</html>
