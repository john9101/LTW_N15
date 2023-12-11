<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Các thư viện hỗ trợ-->
    <!--Font Awesome-->
    <link rel="stylesheet" href="./assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">

    <!--Bootstrap-->
    <link rel="stylesheet" href="./assets/bootstrap/bootstrap-grid.min.css">
    <!--Favicon-->
    <link rel="apple-touch-icon" sizes="180x180" href="./assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assets/favicon/site.webmanifest">
    <!--Web font-->

    <link rel="stylesheet" href="./assets/font/webfonts/Montserrat.css">

    <!--CSS-->
    <link rel="stylesheet" href="./assets/css/reset.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="assets/css/trendingNewProducts.css">
    <title>Sản phẩm thịnh hành</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main id="main">
    <div class="popular__section container-xl">
        <h2 class="section__title">Sản phẩm thịnh hành</h2>
        <div class="product__items">
            <c:forEach items="${requestScope.listProductsPerPage}" var="trendProduct">
                <div class="product__item">
                    <div class="product__content">
                        <img src="./assets/img/product_img/${trendProduct['nameimage']}">
                        <div class="product__info">
                            <span class="product__status">Thịnh hành</span>
                            <a class="product__name" href="#">${trendProduct["name"]}</a>
                            <div class="product__review">
                                <div class="review__icon">
                                    <i class="fa-solid fa-star icon__item"></i>
                                    <i class="fa-solid fa-star icon__item"></i>
                                    <i class="fa-solid fa-star icon__item"></i>
                                    <i class="fa-solid fa-star icon__item"></i>
                                    <i class="fa-solid fa-star icon__item"></i>
                                </div>
                                <a class="number__turns--ratting" href="#">1000 nhận xét</a>
                            </div>
                            <span class="product__price"><strong class="sale__price"><fmt:setLocale
                                    value="vi_VN"/> <fmt:formatNumber
                                    value="${trendProduct['saleprice']}" type="currency"/></strong>
                                    <s class="original__price"><fmt:formatNumber
                                            value="${trendProduct['originalprice']}"
                                            type="currency"/></s></span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <c:set value="${requestScope.page}" var="page"></c:set>
        <div class="pagination">
            <c:if test="${page > 1}">
                <c:url var="prevURLPage" value="trendingProducts">
                    <c:param name="page" value="${page - 1}"></c:param>
                </c:url>
                <a href="${prevURLPage}" class="previous__page"><i class="fa-solid fa-chevron-left"></i></a>
            </c:if>
            <c:forEach begin="${1}" end="${requestScope.totalPage}" var="i">
                <c:url var="trURLPage" value="trendingProducts">
                    <c:param name="page" value="${i}"></c:param>
                </c:url>
                <a class="${i == page ? "active" : "page__forward"}" href="${trURLPage}">${i}</a>
            </c:forEach>
            <c:if test="${page < requestScope.totalPage}">
                <c:url var="nextURLPage" value="trendingProducts">
                    <c:param name="page" value="${page + 1}"></c:param>
                </c:url>
                <a href="${nextURLPage}" class="next__page"><i class="fa-solid fa-chevron-right"></i></a>
            </c:if>

        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>
</body>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function (){--%>
<%--        function fetchData(pageNumber){--%>
<%--            $.ajax({--%>
<%--                type: "GET",--%>
<%--                url: "trendingProducts?page=" + pageNumber,--%>
<%--                data: "json",--%>
<%--                success: function (respone) {--%>
<%--                    displayData(respone);--%>
<%--                }--%>
<%--            })--%>
<%--        }--%>
<%--    })--%>
<%--</script>--%>
</html>
