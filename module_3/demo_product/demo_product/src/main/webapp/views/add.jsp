<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 3/6/2024
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        small {
            color: red;
        }
    </style>
</head>
<body>
<h1>Thêm mới</h1>
<form method="post">
    <input id="code" oninput="check()" name="code" placeholder="code">
    <small id="errorCode"></small><br>

    <input oninput="check()" id="name" name="name" placeholder="name">
    <small id="errorName"></small><br>

    <input oninput="check()" id="unit" name="unit" placeholder="unit">
    <small id="errorUnit"></small><br>

    <input oninput="check()" id="price" name="price" placeholder="price">
    <small id="errorPrice"></small><br>

    <select name="typeId">
        <c:forEach var="tp" items="${productTypeList}">
            <option value="${tp.id}">${tp.name}</option>
        </c:forEach>
    </select><br>
    <button disabled id="btn-save">Save</button>
</form>
<script>
    function check() {
        let code = document.getElementById("code").value;
        let name = document.getElementById("name").value;
        let unit = document.getElementById("unit").value;
        let price = document.getElementById("price").value;
        let regexCode = /^MHH-\d{4}$/;
        let regexPrice = /^\d+$/;
        let checkCode = false;
        let checkName = false;
        let checkUnit = false;
        let checkPrice = false;
        // check code
        if (code === "") {
            document.getElementById("errorCode").innerText = "Không được để trông";
        } else {
            if (regexCode.test(code)) {
                document.getElementById("errorCode").innerText = "OK";
                checkCode = true;
            } else {

                document.getElementById("errorCode").innerText = "Không đúng định dạng MHH-XXXX"
            }
        }
        // check name
        if (name === "") {
            document.getElementById("errorName").innerText = "Không được để trông";
        } else {
            checkName = true
            document.getElementById("errorName").innerText = "OK";
        }
        // check unit
        if (unit === "") {
            document.getElementById("errorUnit").innerText = "Không được để trông";
        } else {
            checkUnit = true
            document.getElementById("errorUnit").innerText = "OK";
        }
        if (price === "") {
            document.getElementById("errorPrice").innerText = "Không được để trông";
        } else {
            if (regexPrice.test(price)) {
                document.getElementById("errorPrice").innerText = "OK";
                checkPrice = true
            } else {
                document.getElementById("errorPrice").innerText = "Giá phải lớn hơn 0";
            }
        }
        // tất cả ok thì mới được phép submit
        if (checkCode && checkUnit && checkName && checkPrice) {
            document.getElementById("btn-save").disabled = false;
        } else {
            document.getElementById("btn-save").disabled = true;
        }

    }
</script>
</body>
</html>
