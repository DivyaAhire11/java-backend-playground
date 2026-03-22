/*
   write a SERVLET program which counts how many times a user has visited a web page
   if user is visiting the page for the first time, display a welcome message
   if the user is revisiting the page , display the number of times visited(Use Cookie)
*/
/*
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/visit"})
class VisitCounter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
           int count =0;
           boolean found = false;
           
           Cookie[] cookies = request.getCookies();
           if(cookies != null){
               for(Cookie c : cookies){
                   if(c.getName().equals("visitCount")){
                       count = Integer.parseInt(c.getValue());
                       count++;
                       found = true;
                   }
               }
           }
          
          if(!found){
              count = 1;
              out.println("<h2>Welcome! First Visit</h2>");
              
          }else{
              out.println("<h2>You visited "+ count + " times </h2>");
          }
          Cookie cc = new Cookie("visitCount" , String.valueOf(count));
          //set cookie expiry (optional : 1day)
          cc.setMaxAge(24*60*60);
          response.addCookie(cc);
          
    }

}
 */