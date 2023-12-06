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
    <link rel="stylesheet" href="../assets/bootstrap/bootstrap-grid.min.css">
    <link rel="stylesheet" href="../assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">
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
    <link rel="stylesheet" href="../assets/css/review.css">
    <title>Đánh giá</title>
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
                        <a href="./htmls/productBuying.html" class="nav__link">Gian hàng</a></li>
                    <li class="nav__item">
                        <a href="./htmls/contact/html" class="nav__link">Liên hệ</a>
                    </li>
                    <li class="nav__item">
                        <a href="./htmls/about.html" class="nav__link">Về chúng tôi</a>
                    </li>
                </ul>
                <!--cta == call to action-->
                <div class="nav__cta">
                    <a href="./htmls/signIn.html" class="nav__button nav__button--signIn">Đăng nhập</a>
                    <a href="./htmls/signUp.html"
                       class="nav__button nav__button--signUp button button button--hover">Đăng ký</a>
                </div>
                <!--Account show (After log in success)-->
                <div class="account__wrapper">
                    <!--Giỏ hàng-->
                    <div class="cart">
                        <i class="cart__icon  fa-solid fa-cart-shopping"></i>
                        <ul class="cart__list">
                            <li class="cart__item"></li>
                            <li class="cart__item"></li>
                            <li class="cart__item"></li>
                        </ul>
                    </div>

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
                            <div class="setting__item"><a href="./htmls/profile.html" class="setting__link">Tài khoản
                                                                                                            của
                                                                                                            tôi</a>
                            </div>
                            <div class="setting__item "><a href="#!" class="setting__link setting__logOut">Đăng
                                                                                                           xuất</a></d>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <section class="review">
            <h1>Đánh giá sản phẩm</h1>
            <div class="row">
                <div class="col-6">
                    <article class="product">
                        <div class="product__img">
                            <img src="../assets/img/product_img/product21.jpg" alt="">
                        </div>
                        <div class="product__info">
                            <h2 class="product__name"></h2>
                            <p class="product__category">Phân loại: </p>
                            <p class="product__color">Màu
                                <span class="color__code"></span>
                            </p>
                            <p class="product__size">Kích thước:
                                <span class="product__size--default"></span></p>
                            <ul class="product__size--custom">
<!--                                <li>-->
<!--                                    Dài áo:-->
<!--                                </li>-->
<!--                                <li>-->
<!--                                    Ngang ngực:-->
<!--                                </li>-->
<!--                                <li>-->
<!--                                    Dài tay:-->
<!--                                </li>-->
<!--                                <li>-->
<!--                                    Rộng vai:-->
<!--                                </li>-->
                            </ul>
                            <p class="product__quantity">
                                Số lượng:
                            </p>
                        </div>
                    </article>
                </div>
                <div class="col-6">
                    <form class="review__form">
                        <!--                        <h2 class="review__name">-->
                        <!--                            &lt;!&ndash;User info: name&ndash;&gt;Lê Anh Đức-->
                        <!--                        </h2>-->

                        <!--Rating-->
                        <div class="review__rating">
                            <p>Chất lượng sản phẩm</p>
                            <ul class="review__stars">
                                <li class="review__star review__star--choose"></li>
                                <li class="review__star review__star--choose"></li>
                                <li class="review__star review__star--choose"></li>
                                <li class="review__star review__star--choose"></li>
                                <li class="review__star review__star--choose"></li>
                            </ul>
                            <p>Tệ</p>
                        </div>

                        <!--Desc-->
                        <label class="review__desc">
                            Đánh giá
                            <textarea></textarea>
                        </label>
                        <button class="review__submit button button--hover">
                            Hoàn thành
                        </button>
                    </form>
                </div>
            </div>
        </section>
    </div>
</main>
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
                    <a href="https://maps.app.goo.gl/RETcqrjaKeqTCfBE6" class="footer__desc">721 Huỳnh Tấn Phát,
                                                                                             Phường
                                                                                             Phú Thuận, Quận 7, Tp.
                                                                                             Hồ Chí Minh</a></div>
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
<script src="../js/base.js"></script>
<script src="../js/data.js"></script>
<script src="../js/review.js"></script>
</body>
</html>