/*
   Write a SERVLET program in java to accept details of student(SeatNo, Stud_Name, Class , Total_Marks).
   Calculate percentage and grade obtained and display on page
*/

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/StudentServlet"})
class StudentServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
           //Get the data from the form
        int seatNo = Integer.parseInt(request.getParameter("seatno"));
        String name = request.getParameter("name");
        String sclass = request.getParameter("class");
        int total = Integer.parseInt(request.getParameter("marks"));
        
        //Calculate percentage(assuming out of 500)
        double percentage = total / 5.0;
        
        //Calculate grade
        String grade;
        if(percentage >= 75)
            grade = "Distinction";
        else if(percentage >= 60)
            grade = "First Class";
        else if(percentage >= 50)
            grade = "Second Class";
        else if(percentage >= 40)
            grade = "Pass";
        else
            grade = "Fail";
        
        //Display result
        out.println("<h2>Student DETAILS</h2>");
        out.print("Seat No : "+seatNo +" <br>");
        out.println("Name : "+name+" <br>");
        out.println("Class : "+sclass +"<br>");
        out.println("Total Marks :"+ total+"<br>");
        out.println("Percentage :"+percentage+"%<br>");
        out.println("Grade :"+grade);
        
        
    }

}
