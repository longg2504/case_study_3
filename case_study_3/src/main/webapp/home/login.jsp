<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 14/06/2023
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="/assets/css/sign.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Alkatra:wght@400;600;700&famicxly=Fira+Sans:ital,wght@0,200;0,300;1,200&family=Geologica:wght@100;200;400&family=Merriweather:ital,wght@0,300;0,400;1,300;1,400&family=Raleway:ital,wght@0,300;0,500;1,200;1,300;1,400&family=Roboto+Slab:wght@700;800&display=swap');
    </style>
</head>
<body>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="user?action=register" method="POST">
            <c:if test="${requestScope.message !=null}">
                <script>
                    window.onload = function () {
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Đã tạo tài khoản thành công!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                    };
                </script>
            </c:if>
            <h1>Create Account</h1>
            <div class="social-container">
            </div>
            <span>use your email for registration</span>
            <input type="email" name="user_email_re" placeholder="UserName"/>
            <div class="message" style="color: red; align-content: center;">${requestScope.error_email}</div>
            <div class="message" style="color: red; align-content: center;">${requestScope.emailavailable}</div>
            <input type="password" name="user_pass_re" placeholder="Password"/>
            <input type="password" name="re_pass_re" placeholder="Re_Password"/>
            <div class="message" style="color: red; align-content: center;">${requestScope.error_pass}</div>
            <div class="message" style="color: blue; align-content: center;">${requestScope.done}</div>
            <button name="btn_save" type="submit">Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="user?action=checkLogin" method="POST">
            <h1>Sign in</h1>
            <c:set var="cookie" value="${pageContext.request.cookies}"/>
            <div class="social-container">
            </div>
            <span>Use your account</span>
            <input type="text" name="user_email" placeholder="User Name" value="${cookie.email.value}" required>
            <input type="password" name="user_pass" placeholder="Password" value="${cookie.pass.value}" required>
            <a href="#">Forgot your password?</a>
            <button name="btn_submit" type="submit">Sign In</button>
            <p style="color: red; align-content: center; font-weight: bold">
                ${requestScope.error}
            </p>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/sign.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        var messageElements = document.querySelectorAll(".message");
        var check = false;
        for (let i = 0; i < messageElements.length; i++) {
            if (messageElements[i].innerHTML.length > 0) {
                check = true;
                break;
            }
        }
        if (check) {
            const container = document.getElementById('container');
            container.classList.add("right-panel-active");
        }
    });
</script>
</body>

</html>
