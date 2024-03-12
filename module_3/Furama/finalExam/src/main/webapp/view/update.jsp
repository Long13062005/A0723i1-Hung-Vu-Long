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
    <title>Sửa thông tin bệnh án</title>
    <c:import url="../layout/Bootstrap.jsp"></c:import>
</head>
<body>
<center>
    <h1>Sửa thông tin bệnh án</h1>
    <h2>
        Edit Victim
    </h2>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <td> <c:if test="${ benhNhan!= null}">
                    <input type="hidden" name="id" value="${benhNhan.id}"/>
                </c:if></td>
            </tr>
            <tr>
                <th>Sick Code:</th>
                <td>
                    <input required type="text"  size="45" disabled
                           value="<c:out value='${benhNhan.idSick }' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Victim Code:</th>
                <td>
                    <input required type="text"   size="45" disabled
                           value="<c:out value='${benhNhan.codeVictim}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Victim Name:</th>
                <td>
                    <input required type="text" name="name" size="45" id="inputName"
                           value="<c:out value='${benhNhan.nameVictim}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date start:</th>
                <td>
                    <input required type="text" name="dateStart" size="45" id="checkDateStart"
                           value="<c:out value='${benhNhan.dateStart}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date End:</th>
                <td>
                    <input required type="text" name="dateEnd" size="45" id="checkDateEnd"
                           value="<c:out value='${benhNhan.dateEnd}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date start:</th>
                <td>
                    <input required type="text" name="reason" size="45" id="checkReason"
                           value="<c:out value='${benhNhan.reason}' />"
                    />
                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-outline-success" type="button" value="Cancel"
                           onclick="window.location.href='/hospital?action=student'"/>
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
    let name = document.getElementById("name").value;
    let nameRegex  = "([^,]+)";
    let reasonRegex = "()";
    let checkName = false;
    let checkDateStart = false;
    let checkDateEnd = false;
    let checkReason = false;
</script>
</body>
</html>