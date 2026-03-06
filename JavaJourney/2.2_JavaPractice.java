import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
   servlet that provide info about HTTP request from client
   such as IP-Address and browser type
   the servlet also provides info about the server on which the servlet is running, such as OS type
   and the names of currently loaded servlets

CLIENT INFO
   - IP address
   - Browser type
SERVER INFO
   - OS
   - server name
   - loaded servlet(via ServletContext attribute)
*/
@WebServlet(urlPatterns = { "/MyServlet" })
class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>HTTP Request Information</h2>");

        // -----CLIENT INFORMATION------
        String ipAddress = request.getRemoteAddr();
        out.println("<b>Client IP Address : </b>" + ipAddress + " <br>");

        // ------BROWSER TYPE(USER AGENT HEADER)------
        String browser = request.getHeader("User-Agent");
        out.println("<b>Browser Type : </b>" + browser + " <br>");
        out.println("<hr>");

        // ------SERVER INFORMATION-------
        out.println("<h2>Server Information</h2>");

        // operating system
        String os = System.getProperty("os.name");
        out.println("<b>Operating System : </b>" + os + " <br>");

        // server name
        String serverName = request.getServerName();
        out.println("<b>Server Name : </b>" + serverName + " <br>");

        out.println("<hr>");

        out.println("<h2>Loaded Servlet</h2>");
        // Servlet context
        ServletContext context = getServletContext();
        java.util.Enumeration<String> names = context.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            out.println("<b>Servlet Attribute :</b> " + name + "<br>");
        }
        out.println("</body>");
        out.println("</html>");

    }

}
