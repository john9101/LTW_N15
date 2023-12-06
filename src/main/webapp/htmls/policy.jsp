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
    <link rel="stylesheet" href="../assets/css/policy.css">
    <title>Chính sách</title>
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
    <div class="container-xl">
        <div class="row">
            <div class="col-3">
                <ul class="policy__list">
                    <li class="policy__item policy__item--clicked">Chính sách giao hàng</li>
                    <li class="policy__item">Chính sách thanh toán</li>
                    <li class="policy__item">Chính sách đổi trả</li>
                </ul>
            </div>
            <div class="col-9">
                <section class="policy__section policy__section--show">
                    <!--<h1 class="title">CHÍNH SÁCH GIAO HÀNG</h1>-->
                    <div class="policy__block">
                        <h2 class="policy__title">Phạm vi giao hàng</h2>
                        <p class="policy__text"><strong>YOUR STYLES</strong> Việt Nam hỗ trợ giao hàng cho khách hàng trên toàn quốc.</p>
                        <p class="policy__text">
                            Trong các trường hợp có phát sinh dịch bệnh hoặc trong các trường hợp bất khả kháng tại thời điểm phát sinh, khu vực giao hàng có thể thay đổi theo quy định của cơ quan quản lý nhà nước.
                        </p>
                    </div>
                    <div class="line__break"></div>
                    <div class="policy__block">
                        <h2 class="policy__title">Thời gian giao hàng</h2>
                        <p class="policy__text">Phục vụ giao hàng trong giờ hành chính từ thứ 2 đến thứ 6 (trừ thứ 7, Chủ nhật và ngày Lễ, Tết theo quy định của Nhà nước).</p>
                        <div class="policy__block">
                            <h3 class="policy__sub-title">Chuyển phát nhanh</h3>
                            <p class="policy__text">Thời gian giao hàng từ 1-5 ngày làm việc Chi phí giao hàng hiển thị tại bước đặt hàng Từ 1/10/2022: Miễn phí vận chuyển cho mọi đơn hàng</p>

                            <div class="line__break"></div>

                            <h3 class="policy__sub-title">Nhận tại cửa hàng</h3>
                            <p class="policy__text">Thời gian giao hàng từ 24-72h Miễn phí giao hàng tại hệ thống cửa hàng Your Style</p>
                            <div class="policy__note">
                                <p class="">
                                    Lưu ý: Đây là thời gian giao hàng dự kiến. Thời gian này có thể thay đổi vì một số lý do ngoài ý muốn và sẽ được thông báo với quý khách nếu có. Thời gian giao hàng tại huyện, hoặc các khu vực
                                    Huyện đảo, xã đặc biệt theo quy định riêng có thể cộng thêm 1-3 ngày so với thời gian giao hàng dự kiến.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="line__break"></div>
                    <div class="policy__block">
                        <h2 class="policy__title">Quy định phí giao hàng</h2>
                        <p class="policy__text">Phí giao hàng của đơn hàng được tính dựa theo khoảng cách giữa kho hoặc cửa hàng cung cấp với địa chỉ giao hàng cùng với trọng lượng của sản phẩm.</p>
                        <p class="policy__text">Chi tiết mức phí giao hàng của từng đơn hàng sẽ được thể hiện rõ tại trang hoàn tất đơn hàng sau khi quý khách nhập địa chỉ giao hàng.</p>
                    </div>
                </section>
                <section class="policy__section">
                    <!--<h1 class="title">CHÍNH SÁCH THANH TOÁN</h1>-->
                    <div class="policy__block">
                        <p class="policy__text--intro">Nhằm mang đến Quý khách những trải nghiệm mua sắm trực tuyến tuyệt vời nhất, tại Your Style, chúng tôi đưa ra 4 phương thức thanh toán để Quý khách dễ dàng lựa chọn:</p>
                    </div>

                    <div class="policy__block">
                        <h2 class="policy__title">Thanh toán bằng tiền mặt(COD)</h2>

                        <p class="policy__text">Không hỗ trợ phương thức Thanh toán bằng tiền mặt khi nhận hàng (COD) đối với đơn hàng có sản phẩm bắt buộc lưu chuyển trực tiếp từ cửa hàng để giao hàng</p>

                        <p class="policy__text">Nhân viên hỗ trợ đơn hàng sẽ liên hệ xác nhận thông tin đơn hàng cho quý khách.</p>
                    </div>
                    <div class="line__break"></div>
                    <div class="policy__block">
                        <h2 class="policy__title">Thanh toán chuyển khoảng</h2>

                        <p class="policy__text">
                            Trong quá trình đặt hàng, Quý khách không muốn thanh toán bằng tiền mặt hoặc không thể thanh toán trực tiếp, Quý khách có thể chọn hình thức thanh toán chuyển khoản trong phần Phương thức thanh toán
                        </p>
                        <p class="policy__text">Điều kiện để chọn hình thức thanh toán chuyển khoản là tài khoản ngân hàng của Quý khách đã được đăng ký sử dụng Internet Banking.</p>
                    </div>
                    <div class="line__break"></div>
                    <div class="policy__block">
                        <h2 class="policy__title">Thanh toán bẳng thẻ ATM nội địa</h2>

                        <p class="policy__text">Trong quá trình đặt hàng, quý khách chọn hình thức Thanh toán bằng thẻ ATM nội địa, quý khách sẽ được chuyển đến Cổng thanh toán trực tuyến bảo mật Onepay để thanh toán.</p>
                        <p class="policy__text">Thẻ ATM của quý khách bắt buộc phải sử dụng Internet Banking để thực hiện phương thức thanh toán này.</p>
                    </div>
                    <div class="line__break"></div>
                    <div class="policy__block">
                        <h2 class="policy__title">Thanh toán bằng Visa/Master card</h2>
                        <p class="policy__text">Trong quá trình đặt hàng, quý khách chọn hình thức Thanh toán bằng thẻ Visa/Master card, quý khách sẽ được chuyển đến Cổng thanh toán trực tuyến bảo mật Onepay để thanh toán</p>
                    </div>
                </section>
                <section class="policy__section">
                    <!--<h1 class="title">CHÍNH SÁCH ĐỔI TRẢ</h1>-->
                    <div class="policy__block">
                        <p class="policy__text--intro">Chính sách đổi hàng áp dụng cho khách hàng mua hàng và thanh toán tại các cửa hàng Your style</p>
                        <p class="policy__text--intro">Phương thức đổi hàng: Đổi hàng trực tuyến (qua đơn vị vận chuyển).</p>
                    </div>
                    <div class="policy__block">
                        <h2 class="policy__title">Nội dung chính sách đổi trả:</h2>

                        <p class="policy__text">Áp dụng đổi hàng cho các sản phẩm nguyên giá và các sản phẩm giảm giá không quá 30% trong vòng 14 ngày.</p>
                        <p class="policy__text">Áp dụng đổi size (nếu có) cho các sản phẩm giảm giá trên 30% trong vòng 05 ngày.</p>
                        <p class="policy__text">Các thời hạn đổi hàng nêu trên được tính kể từ ngày khách hàng nhận được sản phẩm được thể hiện trên hệ thống của đơn vị vận chuyển</p>
                        <p class="policy__text">Mỗi sản phẩm đủ điều kiện được đổi 01 lần duy nhất.</p>
                        <p class="policy__text">Tất cả các sản phẩm đổi hàng phải đảm bảo giữ nguyên vẹn với đầy đủ nhãn mác, hộp/bao bì sản phẩm, phụ kiện đi kèm như ban đầu</p>
                        <p class="policy__text">Không chấp nhận đổi hàng với các sản phẩm đã qua sử dụng, đã chỉnh sửa, đã qua giặt ủi/là, có mùi lạ, có sự hư hại hoặc bị lỗi do quá trình lưu giữ, vận chuyển của người sử dụng</p>
                        <p class="policy__text">
                            Trong trường hợp việc đổi hàng được thực hiện không phải lỗi từ sản phẩm hoặc do nhà sản xuất, và đến từ nhu cầu của khách hàng, khách hàng sẽ chịu toàn bộ chi phí vận chuyển hàng hóa đổi và chịu trách
                            nhiệm cho các rủi ro trong việc vận chuyển các sản phẩm đổi đến Your Style
                        </p>
                    </div>
                </section>
            </div>
        </div>
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
                    <a target="_blank" href="https://maps.app.goo.gl/RETcqrjaKeqTCfBE6" class="footer__desc">721 Huỳnh Tấn Phát,
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
                        <a href="./policy.html" class="footer__link">Chính sách mua hàng</a>
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
<script>
    var listPolicyBtn = document.querySelectorAll(".policy__item");
    var listPolicySection = document.querySelectorAll(".policy__section");
    listPolicyBtn.forEach(function (btn, index) {
        btn.onclick = function () {
            listPolicySection.forEach(function (section) {
                section.classList.remove("policy__section--show");
            });
            listPolicyBtn.forEach(function (btn) {
                btn.classList.remove("policy__item--clicked");
            });
            listPolicySection[index].classList.add("policy__section--show");
            btn.classList.add("policy__item--clicked");
        };
    });
</script>
<script src="../js/base.js"></script>
</html>