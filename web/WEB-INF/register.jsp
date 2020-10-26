<%-- 
    Document   : register.jsp
    Created on : Oct 25, 2020, 7:20:53 PM
    Author     : 710429
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            Username: <input type="text" name="username" value="${username}"><br>
            <input type="hidden" name="action" value="register">
            <input type="submit" value="register name">
        </form>
    </body>
</html>
