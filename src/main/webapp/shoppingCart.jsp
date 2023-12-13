<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="assets/css/shoppingCart.css">
    <title>Giỏ hàng</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main id="main">
    <!-- New update template -->
    <div class="promotion__modal">
        <div class="promotion__sidebar">
            <div class="promotion__header">
                <i class="fa-solid fa-arrow-left"></i>
                <span>Mã giảm giá</span>
            </div>
            <div class="promotion__content">
                <c:forEach items="${requestScope.listVouchers}" var="voucher">
                    <div class="promotion__item">
                        <div class="discount__percent">
                            <i class="fa-solid fa-fire"></i>
                            <span><fmt:formatNumber type="percent" value="${voucher.discountPercent}"/></span>
                        </div>
                        <div class="item__content">
                            <h1 class="promotion__text">NHẬP MÃ: ${voucher.code}</h1>
                            <p>HSD: <fmt:formatDate pattern="dd-MM-yyyy" value="${voucher.expiryDate}"/></p>
                            <p class="promotion__description">${voucher.description} <fmt:setLocale value="vi_VN"/> <fmt:formatNumber type="currency" value="${voucher.minimumPrice}"/> </p>
                            <button class="button__copy" data-code="${voucher.code}">Sao chép <i class="fa-solid fa-copy"></i></button>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="promotion__footer">
                <button>Quay lại giỏ hàng</button>
            </div>
        </div>
    </div><!-- New update template -->

    <div class="container-xl">
        <h1 class="cart__title">Giỏ hàng</h1>
        <div class="cart__container row">
            <div class="cart__content col">
                <div>
                    <!-- New remove  -->
                    <!-- <div id="cart__header" class="grid__cart--template">
                        <span>Sản phẩm</span>
                        <span>Giá may</span>
                        <span>Số lượng</span>
                        <span>Thành tiền</span>
                        <span>Xóa</span>
                    </div>
                    <div class="cart__items">

                    </div> --> <!-- New remove  -->

                    <table id="cart__table">
                        <thead class="cart__header">
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Giá may</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th>Xóa</th>
                        </tr>
                        </thead>
                        <tbody class="cart__items">
                        <tr>

                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- New update template -->
                <div class="order__note">
                    <label for="area__note">Ghi chú đơn hàng</label>
                    <textarea id="area__note" rows="6" name="area__note" placeholder="Ghi chú"></textarea>
                </div><!-- New update template -->
            </div>
            <div class="invoice__promotion col">
                <div class="apply__promotion">
                    <h2>Khuyến mãi</h2>
                    <form id="promotion__form" action="" method="get">
                        <!-- New update template -->
                        <div class="promotion__all">
                            <span><i class="fa-solid fa-ticket-simple"></i> Mã giảm giá</span>
                            <span>Xem tất cả <i class="fa-solid fa-chevron-right"></i></span>
                        </div><!-- New update template -->
                        <div>
                            <input type="text" name="promotion__code" id="promotion_code">
                            <input type="submit" name="apply" value="Áp dụng" id="apply">
                        </div>
                        <div class="apply__status"></div>
                    </form>
                </div>
                <div class="summary__invoice">
                    <h2>Tổng đơn hàng</h2>
                    <div class="invoice__detail--info">
                        <ul class="price__items">
                            <li class="price__item">
                                <p class="price__text"></p>
                                <p class="price__value"></p>
                            </li>
                            <li class="price__item">
                                <p class="price__text">Giảm giá <i class="icon__info fa-solid fa-circle-info"></i> <span class="discount__note"></span></p>
                                <p class="price__value"></p>
                            </li>
                        </ul>
                        <div class="price__total">
                            <p class="price__text">Tổng tiền</p>
                            <div class="price__content">
                                <p class="price__value--final"></p>
                                <p class="price__value--noted">(Đã bao gồm VAT nếu có)</p>
                            </div>
                        </div>
                    </div>
                </div>
                <span>Phí vận chuyển sẽ được tính ở trang thanh toán</span>
                <div class="group__button--forward">
                    <a href="checkout.jsp">
                        <button id="continue--checkout">Tiến hành thanh toán</button>
                    </a>
                    <a href="productBuying.jsp">
                        <button id="continue--shopping">Tiến tục mua sắm</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="footer.jsp"%>
</body>
<script src="js/base.js"></script>
<script src="js/validateContactForm.js"></script>
<script>
    ValidatorContactForm({
        form: '#contact_us-form',
        formBlockSelector: '.form__block',
        errorSelector: '.error-notice',
        rules: [
            ValidatorContactForm.isRequired('#fullname'),
            ValidatorContactForm.isRequired('#email'),
            ValidatorContactForm.isEmail('#email')
        ],
        onSubmit: function (data) {
            console.log(data)
        }
    });
</script>
<script src="js/data.js"></script>
<script src="js/checkout.js"></script>
<script src="js/shoppingCart.js"></script>
</html>