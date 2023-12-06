<%@page contentType  = "text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Các thư viện hỗ trợ-->
    <!--Font Awesome-->
    <link rel="stylesheet" href="../assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">

    <!--Bootstrap-->
    <link rel="stylesheet" href="../assets/bootstrap/bootstrap-grid.min.css">
    <!--Favicon-->
    <link rel="apple-touch-icon" sizes="180x180" href="../assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="../assets/favicon/site.webmanifest">
    <!--Web font-->
    <link rel="stylesheet" href="../assets/font/webfonts/Montserrat.css">

    <!--CSS-->
    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/checkout.css">

    <title>Thanh toán</title>
</head>
<body>
<!--Header nơi chứa navigation-->
<header id="header">
    <nav class="nav">
        <div class="container-xl">
            <div class="nav__inner">
                <a href="../index.jsp" class="logo">
                </a>
                <ul class="nav__list">
                    <li class="nav__item">
                        <a href="../index.jsp" class="nav__link">Trang chủ</a>
                    </li>
                    <li class="nav__item">
                        <a href="productBuying.jsp" class="nav__link">Gian hàng</a>
                    </li>
                    <li class="nav__item">
                        <a href="contact.jsp" class="nav__link">Liên hệ</a>
                    </li>
                    <li class="nav__item">
                        <a href="about.jsp" class="nav__link">Về chúng tôi</a>
                    </li>
                </ul>
                <!--cta == call to action-->
                <div class="nav__cta">
                    <a href="signIn.jsp" class="nav__button nav__button--signIn">Đăng nhập</a>
                    <a href="signUp.jsp"
                       class="nav__button nav__button--signUp button button button--hover">Đăng ký</a>
                </div>
                <!--Account show (After log in success)-->
                <div class="account__wrapper">
                    <!--Giỏ hàng-->
                    <a href="shoppingCart.jsp" class="cart">
                        <i class="cart__icon  fa-solid fa-cart-shopping"></i>
                    </a>

                    <div class="account">
                        <i class="account__icon fa-regular fa-user"></i>
                        <div class="setting__list">
                            <div class="setting__item"><a href="#!" class="setting__link">
                                <div class="account__info">
                                    <i class="account__icon fa-regular fa-user"></i>
                                    <p class="account__name"></p>
                                </div>
                            </a></div>
                            <div class="setting__item"><a href="#!" class="setting__link">Đơn mua</a></div>
                            <div class="setting__item"><a href="account.jsp" class="setting__link">Tài khoản
                                                                                                   của tôi</a>
                            </div>
                            <div class="setting__item "><a href="#!" class="setting__link setting__logOut">Đăng
                                xuất</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<!--Main: chứa nội dung chính, các section như giới thiệu sản phầm, các cổ đông,...-->
<main id="main">
    <div class="container-xl">
        <div class="checkout__container row">
            <div class="checkout__info--left col">
                <div class="delivery__info--container">
                    <h1 class="checkout__title">Thanh toán</h1>
                    <h2 class="checkout__subtitle">Chọn thông tin giao hàng</h2>
                    <span class="non__selected">Vui lòng chọn thông tin giao hàng</span>
                    <form id="delivery__info--form" class="radio__section">
                        <div class="delivery__default section__info--selection">
                            <input type="radio" name="default__selection" class="radio__button"
                                   value="default__selection"
                                   id="default__selection">
                            <label class="label__selection" for="default__selection">
                                <ul class="info__items">
                                    <li class="info__item">Họ và tên: Cáp Hữu Ðạt</li>
                                    <li class="info__item">Email: HuuDat@gmail.com</li>
                                    <li class="info__item">Số điện thoại: 0328012964</li>
                                    <li class="info__item">Địa chỉ: Xã Vĩnh Thạnh Trung, Huyện Châu Phú, An Giang</li>
                                </ul>
                            </label>
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
                <div class="payment__method--container">
                    <h2 class="checkout__subtitle">Phương thức thanh toán</h2>
                    <span class="non__selected">Vui lòng chọn phương thức thanh toán</span>
                    <form id="payment__method--form" class="radio__section">
                        <div class="method__item section__info--selection">
                            <input type="radio" name="payment__method" class="radio__button" value="payment__method"
                                   id="cash">
                            <label class="label__selection" for="cash">Thanh toán tiền mặt khi nhận hàng</label>
                        </div>
                        <div class="method__item section__info--selection">
                            <input type="radio" name="payment__method" class="radio__button" value="bank" id="bank">
                            <label class="label__selection" for="bank">Thanh toán qua atm nội địa / internet
                                banking</label>
                        </div>
                        <div class="method__item section__info--selection">
                            <input type="radio" name="payment__method" class="radio__button" value="e-wallet"
                                   id="e-wallet">
                            <label class="label__selection" for="e-wallet">Thanh toán qua ví điện tử</label>
                        </div>
                    </form>
                </div>
            </div>
            <div class="checkout__info--right col">
                <div class="order__detail--info">
                    <table class="order__table">
                        <tr class="row__header">
                            <th class="thead__item"></th>
                            <th class="thead__item">Sản phầm</th>
                            <th class="thead__item">Số lượng</th>
                            <th class="thead__item">Đơn giá</th>
                        </tr>
                    </table>
                </div>
                <div class="invoice--final">
                    <div class="total__price--final">
                        <u class="total__label">Tổng tiền</u>:
                        <span class="total__value"></span>
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
<!--Footer: chứa các thẻ a link đến các mục khác như contact, license, thông tin địa chỉ, giờ làm việc,...-->
<footer id="footer">
    <div class="container-xl">
        <a href="../index.jsp" class="logo"></a>
        <div class="row">
            <div class="col ">
                <div class="footer__block">
                    <p class="footer__title">Giờ làm việc</p>
                    <p class="footer__desc">9:00 - 17:00</p>
                </div>

                <div class="footer__block">
                    <p class="footer__title">Địa chỉ</p>
                    <a target="_blank" href="https://maps.app.goo.gl/RETcqrjaKeqTCfBE6" class="footer__desc">721 Huỳnh
                        Tấn Phát,
                        Phường
                        Phú Thuận, Quận 7, Tp. Hồ
                        Chí Minh</a></div>
            </div>
            <div class="col">
                <ul class="footer__block">
                    <li class="footer__desc">
                        <a href="productBuying.jsp" class="footer__link">Gian hàng</a>
                    </li>
                    <li class="footer__desc">
                        <a href="contact.jsp" class="footer__link">Liên hệ</a>
                    </li>
                    <li class="footer__desc">
                        <a href="about.jsp" class="footer__link">Về chúng tôi</a>
                    </li>
                    <li class="footer__desc">
                        <a href="policy.jsp" class="footer__link">Chính sách mua hàng</a>
                    </li>
                </ul>
            </div>
            <div class="col">
                <div class="footer__block">
                    <div class="footer__title">Kết nối với chúng tôi thông qua</div>
                    <div class="footer__block social__list">
                        <a href="#!" class="social__item">
                            <i class="social__item-icon fa-brands fa-facebook-f"></i>
                        </a>
                        <a href="#!" class="social__item">
                            <i class="social__item-icon fa-brands fa-x-twitter"></i>
                        </a>
                        <a href="#!" class="social__item">
                            <i class="social__item-icon fa-brands fa-instagram"></i>
                        </a>
                        <a href="#!" class="social__item">
                            <i class="social__item-icon fa-brands fa-linkedin-in"></i>
                        </a>
                    </div>

                    <div class="footer__block">
                        <p class="footer__title">Nhận thêm thông tin thông qua</p>
                        <form action="#" class="footer__form">
                            <input placeholder="Email" type="email" class="footer__input" required>
                            <button type="submit" class="footer__submit button button--hover">
                                <i class="footer__submit-icon fa-regular fa-paper-plane"></i>
                                Gửi
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
<script src="../js/base.js"></script>
<script src="../js/shoppingCart.js"></script>
<script src="../js/checkout.js"></script>
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
