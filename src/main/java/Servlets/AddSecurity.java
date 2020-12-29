package Servlets;

import models.Security;
import services.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//добавление Security вручную
@WebServlet(name = "addsecurity")
public class AddSecurity extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/addsecurity.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        String secid = req.getParameter("Secid");
        String shortName = req.getParameter("Short Name");
        String name = req.getParameter("Name");
        Security security = new Security(id,secid,shortName,name);
        securityService.saveOrUpdate(security);
        req.setAttribute("message", "Security has been added successfully!");
        getServletContext().getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(
                req, resp);
    }
}
