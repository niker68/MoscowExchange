<%@ page language="java" contentType="text/html; charset=windows-1251"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Security Manager</title>
    <style>
        h1 {
            background: #569099;
            padding: 10px;
            color: #fff;
        }
        a {
            padding-right: 100px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Security Manager</h2>
    <h3><table cellpadding="5" width="100%" border="3px"  align="center">
        <tr><td align="center"><a href="${pageContext.request.contextPath}/addsecurity">New Security</a></td>
        <td align="center">Import Securities<form action="http://localhost:8080/uploadsecurities" method="post" enctype="multipart/form-data">
            <input name="file[]" type="file" value="Change files" multiple="multiple"><br>
            <input type="submit" value="Upload"><br>
        </form>
        </td>
            <td align="center">Import Histories<form action="http://localhost:8080/uploadhistories" method="post" enctype="multipart/form-data">
                <input name="file[]" value="Change files" type="file" multiple="multiple"><br>
              <input type="submit" value="Upload"><br>
            </form></td>
        <tr>
        <td align="center"></td>
        <td align="center"><form action="http://localhost:8080/testadded" method="post">
            <button type="submit">Add test data</button>
        </form></td>
        <td align="center"><form action="http://localhost:8080/deleteall" method="post">
            <button type="submit">Delete all</button>
        </form><td/>
        </tr>
    </table></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Secid</th>
            <th>Short Name</th>
            <th>Name</th>
            <th></th>
        </tr>
        <jsp:useBean id="listSecurity" scope="request" type="java.util.List"/>
        <c:forEach items="${listSecurity}" var="security">
            <tr>
                <td>${security.id}</td>
                <td>${security.secid}</td>
                <td>${security.shortname}</td>
                <td>${security.name}</td>
                <td>
<%--                    <a href="/edit?id=${security.id}">Edit</a>--%>
                    <form action="/history" method="get" >
                        <input type="hidden" name= "id" value=${security.id}>
                        <button type="submit">Open history</button>
                    </form>
                </td>
                <td>
                    <form action="/delete" method="post" >
                        <input type="hidden" name= "id" value=${security.id}>
                        <button type="submit">Delete</button>
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>