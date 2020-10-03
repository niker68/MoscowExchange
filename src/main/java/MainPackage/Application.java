package MainPackage;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("src/main/resources/securities_1.xml");
        ImportXML.importAndPrintSecurities(file);
    }
}
