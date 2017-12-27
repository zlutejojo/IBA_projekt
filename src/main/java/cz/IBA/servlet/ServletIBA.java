package cz.IBA.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  výchozí webová stránka
 *  do parametru x, lze nastavit číslo určující, kolikrát se vypíše uvítací text
 *  pokud uživatel nezadá číslo, uvítací text se vypíše 1x
 */

@WebServlet("/")
public class ServletIBA extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer x = 1;
        String xReq = request.getParameter("x");

        try {
            if (xReq != null) x = Integer.parseInt(xReq);
        } catch (NumberFormatException ex) {
            x = 1;
        }

        request.setAttribute("paramX", x);
        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }
}
