<!--
    MAIN TAGS
      -> <%@  %>  : page directive's
      -> <%   %>  : Java Code(Scriplet)
      -> <%=  %>  : print value on browser
      
    Q. Which tag prints value in JSP?
     -> <%= %>
     
    Q. JSP is converted into?
     ->servlet(by server automatically)
     
    Q. Where JSP runs?
     -> server side
    -->

    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Patient Details</title>
        </head>

        <body>
            <h2 align="center">Patient Details</h2>
            <% //Patient information // int pno=101; // String name="Rahul Sharma" ; // String address="Mumbai" ; // int
                age=35; // String disease="Fever" ; String patients[][]={ { "101" , "Rahul " , "Mumbai" , "35" ,"Fever"
                }, { "102" , "Anita " , "Pune" , "28" ,"Cold" }, { "103" , "Amit " , "Delhi" , "40" ,"Diabetes" },
                { "104" , "Riya " , "Nashik" , "35" ,"Headeche" } }; %>
                <table border="1" align="center" style="border-collapse: collapse; " cellpadding="10">
                    <tr>
                        <th>NO</th>
                        <th>NAME</th>
                        <th>ADDRESS</th>
                        <th>AGE</th>
                        <th>DISASE</th>
                    </tr>
                    <% for(int i=0;i<patients.length;i++){ %>
                        <tr>
                            <td>
                                <%= patients[i][0]%>
                            </td>
                            <td>
                                <%= patients[i][1]%>
                            </td>
                            <td>
                                <%= patients[i][2]%>
                            </td>
                            <td>
                                <%= patients[i][3]%>
                            </td>
                            <td>
                                <%= patients[i][4]%>
                            </td>
                        </tr>
                        <% } %>
                </table>
        </body>

        </html>

        <!-- 
        OUTPUT:

               Patient Details
               
      NO	NAME	ADDRESS	AGE	DISASE
      101	Rahul	Mumbai	35	Fever
      102	Anita	Pune	28	Cold
      103	Amit	Delhi	40	Diabetes
      104	Riya	Nashik	35	Headeche
        
        -->