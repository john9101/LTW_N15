<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>
<c:set var="product" value="${requestScope.product}"/>
<c:set var="category" value="${requestScope.category}"/>
<c:set var="listParameter" value="${requestScope.listParameter}"/>
<jsp:useBean id="productFactory" class="utils.ProductFactory" scope="session"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Các thư viện hỗ trợ-->
    <!--Font Awesome-->
    <link rel="stylesheet" href="assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">
    <!--Bootstrap-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-grid.min.css">
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
    <link rel="stylesheet" href="assets/css/productDetail.css">
    <link rel="stylesheet" href="assets/css/productOrder.css">
    <title>Other sản phẩm</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form class="form" action="#!">
    <div class="container-xl order__log-padding">
        <%--So do --%>
        <div class="col-12">
            <h2 class="order__heading">Bảng số đo</h2>
            <div class="order__guide-size">
                <img src="assets/img/sizeGuide/${category.sizeTableImage}" alt="">
            </div>
        </div>
        <c:forEach var="parameter" items="${listParameter}" varStatus="loop">
            <%--Parameter--%>
            <div class="col-12">
                <div class="separate"></div>
            </div>
            <div class="col-12">
                <h2 class="order__heading">${parameter.name}</h2>
                <div class="row align-items-center">
                    <div class="col-5">
                        <label class="order__group">
                            <label class="order__parameter">
                                <input id="parameter${loop.index}" class="order__input" type="text"
                                       placeholder="Hãy nhập số đo của ${fn:toLowerCase(parameter.name)}">
                                <c:set var="unit" value="${parameter.unit}"/>
                                <span class="order__unit">${unit}</span>
                            </label>
                            <p class="order__parameter-valid">
                                Giá trị khả dụng chấp nhận từ <strong><span id="minValueParameter${loop.index}" class="order__parameter-min">${parameter.minValue}</span> ${unit}</strong> đến
                                <strong><span id="maxValueParameter${loop.index}" class="order__parameter-max">${parameter.maxValue}</span> ${unit}</strong>
                            </p>
                            <p class="order__error"></p>
                        </label>
                    </div>
                        <%--Image--%>
                    <div class="offset-1 col-6">
                        <div class="order__guide-parameter">
                            <img src="assets/img/step_guide/coAo.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="order__log">
        <div class="order__info">
            <div class="order__media">
                <c:set var="firstImage"
                       value="${productFactory.getListImagesByProductId(product.id).get(0).nameImage}"/>
                <img src="assets/img/product_img/${firstImage}" alt="${firstImage}"/>
            </div>
            <div class="order__content">
                <h1 class="order__name">${product.name}</h1>
                <input type="text" value="${product.id}" hidden="hidden">
                <div class=" form__block order__group">
                    <c:set var="colors" value="${productFactory.getListColorsByProductId(product.id)}"/>
                    <div class="form__choose-color">
                        <p class="form__title">Màu sắc</p>
                        <c:forEach var="color" items="${colors}">
                            <label class="form__color-check" style="background-color: ${color.codeColor}">
                                <input type="radio" name="color" hidden="hidden">
                            </label>
                        </c:forEach>
                    </div>
                    <p class="order__error"></p>
                </div>

                <div class="form__block order__group">
                    <div class="form__quantity-wrapper">
                        <p class="form__title">Số lượng</p>
                        <div class="form__quantity">
                            <div class="form__quantity-inner">
                                <div class="form___quantity-btn form___quantity--decrease"></div>
                                <input id="quantity" type="text" name="quantity" value="1" disabled>
                                <div class="form___quantity-btn form___quantity--increase"></div>
                            </div>
                        </div>
                    </div>
                    <p class="order__error"></p>
                </div>
            </div>
        </div>
        <button id="order__submit" type="submit" class="order__submit-cart button--hover button">
            Thêm vào giỏ hàng
        </button>
    </div>
</form>
<script src="js/validateForm.js"></script>
<script src="js/productOrder.js"></script>
</body>
</html>