<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/SpringMVC11/product/updateProduct" method="post">
       Product id : <input type="text" name="id" id="pid" value="${p.pid}" readonly><br>
       Product name : <input type="text" name="name" id="pname" value="${p.pname}"><br>
        Quantity: <input type="text" name="qty" id="qty" value="${p.qty}"><br>
         price : <input type="text" name="price" id="price" value="${p.price}"><br>
         <button type="submit" name="btn" id="btn">update Product</button>
   </form>

</body>
</html>