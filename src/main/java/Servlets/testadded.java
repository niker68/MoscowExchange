package Servlets;

import org.xml.sax.SAXException;
import services.DataImport;
import services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//для отладки добавляет Security и History для них из тестовых файлов xml, имитирующих файлы, полученные через API Московской биржи.
@WebServlet(name = "testadded", value = "/testadded")
public class testadded extends HttpServlet {
    private SecurityService securityService = new SecurityService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/testdata/");
        List<File> filesOfSecurities = new ArrayList<>();
        filesOfSecurities.add(new File(path+"securities_1.xml"));
        filesOfSecurities.add(new File(path+"securities_2.xml"));

        List<File> filesOfHistories = new ArrayList<>();
        filesOfHistories.add(new File(path+"history_1.xml"));
        filesOfHistories.add(new File(path+"history_2.xml"));
        filesOfHistories.add(new File(path+"history_3.xml"));
        filesOfHistories.add(new File(path+"history_4.xml"));

        try {
            DataImport.AddSecuriritiesInDB(filesOfSecurities);
        } catch (SAXException | ParserConfigurationException | ParseException e) {
            e.printStackTrace();
        }
        try {
            DataImport.AddHistoriesInDB(filesOfHistories);
        } catch (SAXException | ParserConfigurationException | ParseException e) {
            e.printStackTrace();
        }
        /*List<Security> list = securityService.findAll();
        req.setAttribute("listSecurity", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/pages/index.jsp");
        requestDispatcher.forward(req, resp);*/
        String pathToHome = req.getContextPath() + "/home";
        resp.sendRedirect(pathToHome);
    }
}
