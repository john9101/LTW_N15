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
    <link rel="stylesheet" href="../assets/css/contact.css">
    <title>Liên hệ</title>
</head>
<body>
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
                        <a href="./contact.html" class="nav__link">Liên hệ</a>
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
                            <div class="setting__item"><a href="profile.jsp" class="setting__link">Tài khoản
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
        <div class="contact_us row">
            <div class="title_method-contact col">
                <h2>Liên hệ</h2>
                <p>Bạn có muốn liên lạc với chúng tôi? Nếu có thì bạn hãy điền đầy đủ thông tin vào form và chúng sẽ cố gắng phản hồi sớm nhất trong vòng 24h. Hoặc bạn có thể liên hệ với chúng tôi thông qua các phương thức bên dưới</p>
                <div class="get-in-touch">
                    <h2>Phương thức liên hệ</h2>
                    <div class="contact-method">
                        <div class="icon-contact">
                            <i class="fa-solid fa-location-dot"></i>
                        </div>
                        <div class="contact-description">
                            <p>Địa chỉ</p>
                            <p>721 Huỳnh Tấn Phát, Phường Phú Thuận, Quận 7, Tp. Hồ Chí Minh</p>
                        </div>
                    </div>
                    <div class="contact-method">
                        <div class="icon-contact">
                            <i class="fa-solid fa-phone"></i>
                        </div>
                        <div class="contact-description">
                            <p>Số điện thoại</p>
                            <p>0703637448</p>
                        </div>
                    </div>
                    <div class="contact-method">
                        <div class="icon-contact">
                            <i class="fa-solid fa-envelope"></i>
                        </div>
                        <div class="contact-description">
                            <p>Email</p>
                            <p>yourstyle@support.com</p>
                        </div>
                    </div>
                </div>
                <img src="../assets/img/contactus.svg">
            </div>

            <form method="post" id="contact_us-form" class="col">
                <div class="form__block">
                    <label for="fullname" class="form__label">Họ và tên *</label>
                    <input class="form__input" type="text" id="fullname" name="fullname">
                    <span class="error-notice"></span>
                </div>

                <div class="form__block">
                    <label for="email" class="form__label">Email *</label>
                    <input class="form__input" type="email" id="email" name="email">
                    <span class="error-notice"></span>
                </div>

                <div class="form__block">
                    <label for="message" class="form__label">Chúng tôi có thể giúp gì được cho bạn?</label>
                    <textarea id="message" name="message" class="form__textarea" rows="12"></textarea>
                </div>
                <!--                <button class="form__submit">Gửi</button>-->
                <input type="submit" class="form__submit" value="Gửi">
            </form>
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
                        <a href="./contact.html" class="footer__link">Liên hệ</a>
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
<script src="../js/validateContactForm.js"></script>
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
        onSubmit: function (data){
            console.log(data)
        }
    });
</script>
</html>