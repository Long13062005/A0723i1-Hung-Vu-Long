<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 1/31/2024
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
    <table class="table table-striped">
    <tr>
    <th>Tên </th>
    <th>Ngày sinh </th>
    <th>Địa chỉ </th>
    <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" varStatus="status" items="${customerList}">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getDateBorn()}</td>
            <td>${customer.getAddress()}</td>
            <td><img src="${customer.getUrlPhoto()}"></td>
        </tr>
    </c:forEach>

    </table>
</body>
</html>