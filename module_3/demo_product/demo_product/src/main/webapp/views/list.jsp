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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách sản phẩm </h1>
<a href="/product?action=add">Thêm mới</a>

<form action="/product" method="get">
    <input hidden="" name="action" value="search">
    <input name="searchName" value="${searchName}" placeholder="Enter name">
    <select name="searchTypeName">
        <option value="">--Chọn loại ---</option>
        <c:forEach var="tp" items="${productTypeList}">
            <option value="${tp.name}">${tp.name}</option>
        </c:forEach>
    </select>
    <button>Search</button>
</form>

<table class="table table-stripped">
    <tr>
        <th>STT</th>
        <th>Code</th>
        <th>Name</th>
        <th>Unit</th>
        <th>Price</th>
        <th>Type</th>
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.unit}</td>
            <td>${product.price}</td>
            <td>${product.typeName}</td>
            <td>
                <button type="button"  onclick="infoDelete('${product.id}','${product.name}')" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
<%--    Thông báo khi không có kết quả--%>
    <c:if test="${productList.isEmpty()}">
        <tr>
            <td colspan="7">
                <h2  style="color: red; text-align: center">Không tìm thấy kết quả</h2>
            </td>
        </tr>
    </c:if>
</table>

<%--Modal xoá--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="product?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá sp : </span><span style="color: red" id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button class="btn btn-primary">OK</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    // hiện thị dữ liệu lên modal xoá

    function infoDelete(id,name){
     document.getElementById("deleteId").value=id;
     document.getElementById("deleteName").innerText=name;
    }
</script>
</body>
</html>
