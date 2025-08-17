<%@ page import="java.util.List" %>
<%@ page import="org.example.Product" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Product List</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price (EGP)</th>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        for (Product p : products) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
    </tr>
    <% } %>
</table>

<h2>Add a Product</h2>
<form method="post" action="products">
    Name: <input type="text" name="name" required><br>
    Price: <input type="number" step="0.01" name="price" required><br>
    <input type="submit" value="Add Product">
</form>
</body>
</html>
