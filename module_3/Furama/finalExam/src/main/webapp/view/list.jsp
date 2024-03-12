<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 3/6/2024
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bệnh viện</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách bệnh án </h1>



<table class="table table-stripped">
    <tr>
        <th>STT</th>
        <th>Mã bệnh án</th>
        <th>Mã bệnh nhân</th>
        <th>Tên bệnh nhân</th>
        <th>Ngày nhập viện</th>
        <th>Ngày xuất viện</th>
        <th>Lý do nhập viện</th>
        <th>Tác vụ</th>
    </tr>
    <c:forEach var="bn" items="${benhNhanList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${bn.codeSick}</td>
            <td>${bn.codeVictim}</td>
            <td>${bn.nameVictim}</td>
            <td>${bn.dateStart}</td>
            <td>${bn.dateEnd}</td>
            <td>${bn.reason}</td>
            <td>
                <button class="btn btn-outline-success" onclick="window.location.href='/hospital?action=update&id=${bn.id}'">Edit</button>
                <button type="button"  onclick="infoDelete('${bn.id}','${bn.codeSick}')" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${benhNhanList.isEmpty()}">
        <tr>
            <td colspan="7">
                <h2   style="color: red;text-align: center;">Hiện tại không có bệnh án nào</h2>
            </td>
        </tr>
    </c:if>
</table>

<%--Modal xoá--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/hospital?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá thông tin bệnh án : </span><span style="color: red" id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button class="btn btn-danger">Xóa</button>
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
