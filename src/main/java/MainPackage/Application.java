package MainPackage;

import org.xml.sax.SAXException;
import services.DataImport;
import services.ServiceDAO;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException {

        ServiceDAO serviceDAO = new ServiceDAO();

        ArrayList<File> filesOfSecurities = new ArrayList<>();
        filesOfSecurities.add(new File("src/main/resources/securities_1.xml"));
        filesOfSecurities.add(new File("src/main/resources/securities_2.xml"));

        ArrayList<File> filesOfHistories = new ArrayList<>();
        filesOfHistories.add(new File("src/main/resources/history_1.xml"));
        filesOfHistories.add(new File("src/main/resources/history_2.xml"));
        filesOfHistories.add(new File("src/main/resources/history_3.xml"));
        filesOfHistories.add(new File("src/main/resources/history_4.xml"));

        DataImport.AddSecuriritiesInDB(filesOfSecurities);
        DataImport.AddHistoriesInDB(filesOfHistories);

        /*List<Security> listForDeleted= serviceDAO.findAll();
        serviceDAO.delete(listForDeleted);*/




    }
}
