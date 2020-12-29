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
import java.util.List;

@WebServlet(name = "home")
public class Home extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Security> list = securityService.findAll();
        req.setAttribute("listSecurity", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
