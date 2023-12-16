<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="java.text.resources.LocaleElements_vi_VN"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Các thư viện hỗ trợ-->
    <!--Font Awesome-->
    <link rel="stylesheet" href="assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">
    <!--Bootstrap-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-grid.min.css">
    <!--JQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
    <link rel="stylesheet" href="assets/css/productBuying.css">
    <title>Gian hàng</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main class="main">
    <section class="products">
        <div class="container-xl">
            <div class="row ">
                <div class="col-3">
                    <form action="filterProduct" class="form__filter">
<%--                        <div class="filter__group">--%>
<%--                            <span class="filter__title">Tên sản phẩm</span>--%>
<%--                            <input name="nameProduct" type="text" autocomplete="off" class="filter__search filter__input"--%>
<%--                                   placeholder="Nhập sản phẩm bạn muốn tìm tại đây.">--%>
<%--                        </div>--%>
                        <span class="filter__separate"></span>
                        <div class="filter__group">
                            <span class="filter__title">Phân loại sản phẩm</span>
                            <div class="filter__radio-list">
                                <c:forEach items="${requestScope.categoryList}" var="item">
                                    <label class="filter__radio-item">
                                        <input name="categoryId" type="checkbox" class="filter__input filter__radio"
                                               hidden="hidden" value="${item.id}">
                                        <span class="filter-radio__icon-wrapper">
                                            <i class="fa-solid fa-check filter-radio__icon"></i>
                                        </span>
                                            ${item.nameType}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <span class="filter__separate"></span>
                        <div class="filter__group">
                            <span class="filter__title">Mức giá</span>

                            <div class="filter__radio-list">
                                <c:forEach items="${pageContext.servletContext.getAttribute('moneyRangeList')}"
                                           var="moneyRange">
                                    <fmt:formatNumber value="${moneyRange.from}" type="currency" currencyCode="VND"
                                                      var="moneyFrom"/>
                                    <fmt:formatNumber value="${moneyRange.to}" type="currency" currencyCode="VND"
                                                      var="moneyTo"/>
                                    <label class="filter__radio-item">
                                        <input name="moneyRange" type="checkbox" class="filter__input filter__radio"
                                               hidden="" value="${moneyRange}">
                                        <span class="filter-radio__icon-wrapper">
                                            <i class="fa-solid fa-check filter-radio__icon"></i>
                                        </span>${moneyFrom} - ${moneyTo}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <span class="filter__separate"></span>
                        <div class="filter__group">
                            <span class="filter__title">Kích cỡ</span>
                            <div class="filter__radio-list">
                                <c:forEach items="${requestScope.sizeList}" var="item">
                                    <label class="filter__radio-item">
                                        <input name="size" value="${item.nameSize}" type="checkbox"
                                               class="filter__input filter__radio"
                                               hidden="hidden">
                                        <span class="filter-radio__icon-wrapper">
                                            <i class="fa-solid fa-check filter-radio__icon"></i>
                                        </span>
                                            ${item.nameSize}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <span class="filter__separate"></span>
                        <div class="filter__group">
                            <span class="filter__title">Màu sắc</span>
                            <div class="filter__color-list">
                                <c:forEach items="${requestScope.colorList}" var="item">
                                    <label class="filter__color-item">
                                        <input name="color" type="checkbox" value="${item.codeColor}"
                                               class="filter__input filter__color"
                                               hidden="hidden">
                                        <span class="filter__color-show" style="background-color: ${item.codeColor}">
                                        </span>
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <button class="filter__submit button--hover button" type="submit">Lọc</button>
                    </form>
                </div>
                <div class="col-9">
                    <div class="product__list">
                        <c:set var="list" value="${requestScope.productCardList}"/>
                        <c:forEach var="item" items="${list}">
                            <div class="product__item">
                                <c:url var="linkProductDetail" value="/showProductDetail">
                                    <c:param name="id" value="${item.id}"/>
                                </c:url>
                                <img src="assets/img/product_img/${item.nameImage}" class="product__img" alt=""/>
                                <div class="product__info">
                                    <a class="product__name" target="_blank"
                                       href="${linkProductDetail}">${item.name}</a>
                                    <div class="product__review">
                                        <div class="product__review-stars">
                                            <c:forEach var="starA" begin="1" step="1" end="${item.star}">
                                                <i class="fa-solid fa-star"></i>
                                            </c:forEach>
                                            <c:forEach var="starB" begin="1" step="1" end="${5 - item.star}">
                                                <i class="fa-regular fa-star"></i>
                                            </c:forEach>
                                        </div>
                                        <a class="product__review-num" target="_blank"
                                           href="${linkProductDetail}">${item.reviews} nhận xét</a>
                                    </div>
                                    <fmt:formatNumber value="${item.originalPrice}" type="currency" currencyCode="VND"
                                                      var="originalPrice"/>
                                    <fmt:formatNumber value="${item.salePrice}" type="currency" currencyCode="VND"
                                                      var="salePrice"/>
                                    <span class="product__price">
                                        <strong class="product__price--sale">
                                                ${salePrice}
                                        </strong>
                                        <strong class="product__price--original">
                                                ${originalPrice}
                                        </strong>
                                    </span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <ul class="paging">
                <c:forEach var="page" begin="1" end="${requestScope.quantityPage}">
                    <c:url var="linkPaing" value="/pagingProduct">

                        <c:param name="page" value="${page}"/>
                    </c:url>
                    <a class="page" href="${linkPaing}">${page}</a>
                </c:forEach>
            </ul>
        </div>
    </section>
</main>
<%@include file="footer.jsp" %>
<%--<script src="js/base.js"></script>--%>
<%--<script src="js/data.js"></script>--%>
<%--<script src="js/paging.js"></script>--%>
<%--<script src="js/productBuying.js"></script>--%>
<%--</body>--%>
</html>