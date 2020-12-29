package services;

import models.History;
import models.Security;
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
import java.text.ParseException;
import java.util.*;

public class DataImport {

    //принимает файл ценных бумаг с Московской биржи, преобразует в список объектов Security и возвращает этот список
    //используется в методе AddSecuriritiesInDB
    public static ArrayList<Security> getListOfSecuritiesFromXML(File file) throws IOException, SAXException, ParserConfigurationException {
        ArrayList <Security> securities = new ArrayList();
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(file);

        // Получение списка всех элементов row внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList securityElements = document.getDocumentElement().getElementsByTagName("row");

        for (int i = 0; i < securityElements.getLength(); i++) {
        Node security = securityElements.item(i);

        // Получение атрибутов каждого элемента
        NamedNodeMap attributes = security.getAttributes();

        // Добавление ценной бумаги. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
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
            ArrayList <Security>list = getListOfSecuritiesFromXML(file);
        for (Security security:list) {
            System.out.println(security.toString());
        }
    }

    //принимает файл историй операций ценных бумаг с Московской биржи, преобразует в список объектов History и возвращает этот список
    //используется в методе  AddHistoriesInDB
    public static List<History> getListOfHistoriesFromXML(File file1) throws IOException, SAXException, ParserConfigurationException, ParseException {
        List <History> histories = new ArrayList();
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder1 = factory1.newDocumentBuilder();

        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document1 = builder1.parse(file1);

        // Получение списка всех элементов row внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList historyElements = document1.getDocumentElement().getElementsByTagName("row");

        for (int i = 0; i < historyElements.getLength()-1; i++) {
            Node history = historyElements.item(i);

            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = history.getAttributes();

            // Добавление истории. Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
            History historynew = new History();
            if (!attributes.getNamedItem("BOARDID").getNodeValue().isEmpty()) {
                historynew.setBoardid(attributes.getNamedItem("BOARDID").getNodeValue());
            }

            String stringDate=attributes.getNamedItem("TRADEDATE").getNodeValue();
            String [] array = stringDate.split("-");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(array[0]), Integer.parseInt(array[1]) , Integer.parseInt(array[2]));
            Date date=calendar.getTime();
            historynew.setTradedate(date);
            historynew.setShortname(attributes.getNamedItem("SHORTNAME").getNodeValue());
            historynew.setSecid(attributes.getNamedItem("SECID").getNodeValue());
            if (!attributes.getNamedItem("NUMTRADES").getNodeValue().isEmpty())
            historynew.setNumtrades(Double.parseDouble(attributes.getNamedItem("NUMTRADES").getNodeValue()));
            if (!attributes.getNamedItem("VALUE").getNodeValue().isEmpty())
            historynew.setValue(Double.parseDouble(attributes.getNamedItem("VALUE").getNodeValue()));
            if (!attributes.getNamedItem("OPEN").getNodeValue().isEmpty())
            historynew.setOpen(Double.parseDouble(attributes.getNamedItem("OPEN").getNodeValue()));
            if (!attributes.getNamedItem("LOW").getNodeValue().isEmpty())
            historynew.setLow(Double.parseDouble(attributes.getNamedItem("LOW").getNodeValue()));
            if (!attributes.getNamedItem("HIGH").getNodeValue().isEmpty())
            historynew.setHigh(Double.parseDouble(attributes.getNamedItem("HIGH").getNodeValue()));
            if (!attributes.getNamedItem("LEGALCLOSEPRICE").getNodeValue().isEmpty())
            historynew.setLegalcloseprice(Double.parseDouble(attributes.getNamedItem("LEGALCLOSEPRICE").getNodeValue()));
            if (!attributes.getNamedItem("WAPRICE").getNodeValue().isEmpty())
            historynew.setWarprice(Double.parseDouble(attributes.getNamedItem("WAPRICE").getNodeValue()));
            if (!attributes.getNamedItem("CLOSE").getNodeValue().isEmpty())
            historynew.setClose(Double.parseDouble(attributes.getNamedItem("CLOSE").getNodeValue()));
            if (!attributes.getNamedItem("VOLUME").getNodeValue().isEmpty())
            historynew.setVolume(Double.parseDouble(attributes.getNamedItem("VOLUME").getNodeValue()));
            if (!attributes.getNamedItem("MARKETPRICE2").getNodeValue().isEmpty())
            historynew.setMarketprice2(Double.parseDouble(attributes.getNamedItem("MARKETPRICE2").getNodeValue()));
            if (!attributes.getNamedItem("MARKETPRICE3").getNodeValue().isEmpty())
            historynew.setMarketprice3(Double.parseDouble(attributes.getNamedItem("MARKETPRICE3").getNodeValue()));
            if (!attributes.getNamedItem("ADMITTEDQUOTE").getNodeValue().isEmpty())
            historynew.setAdmittedquote(Double.parseDouble(attributes.getNamedItem("ADMITTEDQUOTE").getNodeValue()));
            if (!attributes.getNamedItem("MP2VALTRD").getNodeValue().isEmpty())
            historynew.setMp2valtrd(Double.parseDouble(attributes.getNamedItem("MP2VALTRD").getNodeValue()));
            if (!attributes.getNamedItem("MARKETPRICE3TRADESVALUE").getNodeValue().isEmpty())
            historynew.setMarketprice3tradesvalue(Double.parseDouble(attributes.getNamedItem("MARKETPRICE3TRADESVALUE").getNodeValue()));
            if (!attributes.getNamedItem("ADMITTEDVALUE").getNodeValue().isEmpty())
            historynew.setAdmittedvalue(Double.parseDouble(attributes.getNamedItem("ADMITTEDVALUE").getNodeValue()));
            if (!attributes.getNamedItem("WAVAL").getNodeValue().isEmpty())
            historynew.setWaval(Double.parseDouble(attributes.getNamedItem("WAVAL").getNodeValue()));

            histories.add(historynew);
        }
        return histories;
    }

    //использовался для отладки
    public static void importAndPrintHistories(File file) throws ParserConfigurationException, SAXException, IOException, ParseException {
        List <History>list = getListOfHistoriesFromXML(file);
        for (History history:list) {
            System.out.println(history.toString());
        }
    }

    //добавляет список объектов Securities в базу данных. Для тех ценных бумаг записи
    //используется в сервлете UploadSecurities
    public static void AddSecuriritiesInDB(List<File> filesOfSecurities) throws ParserConfigurationException, SAXException, IOException, ParseException {

        SecurityService securityService = new SecurityService();
        for (File file : filesOfSecurities) {
            List<Security> securities = DataImport.getListOfSecuritiesFromXML(file);
            securityService.saveList(securities);
            System.out.println("Добавлено или обновлено " + securities.size()+" ценных бумаг в базе данных");
        }
    }

    //добавляет список объектов Histories в базу данных. Связь Many-To-One с Securities. History без Security не существует.
    //используется в сервлете UploadHistories
    public static void AddHistoriesInDB(List<File> filesOfHistories) throws SAXException, ParserConfigurationException, ParseException, IOException {

        SecurityService securityService = new SecurityService();
        for (File file:filesOfHistories ) {
            List<History> histories = DataImport.getListOfHistoriesFromXML(file);
            List<Security> securities = securityService.findAll();
            for (History history: histories) {
                for (Security security:securities) {
                    if (security.getSecid().equals(history.getSecid())){
                        history.setSecurity(security);
                        security.addHistory(history);
                        securityService.saveOrUpdate(security);
                    }
                }
            }
            System.out.println("Сделано " + histories.size()+" записей историй в базу данных");
        }
    }
}
