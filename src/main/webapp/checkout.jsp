<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="assets/css/checkout.css">

    <title>Thanh toán</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main id="main">
    <div class="container-xl">
        <div class="checkout__container row">
            <div class="checkout__info--left col">
                <div class="delivery__info--container">
                    <h1 class="checkout__title">Thanh toán</h1>
                    <h2 class="checkout__subtitle">Thông tin giao hàng</h2>
                    <span class="non__selected">Vui lòng chọn thông tin giao hàng</span>
                    <form id="delivery__info--form" class="radio__section">
                        <div>
                            <div class="delivery__default section__info--selection">
                                <input type="radio" name="default__selection" class="radio__button"
                                       value="default__selection"
                                       id="default__selection">
                                <label class="label__selection" for="default__selection">Sử dụng thông tin mặc định khi nhận hàng</label>
                            </div>
                            <ul class="info__items">
                                <li class="info__item">Họ và tên: Cáp Hữu Ðạt</li>
                                <li class="info__item">Email: HuuDat@gmail.com</li>
                                <li class="info__item">Số điện thoại: 0328012964</li>
                                <li class="info__item">Địa chỉ: Xã Vĩnh Thạnh Trung, Huyện Châu Phú, An Giang</li>
                            </ul>
                        </div>
                        <div class="delivery__other">
                            <div class="section__info--selection">
                                <input type="radio" name="default__selection" class="radio__button"
                                       value="other__selection"
                                       id="other__selection">
                                <label class="label__selection" for="other__selection">Sử dụng thông tin khác khi nhận
                                    hàng</label>
                            </div>
                        </div>
                    </form>
                    <form id="customize__info--form">
                        <div class="customize__item">
                            <label for="full__name" class="input__text">Họ và tên *</label>
                            <input type="text" name="full__name" class="input__content" id="full__name">
                            <span class="error__notice"></span>
                        </div>
                        <div class="customize__item">
                            <label for="email" class="input__text">Email *</label>
                            <input type="text" name="email" class="input__content" id="email">
                            <span class="error__notice"></span>
                        </div>
                        <div class="customize__item">
                            <label for="phone" class="input__text">Số điện thoại *</label>
                            <input type="text" name="phone" class="input__content" id="phone">
                            <span class="error__notice"></span>
                        </div>
                        <div class="customize__item">
                            <label for="address" class="input__text">Địa chỉ *</label>
                            <textarea class="textarea__content" name="address" id="address" rows="10"></textarea>
                            <span class="error__notice"></span>
                        </div>
                        <input type="submit" class="register__address" value="Đăng ký địa chỉ giao hàng">
                    </form>
                </div>

                <!-- New update template -->
                <c:set var="freeShip" value="5000000"/>
                <c:choose>
                    <c:when test="${sessionScope.cart.getTotalPrice() >= freeShip}">
                        <p class="free__ship"><i class="fa-solid fa-circle-check"></i>Miễn phí vận chuyển cho hóa đơn từ <fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${freeShip}" type="currency"/></p>
                    </c:when>
                    <c:otherwise>
                        <div class="delivery__method--container">
                            <h2 class="checkout__subtitle">Phương thức vận chuyển</h2>
                            <span class="non__selected">Vui lòng chọn phương thức vận chuyển</span>
                            <form id="delivery__method--form" class="radio__section">
                                <c:forEach items="${requestScope.listInfoShipping}" var="infoShipping">
                                    <div class="method__content">
                                        <div class="method__item section__info--selection">
                                            <input type="radio" name="delivery__method" class="radio__button" value="${infoShipping.id}"
                                                   id="method__shipping${infoShipping.id}">
                                            <label class="label__selection" for="method__shipping${infoShipping.id}">
                                                <span>${infoShipping.typeShipping}</span>
                                                <span><fmt:setLocale value="vi_VN"/><fmt:formatNumber type="currency" value="${infoShipping.shippingFee}"/></span>
                                            </label>
                                        </div>
                                        <span><p>${infoShipping.description}</p></span>
                                    </div>
                                </c:forEach>
                                    <%--                        <div class="method__content">--%>
                                    <%--                            <div class="method__item section__info--selection">--%>
                                    <%--                                <input type="radio" name="delivery__method" class="radio__button" value="uban__suburbs"--%>
                                    <%--                                       id="uban__suburbs">--%>
                                    <%--                                <label class="label__selection" for="uban__suburbs">--%>
                                    <%--                                    <span>Nội thành / ngoại thành </span>--%>
                                    <%--                                    <span>22.000 ₫</span>--%>
                                    <%--                                </label>--%>
                                    <%--                            </div>--%>
                                    <%--                            <span>--%>
                                    <%--                                <ul>--%>
                                    <%--                                    <li>Nội thành TP.HCM bao gồm: Quận 1, Quận 3, Quận 4, Quận 5, Quận 6, Quận 7, Quận 8, Quận 10, Quận 11, Quận Tân Bình, Quận Gò Vấp, Quận Bình Thạnh, Quận Tân Phú, Quận Phú Nhuận</li>--%>
                                    <%--                                    <li>Ngoại thành TP.HCM bao gồm: Thủ Đức, Quận 12, Quận Bình Tân</li>--%>
                                    <%--                                </ul>--%>
                                    <%--                            </span>--%>
                                    <%--                        </div>--%>

                                    <%--                        <div class="method__content">--%>
                                    <%--                            <div class="method__item section__info--selection">--%>
                                    <%--                                <input type="radio" name="delivery__method" class="radio__button" value="district__commune" id="district__commune">--%>
                                    <%--                                <label class="label__selection" for="district__commune">--%>
                                    <%--                                    <span>Huyện, xã</span>--%>
                                    <%--                                    <span>30.000 ₫</span>--%>
                                    <%--                                </label>--%>
                                    <%--                            </div>--%>
                                    <%--                            <span><p>Huyện, xã TP.HCM bao gồm: Huyện Nhà Bè, Huyện Bình Chánh, Huyện Hóc Môn, Huyện Củ Chi</p></span>--%>
                                    <%--                        </div>--%>
                                    <%--                        <div class="method__content">--%>
                                    <%--                            <div class="method__item section__info--selection">--%>
                                    <%--                                <input type="radio" name="delivery__method" class="radio__button" value="other__district"--%>
                                    <%--                                       id="other__district">--%>
                                    <%--                                <label class="label__selection" for="other__district">--%>
                                    <%--                                    <span>Các tỉnh thành khác</span>--%>
                                    <%--                                    <span>37.000 ₫</span>--%>
                                    <%--                                </label>--%>
                                    <%--                            </div>--%>
                                    <%--                            <span><p>Các tỉnh thành khác: Cần Thơ, Đà Nẵng, Bến Tre,...</p></span>--%>
                                    <%--                        </div>--%>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
                <!-- New update template -->
                <div class="payment__method--container">
                    <h2 class="checkout__subtitle">Phương thức thanh toán</h2>
                    <span class="non__selected">Vui lòng chọn phương thức thanh toán</span>
                    <form id="payment__method--form" class="radio__section">
                        <c:forEach items="${requestScope.listPaymentMethod}" var="paymentMethod">
                            <div class="method__item section__info--selection">
                                <input type="radio" name="payment__method" class="radio__button" value="payment__method"
                                       id="payment__method${paymentMethod.id}">
                                <label class="label__selection" for="payment__method${paymentMethod.id}">${paymentMethod.typeMethod}</label>
                            </div>
                        </c:forEach>
<%--                        <div class="method__item section__info--selection">--%>
<%--                            <input type="radio" name="payment__method" class="radio__button" value="payment__method"--%>
<%--                                   id="cash">--%>
<%--                            <label class="label__selection" for="cash">Thanh toán tiền mặt khi nhận hàng</label>--%>
<%--                        </div>--%>
<%--                        <div class="method__item section__info--selection">--%>
<%--                            <input type="radio" name="payment__method" class="radio__button" value="bank" id="bank">--%>
<%--                            <label class="label__selection" for="bank">Thanh toán qua atm nội địa / internet--%>
<%--                                banking</label>--%>
<%--                        </div>--%>
<%--                        <div class="method__item section__info--selection">--%>
<%--                            <input type="radio" name="payment__method" class="radio__button" value="e-wallet"--%>
<%--                                   id="e-wallet">--%>
<%--                            <label class="label__selection" for="e-wallet">Thanh toán qua ví điện tử</label>--%>
<%--                        </div>--%>
                    </form>
                </div>
            </div>
            <div class="checkout__info--right col">
                <span class="summary__cart">Tóm tắt giỏ hàng</span>
                <div class="order__detail--info">
                    <table class="order__table">
                        <thead>
                            <tr class="row__header">
                                <th class="thead__item">Sản phầm</th>
                                <th class="thead__item">Số lượng</th>
                                <th class="thead__item">Đơn giá</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.cart.shoppingCartMap.keySet()}" var="productId">
                            <c:forEach items="${sessionScope.cart.shoppingCartMap.get(productId)}" var="cartProduct">
                                <tr class="row__content">
                                    <td class="td__item">
                                        <div class="product__item">
                                            <c:set var="listImagesProduct" value="${productFactory.getListImagesByProductId(productId)}"/>
                                            <img src='assets/img/product_img/${listImagesProduct.get(0).nameImage}'>
                                            <div class="order__product--info">
                                                <p class="product__name">${cartProduct.product.name}</p>
                                                <p class="order__color">Màu sắc: ${cartProduct.color.codeColor}</p>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="td__item">${cartProduct.quantity}</td>
                                    <td class="td__item">${cartProduct.sewingPriceFormat()}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="invoice--final">
                    <div class="invoice__content">
                        <div class="price__item--detail">
                            <div>
                                <span>Tạm tính (${sessionScope.cart.getTotalItems()} sản phẩm)</span>
                                <span>${sessionScope.cart.temporaryPriceFormat()}</span>
                            </div>
                            <c:if test="${sessionScope.cart.voucherApplied != null}">
                                <div>
                                    <span>Giảm giá</span>
                                    <span>${sessionScope.cart.discountPriceFormat()}</span>
                                </div>
                            </c:if>
                            <div>
                                <span>Phí vận chuyển</span>
                                <span></span>
                            </div>
                        </div>
                        <div class="total__price--final">
                            <span class="total__label">Tổng tiền</span>
                            <span class="total__value">${sessionScope.cart.totalPriceFormat()}</span>
                        </div>
                    </div>
                    <div class="ground__button--forward">
                        <button class="place__order">Đặt hàng</button>
                        <a href="shoppingCart.jsp">
                            <button class="back--shopping__cart">Quay lại giỏ hàng</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</main>
<%@include file="footer.jsp" %>
</body>
<script src="js/base.js"></script>
<script src="js/checkout.js"></script>
<script>
    ValidatorCustomizeDeliveryForm({
        form: '#customize__info--form',
        formBlockSelector: '.customize__item',
        errorSelector: '.error__notice',
        rules: [
            ValidatorCustomizeDeliveryForm.isRequired('#full__name'),
            ValidatorCustomizeDeliveryForm.isRequired('#phone'),
            ValidatorCustomizeDeliveryForm.isPhone('#phone'),
            ValidatorCustomizeDeliveryForm.isRequired('#address'),
            ValidatorCustomizeDeliveryForm.isRequired('#email'),
            ValidatorCustomizeDeliveryForm.isEmail('#email')
        ],
        onSubmit: function (dataInput) {
            const otherDeliveryLabelElement = document.querySelector('label[for="other__selection"]');
            otherDeliveryLabelElement.innerHTML = `<ul class="info__items">
                                                      <li class="info__item">Họ và tên: ${dataInput['full__name']}</li>
                                                        <li class="info__item">Email: ${dataInput['email']}</li>
                                                        <li class="info__item">Số điện thoại: ${dataInput['phone']}</li>
                                                        <li class="info__item">Địa chỉ: ${dataInput['address']}</li>
                                                   </ul>`;
        }
    });
</script>
</html>

