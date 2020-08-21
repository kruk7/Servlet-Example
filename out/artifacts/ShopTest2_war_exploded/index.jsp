<<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
  <title>Product Explorer</title>
  <meta http-equiv="Refresh" content="0; URL=index.jsf">
</head>
<body>
<h1>Product Menager</h1>
<h2>Add Product</h2>
<form action="product?add=true" method="post">
  <input type="text" name="productName" placeholder="Product name"/>
  <input type="number" name="productPrice" step="0.1" placeholder="Product Price"/>
  <input type="text" name="productCategory" placeholder="Product Category"/>
  <input type="submit" value="Add"/>
</form>

<form action="product?add=false" method="post">
  <input type="text" name="query"/>
  <input type="submit" value="Get">
</form>
</body>
</html>