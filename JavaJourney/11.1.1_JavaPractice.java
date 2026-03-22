// FILE NAME : SearchServlet.java
/*

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/search")
class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Get customer number from HTML form
        int cno = Integer.parseInt(request.getParameter("cno"));

        try {
            // 2. Load Driver
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Practicals", "postgres",
                    "tybcs");
            String sql = "SELECT * FROM customer WHERE cno=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cno);
            // Execute query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Customer Details</h2>");
                out.println("Customer No : " + rs.getInt("cno") + "<br>");
                out.println("Name : " + rs.getString("cname") + "<br>");
                out.println("Address : " + rs.getString("address") + "<br>");
                out.println("City : " + rs.getString("city") + "<br>");
            } else {
                out.println("<h2 style='color:red;'> Customer Not Found!!!</h2>");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }
    }
}
    
*/