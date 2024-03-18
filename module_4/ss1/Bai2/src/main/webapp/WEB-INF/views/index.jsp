<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/18/2024
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/lookup">
    <p>Translate English to Vietnamese</p>
    <input name="word" type="text" placeholder="hello,world">
    <h1>${meaning}</h1>
    <input type="submit" value="dịch">
</form>

</body>
</html>
