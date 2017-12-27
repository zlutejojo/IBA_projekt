package cz.IBA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  výchozí webová stránka
 *  do parametru x, lze nastavit číslo určující, kolikrát se vypíše uvítací text
 */

@WebServlet("/")
public class ServletIBA extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        Integer x = 1;
        String xReq = request.getParameter("x");

        try {
            if (xReq != null) x = Integer.parseInt(xReq);
        } catch (NumberFormatException ex) {
            x = 1;
        }

        for (int i = 0; i < x; i++) {
            out.println("Hello IBA!"+ "<br/>");
        }
        
        out.println("</body></html>");
    }
}
