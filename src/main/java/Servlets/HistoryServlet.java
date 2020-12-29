package Servlets;

import models.History;
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

//сервлет, обрабатывающий ссылку на историю операций по ценной бумаге. Кнопка Open history.
@WebServlet(name = "history")
public class HistoryServlet extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Security security = securityService.findById(id);
        List <History> list = security.getHistory();
        req.setAttribute("listHistory", list);
        req.setAttribute("security",security);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/history.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
