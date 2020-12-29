package Servlets;

import models.Security;
import services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//удаление Security и связанных с ней History нажатием кнопки Delete в интерфейсе.
@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathToHome = req.getContextPath() + "/home";
        resp.sendRedirect(pathToHome);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Security security = securityService.findById(id);
        securityService.delete(security);
        String pathToHome = req.getContextPath() + "/home";
        resp.sendRedirect(pathToHome);
    }
}
