package main.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// oi
@WebServlet( urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h2>Oi mundo! Você escreveu o primeiro servlet!</h2>");
        writer.println("</body>");
        writer.println("</html>");

        System.out.println("O servlet OiMundoServlet foi chamado.");

    }
}
