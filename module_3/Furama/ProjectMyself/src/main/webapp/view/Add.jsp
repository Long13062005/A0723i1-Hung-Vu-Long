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
    <title>Product Management Application</title>
    <c:import url="../layout/Bootstrap.jsp"></c:import>
    <style>
        small {
            color: red;
        }
    </style>
</head>
<body>
<center>
    <h1>Product Management</h1>
        <h2>Add New Product</h2>
<%--    <h2>--%>
<%--        <a href="product?action=product">List All Product</a>--%>
<%--    </h2>--%>
</center>
<div align="center">
    <form method="post">

        <table border="1" cellpadding="5">
            <tr>
                <th>Student Name:</th>
                <td>
                    <input oninput="check()" type="text" name="name" id="name" size="45" required/>
                    <small id="errorName"></small>

                </td>
            </tr>
            <tr>
                <th>Class:</th>
                <td>
                    <select oninput="check()" id="classID" name="classId" class="btn border border-secondary">
                                <option>--Choose class--</option>
                        <c:forEach var="class1" items="${classList}">
                            <option value="${class1.classID}">${class1.getClassName()}</option>
                        </c:forEach>
                    </select>
                    <small id="errorClassID"></small>
                    <!-- Button trigger modal -->

                </td>
            </tr>
            <tr>
                <th>Tutor:</th>
                <td>
                    <select oninput="check()" id="tutorID" name="tutorId" class="btn border border-secondary">
                        <option>--Choose tutor--</option>
                        <c:forEach var="tutor" items="${tutorList}">
                            <option value="${tutor.gvID}">${tutor.getGvName()}</option>
                        </c:forEach>
                    </select>
                    <small id="errorTutorID"></small>
                    <!-- Button trigger modal -->

                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-outline-warning" type="button" value="Cancel" onclick="window.location.href='/student?action=student'" />
                    <input class="btn btn-outline-success" id="btn-save" disabled type="submit" value="Save" />
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
        <form action="/country?action=add" method="post">
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
    function check() {
        // let code = document.getElementById("code").value;
        // let name = document.getElementById("name").value;
        // let unit = document.getElementById("unit").value;
        // let price = document.getElementById("price").value;
        // let regexCode = /^MHH-\d{4}$/;
        // let regexPrice = /^\d+$/;
        // let checkCode = false;
        // let checkName = false;
        // let checkUnit = false;
        // let checkPrice = false;
        // check code
        let name = document.getElementById("name").value;
        let nameRegex =
        let classID = document.getElementById("classID").value;
        let tutorID = document.getElementById("tutorID").value;
        let checkName = false;
        let checkClassID = false;
        let checkTutorID = false;

        // if (code === "") {
        //     document.getElementById("errorCode").innerText = "Không được để trông";
        // } else {
        //     if (regexCode.test(code)) {
        //         document.getElementById("errorCode").innerText = "OK";
        //         checkCode = true;
        //     } else {
        //
        //         document.getElementById("errorCode").innerText = "Không đúng định dạng MHH-XXXX"
        //     }
        // }
        // check name
        if (name === "") {
            document.getElementById("errorName").innerText = "Không được để trống";
        } else {
            checkName = true
            document.getElementById("errorName").innerText = "OK";
        }
        if (classID === "--Choose class--") {
            document.getElementById("errorClassID").innerText = "Không được để trống";
        } else {
            checkClassID = true
            document.getElementById("errorClassID").innerText = "OK";
        }
        if (tutorID === "--Choose tutor--") {
            document.getElementById("errorTutorID").innerText = "Không được để trống";
        } else {
            checkTutorID = true
            document.getElementById("errorTutorID").innerText = "OK";
        }
        // check unit
        // if (unit === "") {
        //     document.getElementById("errorUnit").innerText = "Không được để trông";
        // } else {
        //     checkUnit = true
        //     document.getElementById("errorUnit").innerText = "OK";
        // }
        // if (price === "") {
        //     document.getElementById("errorPrice").innerText = "Không được để trông";
        // } else {
        //     if (regexPrice.test(price)) {
        //         document.getElementById("errorPrice").innerText = "OK";
        //         checkPrice = true
        //     } else {
        //         document.getElementById("errorPrice").innerText = "Giá phải lớn hơn 0";
        //     }
        // }
        // tất cả ok thì mới được phép submit
        if (checkName && checkClassID && checkTutorID) {
            document.getElementById("btn-save").disabled = false;
        } else {
            document.getElementById("btn-save").disabled = true;
        }

    }
</script>
</body>
</html>