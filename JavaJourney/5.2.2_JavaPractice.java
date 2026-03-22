//   FILE NAME : result.jsp


// <%@page contentType="text/html" pageEncoding="UTF-8"%>  <!-- Sets the content type and character encoding for proper HTML display -->
// <%
//     Integer score = (Integer)session.getAttribute("score");
// %>
// <!DOCTYPE html>
// <html>
// <head>
//     <meta charset="UTF-8">
//     <title>Test Complete</title>

//     <style>
//         body {
//             margin: 0;
//             height: 100vh;
//             display: flex;
//             justify-content: center;
//             align-items: center;
//             background: linear-gradient(135deg, #667eea, #764ba2);
//             font-family: Arial, sans-serif;
//         }

//         .card {
//             background: white;
//             padding: 40px;
//             border-radius: 15px;
//             text-align: center;
//             box-shadow: 0 10px 25px rgba(0,0,0,0.2);
//             width: 300px;
//         }

//         h2 {
//             margin-bottom: 20px;
//             color: #333;
//         }

//         .score-box {
//             background: #6a11cb;
//             background: linear-gradient(to right, #2575fc, #6a11cb);
//             color: white;
//             padding: 20px;
//             border-radius: 10px;
//             font-size: 22px;
//             font-weight: bold;
//             margin-top: 15px;
//         }

//         .btn {
//             margin-top: 25px;
//             padding: 10px 20px;
//             border: none;
//             background: #2575fc;
//             color: white;
//             border-radius: 8px;
//             cursor: pointer;
//             font-size: 16px;
//         }

//         .btn:hover {
//             background: #1a5ed8;
//         }
//     </style>
// </head>

// <body>

// <div class="card">
//     <h2>🎉 Test Completed!</h2>

//     <div class="score-box">
//         Your Score: <%= score %>
//     </div>

//     <form action="quiz.jsp">
//         <button class="btn">Try Again</button>
//     </form>
// </div>

// </body>
// </html>
