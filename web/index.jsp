<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Product Explorer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Product Manager</h1>
<h2>Add Product</h2>
<form action="products?add=true" method="post">
    <input type="text" name="productName" placeholder="Product name"/>
    <input type="number" name="productPrice" step="0.1" placeholder="Product Price"/>
    <input type="text" name="productCategory" placeholder="Product Category"/>
    <input type="submit" value="Add"/>
</form>
<h2>Write your query</h2>
<form action="products?add=false" method="post">
    <input type="text" name="query"/>
    <input type="submit" value="Get">
</form>
<h2>Button pattern</h2>
<form action="search-patern?what-do=Product.findAll&parameter=false" method="post">
    <label>Find all products:</label>
    <input type="submit" value="View">
</form>

<form action="search-patern?what-do=Product.findOrderByName&parameter=false" method="post">
    <label>Find all products and order by Name:</label>
    <input type="submit" value="View">
</form>

<form action="search-patern?what-do=Product.findTenProd&parameter=false" method="post">
    <label>Find first 10 products:</label>
    <input type="submit" value="View">
</form>

<form action="search-patern?what-do=Product.findNumberProd&parameter=true" method="post">
    <label for="quantity">Find number of products (between 1 and 100):</label>
    <input type="number" id="quantity" name="quantity" value="1" min="1" max="100">
    <input type="submit" value="View">
</form>
</body>
</html>