<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 2/21/2024
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<c:import url="../layout/head.jsp"></c:import>

<body>
<a role="button" class="btn btn-primary btn-lg" href="/Product?add=">List</a>
<a role="button" class="btn btn-primary btn-lg" href="Product?action=add">Them moi </a>
<a role="button" class="btn btn-danger btn-lg" href="Product?action=delete">Xoa </a>
<form action="/Product?action=delete" method="post">
    <lable>Nhập Tên sản phẩm: <input type="text" name="name"></lable>
    <input type="submit" value="Xóa sản phẩm">
</form>
</body>
</html>


