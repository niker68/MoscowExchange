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
//Сервлет, выдающий сообщения.
@WebServlet(name = "message", value = "/message")
public class MessageUploadSuccess extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Security> list = securityService.findAll();
        req.setAttribute("listSecurity", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/message.jsp");
        requestDispatcher.forward(req, resp);
    }
}
