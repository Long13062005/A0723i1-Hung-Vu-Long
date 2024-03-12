<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
    <link rel="stylesheet" href="View/bootstrap520/css/bootstrap.css">
    <link rel="stylesheet" href="View/datatables/css/dataTables.bootstrap.css">
    <script src="View/bootstrap520/js/bootstrap.js"></script>
    <script src="View/datatables/js/dataTables.bootstrap.js"></script>
    <script src="View/jquery/jquery-3.5.1.min.js"></script>
    <style>
        .header {
            background-color: red;
        }
        .border{
            border: 1px solid black;
        }
        .logo-name{
            font-family: 'Courier New', Courier, monospace;
            font-size: larger;
            font-weight: bolder;
            color: aqua;
        }
        .nav-header {
            width: 100%;
            font-size: large;
            background-color: rgb(211, 211, 211);
            font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            border: 3px solid black;
            --bs-gutter-x: 0rem;

        }
        .scroll-list {
            max-height: 100%;
            overflow-y: auto;
            border: 1px solid black;
            padding: 10px;

        }

        .scroll-list li {
            list-style: none;
            padding: 8px;
        }
    </style>
</head>
<body>
<header>
    <div class=" row header">
        <nav class="navbar bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand mx-3" href="#">
                    <img src="View/Pic/test.png" alt="Logo" width="50" height="50" class="d-inline-block align-text-top mx-2">
                    <p class="logo-name">Furama</p>
                </a>
            </div>
        </nav>
    </div>
</header>
<div class="row nav-header">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Employee</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Customer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link  " href="#"  >Service</a>
        </li>
        <li class="nav-item">
            <a class="nav-link  " href="#"  >Contract</a>
        </li>
        <li class="nav-item">
            <nav class="navbar bg-body-tertiary ">
                <div class="container-fluid ">
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </li>
    </ul>

</div>
<div class="main row">
    <div class="col-lg-3 scrollbar">
        <div class="scroll-list">
            <ul>
                <li>Item 1</li>
                <li>Item 2</li>
                <li>Item 3</li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
                <li> </li>
            </ul>
        </div>
    </div>
    <div class="col-lg-9 ">
        <div class="border"></div>
    </div>

</div>
<div class="footer">

</div>
</body>
</html>