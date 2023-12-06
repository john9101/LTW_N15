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

    <link rel="stylesheet" href="../assets/bootstrap/bootstrap-grid.min.css">
    <link rel="stylesheet" href="../assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="manifest" href="../assets/favicon/site.webmanifest">
    <link rel="stylesheet" href="../assets/font/webfonts/Montserrat.css">
    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet" href="../assets/css/base.css">

    <link rel="stylesheet" href="../assets/css/account.css">
    <title>Tài khoản</title>
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
                        <a href="#!" class="nav__link">Giang hàng</a></li>
                    <li class="nav__item">
                        <a href="#!" class="nav__link">Liên hệ</a>
                    </li>
                    <li class="nav__item">
                        <a href="#!" class="nav__link">Về chúng tôi</a>
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
                            <div class="setting__item"><a href="#!" class="setting__link">Tài khoản của tôi</a></div>
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
<main class="main">
    <div class="container-xl">
        <div class="row">
            <div class="col-3">
                <ul class="service__list">
                    <li class="service__item service__item--clicked ">Chỉnh sửa tài khoản</li>
                    <li class="service__item">Đổi mật khẩu</li>
                    <li class="service__item">Lịch sử mua hàng</li>
                </ul>
            </div>
            <div class="col-9">
                <section class="service__section service__section--show">
                    <h1 class="title">Chỉnh sửa tài khoản</h1>
                    <div class="user__maininfo block_info">
                        <div class="user__img user">
                            <img src="../assets/img/product_img/product21.jpg" id="photo">
                            <input type="file" id="file">
                            <label for="file" id="uploadbtn" class="fas fa-camera"></label>
                        </div>
                        <div class="user__info user">
                            <div class="user__info--name info-compo">
                                <div class="lable__name lable-compo">
                                    <label for="Username">Tên người dùng</label>
                                </div>
                                <input type="text" id="Username" class=" input-compo">
                            </div>
                            <div class="user__info--email info-compo">
                                <div class="lable__email lable-compo">
                                    <label for="Email">Email</label>
                                </div>
                                <input type="email" id="Email"  class=" input-compo">
                            </div>
                            <div class="user__info--gender info-compo">
                                <div class="lable__gender lable-compo">
                                    <label for="gender">Giới tính</label>
                                </div>
                                <div class="gender__option">
                                    <select name="" id="gender">
                                        <option value="Male">Nam</option>
                                        <option value="Female">Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="user__info--birthday info-compo">
                                <div class="lable__birthday lable-compo">
                                    <label for="day">Ngày sinh</label>
                                </div>
                                <div class="birthday__option">
                                    <input type="number"  class=" input-compo" id="day" pattern="[0-9]{1,2}" maxlength="2">
                                    <select name="" id="month" pattern="[0-9]{1,2}" maxlength="2">
                                        <option value="january">Tháng 1</option>
                                        <option value="febuary">Tháng 2</option>
                                        <option value="march">Tháng 3</option>
                                        <option value="april">Tháng 4</option>
                                        <option value="may">Tháng 5</option>
                                        <option value="june">Tháng 6</option>
                                        <option value="july">Tháng 7</option>
                                        <option value="august">Tháng 8</option>
                                        <option value="september">Tháng 9</option>
                                        <option value="october">Tháng 10</option>
                                        <option value="november">Tháng 11</option>
                                        <option value="degitcember">Tháng 12</option>
                                    </select>
                                    <input type="number"  class=" input-compo" id="year" pattern="[0-9]{4}" maxlength="4">
                                </div>
                            </div>
                            <div class="user__info--address info-compo">
                                <div class="lable__address lable-compo">
                                    <label for="Address">Địa chỉ</label>
                                </div>
                                <input type="text"  class="input-compo" id="Address">
                            </div>
                        </div>
                    </div>
                    <div class="save save__userInfo">
                        <button>Lưu thay đổi</button>
                    </div>
                </section>
                <section class="service__section">
                    <h1 class="title">Đổi mật khẩu</h1>
                    <div  class="form contains">
                        <div class="info__oldPass info-compo">
                            <label class="lable__oldPass lable-compo" for="oldPassword">Mật khẩu cũ</label>
                            <div class="input__form">
                                <input class="input__oldPass input-compo" type="password" id="oldPassword" >
                                <i class=" icon__eye icon__eye--close fa-regular fa-eye-slash"></i>
                                <i class="icon__eye icon__eye--open fa-regular fa-eye"></i>
                            </div>
                            <p class="form__error"></p>
                        </div>
                        <div class="info__newPass info-compo">
                            <label class="lable__newPass lable-compo" for="password">Mật khẩu mới</label>
                            <div class="input__form">
                                <input type="password" id="password" class="input__newPass input-compo">
                                <i class=" icon__eye icon__eye--close fa-regular fa-eye-slash"></i>
                                <i class="icon__eye icon__eye--open fa-regular fa-eye"></i>
                            </div>
                            <p class="form__error"></p>
                        </div>
                        <div class="info__newPass--confirm info-compo">
                            <label class="lable__newPass--confirm lable-compo" for="confirm-password">Nhập lại mật khẩu mới</label>
                            <div class="input__form">
                                <input type="password" id="confirm-password" class="input__newPass--confirm input-compo">
                                <i class=" icon__eye icon__eye--close fa-regular fa-eye-slash"></i>
                                <i class="icon__eye icon__eye--open fa-regular fa-eye"></i>
                            </div>
                            <p class="form__error"></p>
                        </div>
                        <div class="save save__changePass">
                            <button id="form__submit" type="submit" class=" form__submit button button--hover">Lưu thay đổi</button>
                        </div>
                    </div>
                </section>
                <section class="service__section" >
                    <h1 class="title">Lịch sử mua hàng</h1>
                    <div class="statusOrder">
                        <span class="status__list status__list--click">Tất cả</span>
                        <span class="status__list">Đơn hàng mới</span>
                        <span class="status__list">Chờ thanh toán</span>
                        <span class="status__list">Đã xác nhận</span>
                        <span class="status__list">Vận chuyển</span>
                        <span class="status__list">Hoàn thành</span>
                    </div>
                    <div class="service__order service__order--show">

                    </div>
                    <div class="service__order ">
                        <div class="block__product--history">
                            <div class="imgNoneProduct"></div>
                            <h2>Chưa có đơn hàng</h2>
                        </div>
                    </div>
                    <div class="service__order ">
                        <div class="block__product--history">
                            <div class="imgNoneProduct"></div>
                            <h2>Chưa có đơn hàng</h2>
                        </div>
                    </div>
                    <div class="service__order ">
                        <div class="block__product--history">
                            <div class="imgNoneProduct"></div>
                            <h2>Chưa có đơn hàng</h2>
                        </div>
                    </div>
                    <div class="service__order ">
                        <div class="block__product--history">
                            <div class="imgNoneProduct"></div>
                            <h2>Chưa có đơn hàng</h2>
                        </div>
                    </div>
                    <div class="service__order service__order--done">

                    </div>
                </section>
            </div>
        </div>
    </div>
</main>
<footer id="footer">
    <div class="container-xl">
        <a href="#" class="logo"></a>
        <div class="row">
            <div class="col ">
                <div class="footer__block">
                    <p class="footer__title">Giờ làm việc</p>
                    <p class="footer__desc">9:00 - 17:00</p>
                </div>

                <div class="footer__block">
                    <p class="footer__title">Địa chỉ</p>
                    <a href="https://maps.app.goo.gl/RETcqrjaKeqTCfBE6" class="footer__desc">721 Huỳnh Tấn Phát, Phường
                        Phú Thuận, Quận 7, Tp. Hồ
                        Chí Minh</a></div>
            </div>
            <div class="col">
                <ul class="footer__block">
                    <li class="footer__desc">
                        <a href="#!" class="footer__link">Thiết kế</a>
                    </li>
                    <li class="footer__desc">
                        <a href="#!" class="footer__link">Liên hệ</a>
                    </li>
                    <li class="footer__desc">
                        <a href="#!" class="footer__link">Về chúng tôi</a>
                    </li>
                    <li class="footer__desc">
                        <a href="#!" class="footer__link">Chính sách mua hàng</a>
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
<script src="../js/validateForm.js"></script>
<script src="../js/data.js"></script>
<script src="../js/account.js"></script>
</body>
<script>

    var listServiceBtn = document.querySelectorAll(".service__item");
    var listServiceSection = document.querySelectorAll(".service__section");
    console.log(listServiceSection)
    listServiceBtn.forEach(function (btn, index) {
        btn.onclick = function () {
            listServiceSection.forEach(function (section) {
                section.classList.remove("service__section--show");
            });
            listServiceBtn.forEach(function (btn) {
                btn.classList.remove("service__item--clicked");
            });
            listServiceSection[index].classList.add("service__section--show");
            btn.classList.add("service__item--clicked");
        }
    })
</script>
<script>
    var listStatus = document.querySelectorAll(".status__list");
    var listServiceOrder = document.querySelectorAll(".service__order");
    console.log(listServiceOrder)
    listStatus.forEach(function (btn, index) {
        btn.onclick = function () {
            listServiceOrder.forEach(function (section) {
                section.classList.remove("service__order--show");
            });
            listStatus.forEach(function (btn) {
                btn.classList.remove("status__list--click");
            });
            listServiceOrder[index].classList.add("service__order--show");
            btn.classList.add("status__list--click");
        }
    })
</script>
<script>
    //checkValidation
    var validation = new Validation({
        formSelector: ".form",
        formBlockClass: "info-compo",
        errorSelector: ".form__error",
        rules: [
            Validation.isRequired("#oldPassword"),
            Validation.isRequired("#password"),
            Validation.minLength("#password", 6),
            Validation.isRequired("#confirm-password"),
            Validation.isConfirm("#confirm-password", function () {
                return document.querySelector("#password").value;
            })
        ],
    })
</script>
</html>