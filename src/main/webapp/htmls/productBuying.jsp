<%@page contentType  = "text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
    <link rel="stylesheet" href="../assets/css/productBuying.css">
    <title>Gian hàng</title>
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
                        <a href="./productBuying.html" class="nav__link">Gian hàng</a></li>
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
                    <a href="signUp.jsp" class="nav__button nav__button--signUp button button button--hover">Đăng ký</a>
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
                            <div class="setting__item"><a href="account.jsp" class="setting__link">
                                <div class="account__info">
                                    <i class="account__icon fa-regular fa-user"></i>
                                    <p class="account__name"></p>
                                </div>
                            </a></div>
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
<main class="main">
    <section class="products">
        <div class="container-xl">
            <div class="row">
                <div class="col-3">
                    <aside class="categories">
                        <ul id="category-list" class="category__list">
                            <!--                            <li class="category__item">Ao khoac</li>-->
                            <!--                            <li class="category__item">Quan kaki</li>-->
                            <!--                            <li class="category__item">Ao so mi</li>-->
                            <!--                            <li class="category__item">Ao tay ngan</li>-->
                            <!--                            <li class="category__item">AO tay dai</li>-->
                        </ul>
                    </aside>
                </div>
                <div class="col-9">
                    <form action="#!" id="search-form" class="search__form">
                        <input type="text" autocomplete="off" id="search-input" class="search__input"
                               placeholder="Nhập sản phẩm bạn muốn tìm tại đây.">
                        <button type="button" id="search-button" class="search__button button button--hover"><i
                                class="search__icon fa-solid fa-magnifying-glass"></i>Tìm kiếm
                        </button>
                        <div class="result-box"></div>
                    </form>
                </div>
            </div>
            <div class="row ">
                <div class="product__list"></div>
            </div>
            <ul class="paging">
            </ul>
        </div>
    </section>
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
                                                                                                             Phú Thuận,
                                                                                                             Quận 7, Tp.
                                                                                                             Hồ
                                                                                                             Chí
                                                                                                             Minh</a>
                </div>
            </div>
            <div class="col">
                <ul class="footer__block">
                    <li class="footer__desc">
                        <a href="./productBuying.html" class="footer__link">Gian hàng</a>
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
<script src="../js/paging.js"></script>
<script src="../js/productBuying.js"></script>
</body>
</html>