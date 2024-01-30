<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    .login {
      height : 180px;
      width: 230px;
      margin: 0;
      padding: 10px;
      border: 1px #CCC solid;
    }
    .login input {
      padding: 5px;
      margin: 5px;
    }
  </style>
</head>
<body>
<h1>Ứng dụng Product Discount Calculator</h1>
<form method="post" action="/DiscountServlet">
  <div class="login">
    <span>Product Description:
    <input type="text" name="description"/>
  </span>
    <br>
    <span>List Price:
    <input type="number" name="price"/>
  </span>
    <br>
    <span>Discount Percent:
    <input type="number" name="discount"/>
  </span>
      <button type="submit" >Submit</button>
      <button type="reset" >Reset</button>
  </div>

</form>
</body>
</html>