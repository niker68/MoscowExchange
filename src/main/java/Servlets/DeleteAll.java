package Servlets;

import services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//очистка базы для отладки
@WebServlet(name = "deleteall", value = "/deleteall")
public class DeleteAll extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        securityService.DeleteAllSecuritiesFromDB();
        String pathToHome = req.getContextPath() + "/home";
        resp.sendRedirect(pathToHome);
    }
}
