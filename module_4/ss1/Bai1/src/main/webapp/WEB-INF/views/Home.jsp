<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/13/2024
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
    <style>
        span,input {
            font-size: larger;
            color: red;
        }
        .result {
            color: green;
        }
        .convert{
            color: blue;
        }
    </style>
</head>
<body>
<form method="post" action="/convertVND">
    <span>Currency VND</span>
    <input type="number" name="vnd">
    <span>---------></span>
    <span>Currency USD :</span>
    <span>${usdAmount}</span>
    <input type="submit" value="Convert" class="convert">
</form>
<form method="post" action="/convertUSD">
    <span>Currency USD</span>
    <input name="usd" type="number" class="result">
    <span>---------></span>

    <span>Currency VND :</span>
    <span>${vndAmount}</span>
    <input type="submit" value="Convert" class="convert">
</form>

</body>
</html>
