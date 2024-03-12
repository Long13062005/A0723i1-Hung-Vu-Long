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
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh sách Học sinh </h1>
<button class="btn btn-success" onclick="window.location.href=href='/student?action=add'">Thêm mới</button>


<form action="/student" method="get">
    <input hidden="" name="action" value="searchByName">
    <input name="searchName" value="${searchName}" placeholder="Enter name">
<%--    <select name="searchClassID">--%>
<%--        <option value="">--Chọn lớp ---</option>--%>
<%--        <c:forEach var="class" items="${classList}">--%>
<%--            <option value="${class.className}">${class.className}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <select name="searchTutor">--%>
<%--        <option value="">--Chọn giảng viên ---</option>--%>
<%--        <c:forEach var="tutor" items="${tutorList}">--%>
<%--            <option value="${tutor.gvName}">${tutor.gvName}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
    <button>Search</button>
</form>

<table class="table table-stripped">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Class</th>
        <th>Giảng Viên</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <td>${student.className}</td>
            <td>${student.gvName}</td>
            <td>
                <button class="btn btn-outline-success" onclick="window.location.href='/student?action=update&id=${student.id}'">Edit</button>
                <button type="button"  onclick="infoDelete('${student.id}','${student.name}')" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    <%--    Thông báo khi không có kết quả--%>
    <c:if test="${studentList.isEmpty()}">
        <tr>
            <td colspan="5">
                <h2   style="color: red;text-align: center;">Không tìm thấy kết quả</h2>
            </td>
        </tr>
    </c:if>
    <c:if test="${studentList == null}">
        <tr>
            <td colspan="5">
                <h2   style="color: red;text-align: center;">Không tìm thấy kết quả</h2>
            </td>
        </tr>
    </c:if>
</table>

<%--Modal xoá--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="student?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá học sinh : </span><span style="color: red" id="deleteName"></span> không?
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
