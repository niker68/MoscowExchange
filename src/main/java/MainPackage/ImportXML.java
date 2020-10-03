package MainPackage;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImportXML {


    public static ArrayList<Security> importXMLSecurities(File file) throws IOException, SAXException, ParserConfigurationException {
        ArrayList <Security> securities = new ArrayList();
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(file);

        // Получение списка всех элементов employee внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList securityElements = document.getDocumentElement().getElementsByTagName("row");

        for (int i = 0; i < securityElements.getLength(); i++) {
        Node security = securityElements.item(i);

        // Получение атрибутов каждого элемента
        NamedNodeMap attributes = security.getAttributes();

        // Добавление сотрудника. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
        Security securitynew = new Security();
        securitynew.setSecid(attributes.getNamedItem("secid").getNodeValue());
        securitynew.setShortname(attributes.getNamedItem("shortname").getNodeValue());
        securitynew.setRegnumber(attributes.getNamedItem("regnumber").getNodeValue());
        securitynew.setName(attributes.getNamedItem("name").getNodeValue());
        securitynew.setIsin(attributes.getNamedItem("isin").getNodeValue());
        securitynew.setEmitent_title(attributes.getNamedItem("emitent_title").getNodeValue());
        securitynew.setEmitent_inn(attributes.getNamedItem("emitent_inn").getNodeValue());
        securitynew.setEmitent_okpo(attributes.getNamedItem("emitent_okpo").getNodeValue());
        securitynew.setGosreg(attributes.getNamedItem("gosreg").getNodeValue());
        securitynew.setType(attributes.getNamedItem("type").getNodeValue());
        securitynew.setGroup(attributes.getNamedItem("group").getNodeValue());
        securitynew.setPrimary_boardid(attributes.getNamedItem("primary_boardid").getNodeValue());
        securitynew.setMarketprice_boardid(attributes.getNamedItem("marketprice_boardid").getNodeValue());
        if (!attributes.getNamedItem("id").getNodeValue().isEmpty()){
            securitynew.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));}
        if (!attributes.getNamedItem("emitent_id").getNodeValue().isEmpty()){
            securitynew.setEmitent_id(Integer.parseInt(attributes.getNamedItem("emitent_id").getNodeValue()));}

        securities.add(securitynew);
        }
        return securities;
    }
    public static void importAndPrintSecurities(File file) throws ParserConfigurationException, SAXException, IOException {
            ArrayList <Security>list = importXMLSecurities(file);
        for (Security security:list) {
            System.out.println(security.toString());
        }
    }
}
