package Servlets;

import org.xml.sax.SAXException;
import services.DataImport;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

//Загружает файлы пользователя и добавляет Security Из них в БД.
@WebServlet(name = "uploadsecurities", value = "/uploadsecurities")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class UploadSecurities extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFilesSecurities";

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }

        String pathSecurities = getServletContext().getRealPath("/uploadFilesSecurities/");
        File dirSecurities = new File(pathSecurities); //path указывает на директорию
        File[] arrFilesOfSecurities = dirSecurities.listFiles();
        List<File> filesOfSecurities = Arrays.asList(arrFilesOfSecurities);

        try {
            DataImport.AddSecuriritiesInDB(filesOfSecurities);
        } catch (SAXException | ParserConfigurationException | ParseException e) {
            e.printStackTrace();
        }

        for (File myFile : new File(pathSecurities).listFiles()){
            myFile.delete();
        }


        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(
                request, response);
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}