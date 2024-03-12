<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String mess = request.getParameter("mess");
    if(mess == null){
        mess="";
    }
%>
<html>
<head>
    <title>Student Management Application</title>
    <c:import url="../layout/Bootstrap.jsp"></c:import>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        Edit Student
    </h2>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <td> <c:if test="${ student!= null}">
                    <input type="hidden" name="id" value="${student.id}"/>
                </c:if></td>
            </tr>

            <tr>
                <th>Student Name:</th>
                <td>
                    <input required type="text" name="name" size="45" id="inputName"
                           value="<c:out value='${student.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Class:</th>
                <td>
                    <select name="classId" class="btn border border-secondary">
                        <c:forEach var="class1" items="${classList}">
                            <c:if test="${student.getId() == class1.getClassID()}">
                                <option selected value="${class1.classID}">${class1.getClassName()}</option>
                            </c:if>
                            <c:if test="${student.getId() != class1.getClassID()}">
                                <option value="${class1.classID}">${class1.getClassName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Tutor:</th>
                <td>
                    <select name="tutorId" class="btn border border-secondary">
                        <c:forEach var="tutor" items="${tutorList}">
                            <c:if test="${student.getId() == tutor.getGvID()}">
                                <option selected value="${tutor.gvID}">${tutor.getGvName()}</option>
                            </c:if>
                            <c:if test="${student.getId() != tutor.getGvID()}">
                                <option value="${tutor.gvID}">${tutor.getGvName()}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-outline-success" type="button" value="Cancel"
                           onclick="window.location.href='/student?action=student'"/>
                    <input class="btn btn-outline-warning" type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- toast Message-->
<button type="button" class="btn btn-primary" id="liveToastBtn" style="display: none
">Show live toast</button>
<div class="toast-container position-fixed bottom-0 end-0 p-3">
    <div id="liveToast" class="toast bg-info-subtle" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <%--          <img src="..." class="rounded me-2" alt="...">--%>
            <strong class="me-auto">Notification</strong>
            <small><span id="notificationTime">now</span></small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            <span id="mess"><%=mess%></span>
        </div>
    </div>
</div>
<!-- Modal add New Country -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/country?action=add&id=${product.id}" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Add new Country</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table>
                        <th>Name:</th>
                        <td><input type="text" name="newCountryName"></td>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-warning" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-outline-success">Save changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    mess= document.getElementById("mess").textContent;
    const toastTrigger = document.getElementById('liveToastBtn')
    const toastLiveExample = document.getElementById('liveToast')
    if (toastTrigger) {
        const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
        if(!(mess ==="")){
            toastBootstrap.show()
        }
    }
</script>
</body>
</html>