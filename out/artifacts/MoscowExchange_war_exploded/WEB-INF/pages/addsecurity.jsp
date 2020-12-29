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
            padding-top: 100px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Add Security</h2>
    <table border="1" cellpadding="5" border="3px" width="100%" align="center">
        <form method="post">
        <tr>
            <th>ID</th>
            <th>Secid</th>
            <th>Short Name</th>
            <th>Name</th>

        </tr>


            <tr>
                <td><label>
                    <div align="center">
                    <input type="text" name="ID" />
                    </div>
                    </label></td>
                <td><label>
                    <div align="center">
                    <input  type="text" name="Secid" />
                    </div>
                </label></td>
                <td><label >
                    <div align="center">
                    <input type="text" name="Short Name" />
                    </div>
                </label></td>
                <td><label>
                    <div align="center">
                    <input type="text" name="Name" />
                    </div>
                </label></td>
            </tr>
            <tr>
                <div style="padding: 10px;" align="center">
                    <button type="submit" >Add</button>
                </div>
            </tr>

        </form>
    </table>
</div>


</body>
</html>