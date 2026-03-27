import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/login"})
 class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();

         String user = request.getParameter("username");
         String pass = request.getParameter("password");
         String dob = request.getParameter("DOB");
         
//         1. Input Validation
            if(user == null || pass == null || user.isEmpty() || pass.isEmpty()){
                out.println("<h3 style='color:red;'>Please Enter All Fields</h3>");
                return;
            }
         try{
             Class.forName("org.postgresql.Driver");
             
             Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals","postgres","tybcs");
             
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users where username=? AND password=?");
             ps.setString(1, user);
             ps.setString(2, pass);
            
             
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
                 out.println("<h2 style='color:green;' >Welcome "+ user +"!"+"</h2>");
             }else{
                 out.println("<h2 style='color:red;'>Invalid Username or Password</h2>");
             }
             
             con.close();
             ps.close();
             rs.close();
             
         }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
         }
        
    }
}
