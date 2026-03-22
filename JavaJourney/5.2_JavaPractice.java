// FILE NAME : quiz.jsp



// <%@ page import="java.sql.*" %>
// <%
//     //Database connection
//     Class.forName("org.postgresql.Driver");

//     Connection con = DriverManager.getConnection(
//             "jdbc:postgresql://localhost:5432/Practicals",
//             "postgres",
//             "tybcs"
//     );
//     //Session variables
//     Integer score = (Integer) session.getAttribute("score");
//     Integer count = (Integer) session.getAttribute("count");
//     //Session keeps data across multiple page requests for the same user.

//     if (score == null) {
//         score = 0;
//         count = 0;
//     }

//     //check previous answer
//     String selected = request.getParameter("answer");
//     String correct = request.getParameter("correct");
//     //Gets the user’s selected answer (answer) and the correct answer (correct) from the form submission

//     if (selected != null && correct != null) {
//         if (selected.equals(correct)) { // Checks if the user selected an answer
//             score++; // If the answer matches the correct one, increment score
//         }
//         count++;  // Increment count (number of questions attempted)
//     }
   
   
//     //Saves updated score and count back to the session so the next request can access them
//     session.setAttribute("score", score);
//     session.setAttribute("count", count);

//     if (count >= 3) {
//         response.sendRedirect("result.jsp");
//         return;  //return ensures the rest of the page does not execute after redirect
//     }

//     //random question
//     Statement st = con.createStatement();
//     ResultSet rs = st.executeQuery(
//         "SELECT * FROM questions ORDER BY RANDOM() LIMIT 1"
//     );
// //    rs.next();

//     if (!rs.next()) {
//         out.println("No questions found!");
//         return;
//     }
// %>
// <!DOCTYPE html>
// <html>
//     <head>
//         <title>Online MCQ Test</title>
//     </head>
//     <body>
//         <h2>Online <%= (count + 1)%></h2> <!-- display the question number(count start at 0 , so +1) -->
//         <form action="quiz.jsp" method="post">
//             <b><%=  rs.getString("question")%></b><br><br>
//             <input type="radio" name="answer" value="1" required>
//             <%=  rs.getString("option1")%><br>

//             <input type="radio" name="answer" value="2" >
//             <%=  rs.getString("option2")%><br>

//             <input type="radio" name="answer" value="3" >
//             <%=  rs.getString("option3")%><br>

//             <input type="radio" name="answer" value="4" >
//             <%=  rs.getString("option4")%><br>

//             <input type="hidden" name="correct" value="<%=   rs.getInt("ans")%>" ><br>
//             <!-- hidden field storing the correct answer so the next submission can check it -->

//             <% if (count < 3) { %>
//             <input type="submit" value="Next Question">
//             <% } else { %>
//             <input type="submit" formaction="result.jsp" value="Finish">
//             <% }%>

//         </form>
//             <p>Score : <%= score%></p>  <!-- Displays the current score so the user can see progress -->
//     </body>
// </html>
