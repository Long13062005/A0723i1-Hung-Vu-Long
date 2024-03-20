<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/20/2024
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" >
    <h2>Sandwich Condiment </h2>
    <span>
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts

    </span>
    <hr>
    <input type="submit" value="save">
</form>
<h1>${list}</h1>
</body>
</html>
