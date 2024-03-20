<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/20/2024
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post" id="calculator" action="/">
    <input name="number1" type="number" placeholder="number 1">
    <input name="number2" type="number" placeholder="number 2">
    <br>
    <button type="submit" value="add" onclick="addURL('add')">Addition(+)</button>
    <button type="submit" value="sub" onclick="addURL('sub')">Subtraction(-)</button>
    <button type="submit" value="multi" onclick="addURL('multi')">Multiplication(X)</button>
    <button type="submit" value="div" onclick="addURL('div')">Division(/)</button>
</form>
<h1>${result}</h1>
<script>
    function addURL(operator) {
        var form = document.getElementById("calculator");
        form.action = "/" + encodeURIComponent(operator)
    }
</script>
</body>
</html>
