<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.message != null}">
    <h4>Thêm thành công</h4>
</c:if>
<a href="/productServlet">Come back list product</a>
<form method="post">
    <fieldset style="width: 300px">
        <legend>Add product</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="nameProduct" placeholder="Nhập tên sản phẩm" value="${requestScope.product.getName()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" placeholder="Nhập giá sản phẩm" value="${requestScope.product.getPrice()}"></td>
            </tr>
            <tr>
                <td>Describle</td>
                <td><input type="text" name="describle" placeholder="Nhập mô tả" value="${requestScope.product.getDescrible()}"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity" placeholder="Nhập số lượng" value="${requestScope.product.getQuantity()}"></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="text" name="image" placeholder="Link ảnh" value="${requestScope.product.getImage()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Thêm mới"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>