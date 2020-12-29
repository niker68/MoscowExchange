<%@ page import="java.util.List" %>
<%@ page import="models.History" %>
<%@ page import="models.Security" %>
<%@ page language="java" contentType="text/html; charset=windows-1251"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>History of <%Security security = (Security) request.getAttribute("security");
        out.print(security.getName()); %></title>
    <style>
        h1 {
            background: #569099;
            padding: 10px;
        }
        a {
            padding-right: 100px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>History of <%out.print(security.getName()); %></h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Board id</th>
            <th>Trade date</th>
            <th>Num trades</th>
            <th>Value</th>
            <th>Open</th>
            <th>Low</th>
            <th>High</th>
            <th>Close Price</th>
            <th>Close</th>
            <th>Volume</th>
            <th>Market price 2</th>
            <th>Market price 3</th>
            <th>Admitted value</th>
        </tr>
        <%
            List<History> listHistory = (List<History>) request.getAttribute("listHistory");
            for (History history: listHistory) {
                %>
               <tr>
                <td><h3><%out.print(history.boardid);%></h3></td>
                <td><h3><%out.print(history.tradedate);%></h3></td>
                <td><h3><%out.print(history.numtrades);%></h3></td>
                <td><h3><%out.print(history.value);%></h3></td>
                <td><h3><%out.print(history.open);%></h3></td>
                <td><h3><%out.print(history.low);%></h3></td>
                <td><h3><%out.print(history.high);%></h3></td>
                <td><h3><%out.print(history.legalcloseprice);%></h3></td>
                <td><h3><%out.print(history.close);%></h3></td>
                <td><h3><%out.print(history.volume);%></h3></td>
                <td><h3><%out.print(history.marketprice2);%></h3></td>
                <td><h3><%out.print(history.marketprice3);%></h3></td>
                <td><h3><%out.print(history.admittedvalue);%></h3></td>
            </tr>
        <%
            }

        %>


    </table>
    <table><tr>
        <td align="center"><h2><a href="/home">Home</a></h2></td>
    </tr></table>
</div>
</body>
</html>