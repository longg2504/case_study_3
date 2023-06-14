<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/13/2023
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.7.1/sweetalert2.css"
      integrity="sha512-JzSVRb7c802/njMbV97pjo1wuJAE/6v9CvthGTDxiaZij/TFpPQmQPTcdXyUVucsvLtJBT6YwRb5LhVxX3pQHQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.7.1/sweetalert2.min.js"
        integrity="sha512-vCI1Ba/Ob39YYPiWruLs4uHSA3QzxgHBcJNfFMRMJr832nT/2FBrwmMGQMwlD6Z/rAIIwZFX8vJJWDj7odXMaw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.7.1/sweetalert2.css"
      integrity="sha512-JzSVRb7c802/njMbV97pjo1wuJAE/6v9CvthGTDxiaZij/TFpPQmQPTcdXyUVucsvLtJBT6YwRb5LhVxX3pQHQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
      integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        a{
            color: black;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Danh sách sản phẩm</h1>
    <p><a href="/product?action=create" style="text-decoration: none" class="btn btn-success">Create new product</a></p>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Category</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Describle</th>
            <th scope="col">Quantity</th>
            <th scope="col">Image</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${requestScope.products}">
            <tr>
                <th scope="row">${p.getId()}</th>
                <td>
                    <c:forEach var="pCategory" items="${requestScope.categories}">
                        <c:if test="${pCategory.getId() == p.getId()}">${pCategory.getName()}</c:if>
                    </c:forEach>
                </td>
                <td>${p.getName()}</td>
                <td>${p.getPrice()}</td>
                <td>${p.getDescrible()}</td>
                <td>${p.getQuantity()}</td>


                <td><img src="${p.getImage()}" style="width: 100px; height: auto"></td>



                <td>
                    <a href="/product?action=edit&Id=${p.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                    <a onclick="handleClick(${p.getId()})"><i class="fa-solid fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/product?action=delete" method="post" id="deleteForm">
        <input type="hidden" name="idDelete" id="idDelete" value="">
    </form>
</div>
<script>
    function handleClick(idProduct){
        document.getElementById("idDelete").value = idProduct;
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                document.getElementById("deleteForm").submit();
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                )
            }
        })
    }
</script>
</body>
</html>
