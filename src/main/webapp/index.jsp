<%@ page import="models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="services.HomeServices" %>
<%@ page import="models.Image" %>
<%@ page import="utils.ProductFactory" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="productFactory" class="utils.ProductFactory" scope="session"/>
<html lang="en">
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
    <%--jquery--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="./assets/font/webfonts/Montserrat.css">

    <!--CSS-->
    <link rel="stylesheet" href="./assets/css/reset.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/home.css">

    <title>Trang chủ</title>
</head>
<body>
<!--Header-->
<c:import url="header.jsp" charEncoding="UTF-8"/>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<!--Main: chứa nội dung chính, các section như giới thiệu sản phầm, các cổ đông,...-->
<main id="main">
    <!--Hero-->
    <div class="hero">
        <img src="./assets/img/hero__img.png" alt="" class="hero__img">
        <div class="hero__slogan">
            <h1>Change Your Styles Now</h1>
            <p>Cùng chúng tôi tạo nên thiết kế khác biệt cho quần áo của bạn</p>
            <a href="productBuying.jsp" class="hero__button button button--hover">Bắt đầu đặt may</a>
        </div>
    </div>

    <div class="container-xl">
        <div id="slider__category--section">
            <div class="slider__container">
                <div class="slider__items">
                    <c:forEach items="${requestScope.listSlideShow}" var="slide">
                        <img class="slider__item" src="./assets/img/slider/${slide.nameImage}">
                    </c:forEach>
                </div>
                <div class="navigation__button nav__prev">
                    <i class="fa-solid fa-chevron-left"></i>
                </div>

                <div class="navigation__button nav__next">
                    <i class="fa-solid fa-chevron-right"></i>
                </div>

                <div class="carousel__indicators">
                    <div class="indicator active"></div>
                    <div class="indicator"></div>
                    <div class="indicator"></div>
                    <div class="indicator"></div>
                </div>
            </div>
            <div class="category__container category__items">
                <div class="category__item">
                    <p class="item__text">Áo thun / T-Shirt</p>
                    <img class="item__image" src="./assets/img/category/T-shirt.png">
                </div>
                <div class="category__item">
                    <p class="item__text">Áo hoodie / Hoodie</p>
                    <img class="item__image" src="./assets/img/category/hoodie.png">
                </div>
                <div class="category__item">
                    <p class="item__text">Balo / Backpack</p>
                    <img class="item__image" src="./assets/img/category/backpack.png">
                </div>
                <div class="category__item">
                    <p class="item__text">Quần dài / Pants</p>
                    <img class="item__image" src="./assets/img/category/pants.png">
                </div>
                <div class="category__item">
                    <p class="item__text">Nón / Cap</p>
                    <img class="item__image" src="./assets/img/category/hat.png">
                </div>
            </div>
        </div>
    </div>

    <div class="popular__section container-xl">
        <div class="popular__title">
            <h2 class="section__title">Sản phẩm thịnh hành</h2>
            <a class="see__more" href="trendingProducts">Xem thêm</a>
        </div>
        <div class="product__wrapper">
            <button class="left__button"><i class="fa-solid fa-arrow-left"></i></button>
            <%--            <div class="product__items">--%>
            <%--                <c:forEach items="${requestScope.list6TrendingProducts}" var="trendProduct">--%>
            <%--                    <div class="product__item">--%>
            <%--                        <div class="product__content">--%>
            <%--                            <div class="image--tag">--%>
            <%--                                <img src="./assets/img/product_img/${trendProduct['nameimage']}">--%>
            <%--                                <span class="product__tag">Thịnh hành</span>--%>

            <%--                                <c:url var="atc" value="AddToCart">--%>
            <%--                                    <c:param name="productId" value="${trendProduct['id']}"/>--%>
            <%--                                </c:url>--%>
            <%--                                <form action="${atc}" class="action__bar" method="post">--%>
            <%--                                    <button type="submit" class="add__cart">Thêm vào giỏ hàng <i class="fa-solid fa-cart-shopping"></i></button>--%>
            <%--                                    <a class="see__detail">Xem chi tiết <i class="fa-solid fa-eye"></i></a>--%>
            <%--                                </form>--%>
            <%--                            </div>--%>
            <%--                            <div class="product__info">--%>
            <%--                                <a class="product__name" href="#">${trendProduct["name"]}</a>--%>
            <%--                                <div class="product__review">--%>
            <%--                                    <div class="review__icon">--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                    </div>--%>
            <%--                                    <a class="number__turns--ratting" href="#">1000 nhận xét</a>--%>
            <%--                                </div>--%>
            <%--                                <span class="product__price">--%>
            <%--                                    <fmt:setLocale value="vi_VN"/>--%>
            <%--                                    <c:choose>--%>
            <%--                                        <c:when test="${trendProduct['saleprice'] == null}">--%>
            <%--                                            <strong class="priority__price">--%>
            <%--                                                <fmt:formatNumber value="${trendProduct['originalprice']}" type="currency"/>--%>
            <%--                                            </strong>--%>
            <%--                                        </c:when>--%>
            <%--                                        <c:otherwise>--%>
            <%--                                            <strong class="sale__price">--%>
            <%--                                                <fmt:formatNumber value="${trendProduct['saleprice']}" type="currency"/>--%>
            <%--                                            </strong>--%>
            <%--                                            <s class="original__price">--%>
            <%--                                                <fmt:formatNumber value="${trendProduct['originalprice']}" type="currency"/>--%>
            <%--                                            </s>--%>
            <%--                                        </c:otherwise>--%>
            <%--                                    </c:choose>--%>
            <%--                                </span>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </c:forEach>--%>
            <%--            </div>--%>
            <div class="product__items">
                <c:forEach items="${requestScope.list6TrendingProducts}" var="trendProduct">
                    <c:url var="showProductDetail" value="showProductDetail">
                        <c:param name="id" value="${trendProduct.id}"/>
                    </c:url>
                    <div class="product__item">
                        <div class="product__content">
                            <div class="image--tag">
                                <c:set value="${productFactory.getListImagesByProductId(trendProduct.id)}" var="listTrendProductImages"/>
                                    <%--                                <c:set var="pid" value="${trendProduct.id}"/>--%>
                                    <%--                                <%--%>
                                    <%--                                    int productId = (int) pageContext.getAttribute("pid");--%>
                                    <%--                                    List<Images> listImageProduct = HomeServices.getINSTANCE().getListImageByProductId(productId);--%>
                                    <%--                                %>--%>
                                    <%--                                <img src="./assets/img/product_img/<%= listImageProduct.get(0).getNameImage() %>">--%>
                                <img src="./assets/img/product_img/${listTrendProductImages.get(0).nameImage}">
                                <span class="product__tag">Thịnh hành</span>

                                    <%--                                <c:url var="atc" value="AddToCart">--%>
                                    <%--                                    <c:param name="productId" value="${trendProduct.id}"/>--%>
                                    <%--                                </c:url>--%>
                                <form action="AddToCart" class="action__bar" method="post">
                                    <input type="hidden" name="productId" value="${trendProduct.id}">
                                    <button type="submit" class="add__cart"><i class="fa-solid fa-cart-shopping"></i></button>
                                    <a class="see__detail" target="_blank" href="${showProductDetail}"><i
                                            class="fa-solid fa-eye"></i></a>
                                </form>
                            </div>
                            <div class="product__info">
                                <a class="product__name" target="_blank"
                                   href="${showProductDetail}">${trendProduct.name}</a>
                                <div class="product__review">
                                    <div class="review__icon">
                                        <c:forEach var="starA" begin="1" step="1"
                                                   end="${productFactory.calculateStar(trendProduct.id)}">
                                            <i class="fa-solid fa-star icon__item"></i>
                                        </c:forEach>
                                        <c:forEach var="starB" begin="1" step="1"
                                                   end="${5 - productFactory.calculateStar(trendProduct.id)}">
                                            <i class="fa-regular fa-star icon__item"></i>
                                        </c:forEach>
                                    </div>
                                    <a class="number__turns--ratting" href="${showProductDetail}">${productFactory.getReviewCount(trendProduct.id)} nhận xét</a>
                                </div>
                                <span class="product__price">
                                    <fmt:setLocale value="vi_VN"/>
                                    <c:choose>
                                        <c:when test="${trendProduct.salePrice == null}">
                                            <strong class="priority__price">
                                                <fmt:formatNumber value="${trendProduct.originalPrice}" type="currency"/>
                                            </strong>
                                        </c:when>
                                        <c:otherwise>
                                            <strong class="sale__price">
                                                <fmt:formatNumber value="${trendProduct.salePrice}" type="currency"/>
                                            </strong>
                                            <s class="original__price">
                                                <fmt:formatNumber value="${trendProduct.originalPrice}" type="currency"/>
                                            </s>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="right__button"><i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </div>

    <div class="new__section container-xl">
        <div class="new__title">
            <h2 class="section__title">Sản phẩm mới</h2>
            <a class="see__more" href="newProducts">Xem thêm</a>
        </div>
        <div class="product__wrapper">
            <button class="left__button"><i class="fa-solid fa-arrow-left"></i></button>
            <%--            <div class="product__items">--%>
            <%--                <c:forEach items="${requestScope.list6NewProducts}" var="newProduct">--%>
            <%--                    <div class="product__item">--%>
            <%--                        <div class="product__content">--%>
            <%--                            <div class="image--tag">--%>
            <%--                                <img src="./assets/img/product_img/${newProduct['nameimage']}">--%>
            <%--                                <c:if test="${fn:contains(sessionScope.listAllTrendingProducts, newProduct)}">--%>
            <%--                                    <span class="product__tag">Thịnh hành</span>--%>
            <%--                                </c:if>--%>
            <%--                                <c:url var="atc" value="AddToCart">--%>
            <%--                                    <c:param name="productId" value="${newProduct['id']}"/>--%>
            <%--                                </c:url>--%>
            <%--                                <form class="action__bar" action="${atc}" method="post">--%>
            <%--                                    <button type="submit" class="add__cart">Thêm vào giỏ hàng <i class="fa-solid fa-cart-shopping"></i></button>--%>
            <%--                                    <a href="" class="see__detail">Xem chi tiết <i class="fa-solid fa-eye"></i></a>--%>
            <%--                                </form>--%>
            <%--                            </div>--%>
            <%--                            <div class="product__info">--%>
            <%--                                <a class="product__name" href="#">${newProduct["name"]}</a>--%>
            <%--                                <div class="product__review">--%>
            <%--                                    <div class="review__icon">--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                        <i class="fa-solid fa-star icon__item"></i>--%>
            <%--                                    </div>--%>
            <%--                                    <a class="number__turns--ratting" href="#">1000 nhận xét</a>--%>
            <%--                                </div>--%>
            <%--                                <span class="product__price">--%>
            <%--                                    <fmt:setLocale value="vi_VN"/>--%>
            <%--                                    <c:choose>--%>
            <%--                                        <c:when test="${newProduct['saleprice'] == null}">--%>
            <%--                                            <strong class="priority__price">--%>
            <%--                                                <fmt:formatNumber value="${newProduct['originalprice']}" type="currency"/>--%>
            <%--                                            </strong>--%>
            <%--                                        </c:when>--%>
            <%--                                        <c:otherwise>--%>
            <%--                                            <strong class="sale__price">--%>
            <%--                                                <fmt:formatNumber value="${newProduct['saleprice']}" type="currency"/>--%>
            <%--                                            </strong>--%>
            <%--                                            <s class="original__price">--%>
            <%--                                                <fmt:formatNumber value="${newProduct['originalprice']}" type="currency"/>--%>
            <%--                                            </s>--%>
            <%--                                        </c:otherwise>--%>
            <%--                                    </c:choose>--%>
            <%--                                </span>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </c:forEach>--%>
            <%--            </div>--%>
            <div class="product__items">
                <c:forEach items="${requestScope.list6NewProducts}" var="newProduct">
                    <c:url var="showProductDetail" value="showProductDetail">
                        <c:param name="id" value="${newProduct.id}"/>
                    </c:url>
                    <div class="product__item">
                        <div class="product__content">
                            <div class="image--tag">
                                <c:set value="${productFactory.getListImagesByProductId(newProduct.id)}" var="listNewProductImages"/>
                                <img src="./assets/img/product_img/${listNewProductImages.get(0).nameImage}">
                                <c:if test="${fn:contains(sessionScope.listAllTrendingProducts, newProduct)}">
                                    <span class="product__tag">Thịnh hành</span>
                                </c:if>
                                    <%--                                <c:url var="atc" value="AddToCart">--%>
                                    <%--                                    <c:param name="productId" value="${newProduct.id}"/>--%>
                                    <%--                                </c:url>--%>
                                <form class="action__bar" action="AddToCart" method="post">
                                    <input type="hidden" name="productId" value="${newProduct.id}">
                                    <button type="submit" class="add__cart"><i class="fa-solid fa-cart-shopping"></i></button>
                                    <a class="see__detail" target="_blank" href="${showProductDetail}"><i
                                            class="fa-solid fa-eye"></i></a>
                                </form>
                            </div>
                            <div class="product__info">
                                <a class="product__name" target="_blank"
                                   href="${showProductDetail}">${newProduct.name}</a>
                                <div class="product__review">
                                    <div class="review__icon">
                                        <c:forEach var="starA" begin="1" step="1"
                                                   end="${productFactory.calculateStar(newProduct.id)}">
                                            <i class="fa-solid fa-star icon__item"></i>
                                        </c:forEach>
                                        <c:forEach var="starB" begin="1" step="1"
                                                   end="${5 - productFactory.calculateStar(newProduct.id)}">
                                            <i class="fa-regular fa-star icon__item"></i>
                                        </c:forEach>
                                    </div>
                                    <a class="number__turns--ratting" href="${showProductDetail}">${productFactory.getReviewCount(newProduct.id)} nhận xét</a>
                                </div>
                                <span class="product__price">
                                    <fmt:setLocale value="vi_VN"/>
                                    <c:choose>
                                        <c:when test="${newProduct.salePrice == null}">
                                            <strong class="priority__price">
                                                <fmt:formatNumber value="${newProduct.originalPrice}" type="currency"/>
                                            </strong>
                                        </c:when>
                                        <c:otherwise>
                                            <strong class="sale__price">
                                                <fmt:formatNumber value="${newProduct.salePrice}" type="currency"/>
                                            </strong>
                                            <s class="original__price">
                                                <fmt:formatNumber value="${newProduct.originalPrice}" type="currency"/>
                                            </s>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="right__button"><i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </div>

    <div id="discovery__us--section" class="container-xl">
        <div class="discovery__container">
            <h2 class="section__title">Bạn có thể khám phá được điều gì ở chúng tôi?</h2>
            <div class="discovery__content">
                <div class="disco_thing">
                    <p>50+</p>
                    <p>Mẫu đồ bạn có thể đặt may</p>
                </div>
                <div class="disco_thing">
                    <p>1,000+</p>
                    <p>Khách hàng yêu cầu đặt may mỗi tháng</p>
                </div>

                <div class="disco_thing">
                    <p>50+</p>
                    <p>Mẫu đồ được gia công liên tục</p>
                </div>
            </div>
        </div>
    </div>

    <div class="step__guide--section container-xl">
        <h2 class="section__title">Cách bước để bạn có thể đặt may một mẫu đồ</h2>
        <div class="guide__content row">
            <div class="col">
                <div class="step__item">
                    <img src="assets/img/step_guide/choose.png">
                    <div class="description_step">
                        <span>Bước 1</span>
                        <p>Chọn một mẫu đồ mà bạn ưng ý</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="step__item">
                    <img src="./assets/img/step_guide/customize.png">
                    <div class="description_step">
                        <span>Bước 2</span>
                        <p>Tùy chọn size và kiểu dáng phù hợp với nhu cầu của bạn</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="step__item">
                    <img src="./assets/img/step_guide/checkout.png">
                    <div class="description_step">
                        <span>Bước 3</span>
                        <p>Tiến hành đặt may và thanh toán</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="step__item">
                    <img src="./assets/img/step_guide/receive.png">
                    <div class="description_step">
                        <span>Bước 4</span>
                        <p>Chờ nhận hàng sau khi bạn đã thanh toán thành công</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<!--Footer-->
<%@include file="footer.jsp" %>
<script src="./js/home.js"></script>
<script src="js/base.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
    function addToCartAjax(){
        $(document).ready(function (){
            $('.action__bar').each(function (index, actionBar){
                $(actionBar).on('submit', function (event){
                    event.preventDefault();
                    let userLoggedIn;
                    <c:choose>
                    <c:when test="${sessionScope.auth == null}">
                    userLoggedIn = false
                    </c:when>
                    <c:otherwise>
                    userLoggedIn = true
                    </c:otherwise>
                    </c:choose>
                    if(userLoggedIn === false){
                        window.location.href = "signIn.jsp"
                    }else {
                        const form = $(actionBar);
                        let productId = form.find('input[name="productId"]').val();
                        $.ajax({
                            type: form.attr('method'),
                            url: form.attr('action'),
                            data: {productId: productId},
                            success: function (response) {
                                let addToCartSuccessHTML = `<div class="notification__cart">
                                                                <div class="status__success">
                                                                    <span><i class="fa-solid fa-circle-check icon__success"></i>Đã thêm vào giỏ hàng thành công</span>
                                                                    <span onclick="handleCloseNotificationCart()"><i class="fa-solid fa-xmark close__notification"></i></span>
                                                                </div>
                                                                <a class="view__cart" href="shoppingCart.jsp">Xem giỏ hàng và thanh toán</a>
                                                            </div>`;
                                $('.cart__wrapper').append(addToCartSuccessHTML)
                                $('.qlt__value').text(response);
                            },
                            error: function (error){
                                console.error('Lỗi khi thêm sản phẩm vào giỏ hàng', error);
                            }
                        })
                    }
                })
            })
        })
    }
    addToCartAjax();
</script>
</body>
</html>