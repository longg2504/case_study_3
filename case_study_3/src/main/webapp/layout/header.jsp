<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 14/06/2023
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <meta name="image" content=" ./assets/images/slider-image-3.jpg">
    <link rel="icon" href="./assets/images/male-clothes.ico">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/owl.css">
</head>

<body>
<!-- Header -->
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-left">
                    <li class="nav-item">
                        <a class="nav-link" href="index.php">Home
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="products.php?per_page=9&page=1&type=all" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">Products</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="products.php?per_page=9&page=1&type=all">ALL</a>
                            <a class="dropdown-item" href="products.php?per_page=9&page=1&type=hoodie">Hoodie</a>
                            <a class="dropdown-item" href="products.php?per_page=9&page=1&type=jacket">Jacket</a>
                            <a class="dropdown-item" href="products.php?per_page=9&page=1&type=pants">Pants</a>
                            <a class="dropdown-item" href="products.php?per_page=9&page=1&type=shirt">Shirt</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="checkout.php">Cart</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="contact.php" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">More</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="contact.php">Contact</a>
                            <a class="dropdown-item" href="about-us.php">About us</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="information.php" drole="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false"></a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="information.php">Information</a>
                            <a class="dropdown-item" href="history.php">History</a>
                            <a class="dropdown-item" href="changePassword.php">Change password</a>
                            <hr class="dropdown-divider">
                            <a class="dropdown-item" href="logout.php">Sign-out</a>
                        </div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="sign.php">Sign-In</a></li>
                </ul>
            </div>
            <a class="navbar-brand" href="index.php">
                <h2>Clothers<em> Store</em></h2>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </nav>
</header>

<div class="banner header-text" >
    <div class="owl-banner owl-carousel" id="slideshow">
        <div class="banner-item-01">
            <div class="text-content">
                <h4>Find your clothers today!</h4>
                <h2>Further MARKDOWNS</h2>
            </div>
        </div>
        <div class="banner-item-02">
            <div class="text-content">
                <h4>Fashion is immortal!</h4>
                <h2>Heavenly prices</h2>
            </div>
        </div>
        <div class="banner-item-03">
            <div class="text-content">
                <h4>Easy to buy</h4>
                <h2>Many types of clothes</h2>
            </div>
        </div>
    </div>
</div>
</body>

</html>