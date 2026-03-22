// FILE NAME : customer.html
/*

 <!--
        HTML Form
          |   (customer number)
        Servlet(search logic)
          |
        Database(customer table)
          |
        Result shown in browse
 -->
*/
/* 
 <!-- 
          Design HTML page which passes customer number to a search servlet. 
          The Servlet searches for the customer number in a database(customer table)
          and return customer details 
          if not found ow error msg 
 -->
*/
/*
     <!DOCTYPE html>  
     <html>
         <head>
             <title>Customer Number</title>
             <meta charset="UTF-8">
             <meta name="viewport" content="width=device-width, initial-scale=1.0">
         </head>
         <body>
             <h2>Search Customer</h2>
             <form action="search" method="post">
                Enter Customer Number :
                <input type="text" name="cno"><br><br>
                <input type="submit" value="Search">
             </form>
         </body>
     </html>

     */