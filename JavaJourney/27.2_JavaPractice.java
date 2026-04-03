/*
   write a SERVLET program to change inactive time intervals of session
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ControlSession"})
class ControlSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Get Session
        HttpSession session = request.getSession();

        // Set inactive interval(in seconds)
        // After this time -> session expires automatically
        session.setMaxInactiveInterval(60);  //60sec = 1min

        //store attribute
        session.setAttribute("user", "Student");

        out.println("<h2>Session Timeout Set to 1 Minute</h2>");

        //show session details
        out.println("<p>Session ID : " + session.getId() + "</p>");
        out.println("<p>Is New Session : " + session.isNew() + "</p>");
        out.println("<p>User : " + session.getAttribute("user") + "</p>");
 
     
    }

}
