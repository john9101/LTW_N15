<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Các thư viện hỗ trợ-->
    <!--Font Awesome-->
    <link rel="stylesheet" href="assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">

    <!--Favicon-->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="assets/favicon/site.webmanifest">
    <!--Web font-->
    <link rel="stylesheet" href="assets/font/webfonts/Montserrat.css">

    <!--CSS-->
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="assets/css/logIn.css">

    <title>Đăng nhập</title>
</head>
<body>
<main class="main">
    <div class="frame">
        <div class="frame__media">
        </div>
        <article>
            <form action="logIn" class="form form--signUp" method="get">
                <div class="form__block">
                    <label for="username" class="form__label">Tên đăng nhập</label>
                    <input id="username" name="username" type="text" class="form__input">
                    <p class="form__error">
                    </p>
                </div>
                <div class="form__block">
                    <label for="password" class="form__label">Mật khẩu</label>
                    <input id="password" name="password" type="password" class="form__input">
                    <p class="form__error">
                        <c:if test="${not empty requestScope.error}">
                            <c:out value="${requestScope.error}"/>
                        </c:if>
                    </p>
                </div>
                <button id="form__submit" type="submit" class="form__submit button button--hover">Đăng nhập</button>
            </form>
            <a href="signUp.jsp" id="form__link--signUp" class="form__link ">Đăng ký</a>
        </article>
    </div>
</main>
<!--JS validate-->
<script src="js/validateForm.js"></script>
<script>
    var validation = new Validation({
        formSelector: ".form",
        formBlockClass: "form__block",
        errorSelector: ".form__error",
        rules: [
            Validation.isRequired("#username"),
            Validation.isRequired("#password"),
            Validation.minLength("#password", 6),
        ],
    })
</script>
</body>
</html>