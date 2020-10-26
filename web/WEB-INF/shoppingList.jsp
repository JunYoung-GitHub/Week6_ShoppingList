<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 7:21:06 PM
    Author     : 710429
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <p>Hello, ${username}  <a href="<c:url value="ShoppingList?action=logout"/>">Logout</a></p>
           
        <h2>List</h2>
        
        <form method="post" action="ShoppingList">
            Add item: <input type="text" name="item"><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="add">
        </form>
        
        <form method="post" action ="ShoppingList">
            <ul>
                <c:forEach items="${addList}" var="addItem">
                    <li><input type="radio" name="item" value="${addItem}"</li>${addItem}
                </c:forEach>
            </ul>
        <input type="hidden" value="delete" name="action">
        <input type="submit" value="Delete"><br>
        </form>
        
    </body>
</html>
