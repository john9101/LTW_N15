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

    <link rel="stylesheet" href="../assets/css/reset.css">
    <link rel="stylesheet" href="../assets/css/base.css">
    <link rel="stylesheet" href="../assets/css/about1.css">

    <title>Giới thiệu</title>
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
                        <a href="./about.html" class="nav__link">Về chúng tôi</a>
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
<main class=" wraper">
    <div class="container">
        <div class="about">
            <h1 class="title">Về chúng tôi</h1>
            <hr class="line">
            <div class="introduce">
                <p>Your Style là xưởng may gia công thiết kế trang phục cho các thương hiệu thời trang tại Việt Nam.
                    Được thành lập bởi đội ngũ với hơn 10 năm kinh nghiêm trong ngành thời trang.</p>
            </div>
            <div class="card">
                <div class="card__item">
                    <div class="card__icon">
                        <i class="fa-solid fa-hand-holding-dollar"></i>
                    </div>
                    <div class="card__compo">
                        <h4>LINH HOẠT</h4>
                    </div>
                    <div class="text">
                        <p>Your Style tự tin đáp ứng được các nhu cầu sản xuất của khách hàng từ lớn đến nhỏ, từ chuỗi
                            thời trang đến các bạn trẻ khởi nghiệp.</p>
                    </div>
                </div>
                <div class="card__item">
                    <div class="card__icon">
                        <i class="fa-solid fa-heart"></i>
                    </div>
                    <div class="card__compo">
                        <h4>THẤU HIỂU</h4>
                    </div>
                    <div class="text">
                        <p>Đã từng đồng hành cùng nhiều bạn trẻ khởi nghiệp với ngành thời trang, từ đó Your Style thấu
                            hiểu sâu sắc nhu cầu và mong muốn của khác hàng.</p>
                    </div>
                </div>
                <div class="card__item">
                    <div class="card__icon">
                        <i class="fa-solid fa-gears"></i>
                    </div>
                    <div class="card__compo">
                        <h4>CHUYÊN NGHIỆP</h4>
                    </div>
                    <div class="text">
                        <p>Từ khâu tư vấn đến hoàn thành đơn hàng là một quy trình chặt chẽ, chuyên nghiệp. Đảm bảo
                            khách hàng nhận được sản phẩm chất lượng, đúng hẹn, hài lòng tuyệt đối với các dịch vụ khi
                            đặt may tại Your Style.</p>
                    </div>
                </div>
                <div class="card__item">
                    <div class="card__icon">
                        <i class="fa-solid fa-handshake-simple"></i>
                    </div>
                    <div class="card__compo">
                        <h4>UY TÍN</h4>
                    </div>
                    <div class="text">
                        <p>Trong quá trình làm việc, Your Style luôn đặt "uy tín" lên hàng đầu. Từ chất lượng sản
                            phẩm, thời gian giao hàng đúng hẹn đến bảo mật mẫu mã và thông tin khách hàng.</p>
                    </div>
                </div>
            </div>

        </div>
        <div class="nmajor">
            <h1 class="title">Lĩnh vực</h1>
            <hr class="line">
            <div class="introduce">
                <p>Your Style chuyên nhận đặt may số lượng ít từ 30c/mẫu, lên rập, lên mẫu từ sản phẩm thực tế hoặc hình
                    ảnh, bản vẽ. Nhận IN và THÊU theo yêu cầu, tư vấn về nguồn vải, nguyên phụ liệu phù hợp với mẫu may.
                    Nhận thiết kế và sản xuất nhãn mác theo thương hiệu riêng.</p>
            </div>
            <div class="shap">
                <div class="diamond">
                    <span>Thương hiệu</span>
                </div>
                <div class="diamond">
                    <span>Thiết kế</span>
                </div>
                <div class="diamond">
                    <span>Nguyên liệu</span>
                </div>
                <div class="diamond">
                    <span>Cắt may</span>
                </div>
            </div>
            <div class="text_show">
                <div class="text__compo">
                    <div class="compo">
                        <h4>TƯ VẤN ĐỊNH HƯỚNG THƯƠN HIỆU</h4>
                    </div>
                    <div class="text">
                        <p>Giúp quý khách xây dưng vững chắc thương hiệu thời trang của mình trong lòng khách hàng. Lựa
                            chọn được dòng sản phẩm và phong cách phù hợp với mục tiêu của thương hiệu.</p>
                    </div>
                </div>
                <div class="text__compo">
                    <div class="compo">
                        <h4>GÓP Ý, HOÀN THIỆN THIẾT KẾ</h4>
                    </div>
                    <div class="text">
                        <p>Bằng thẩm mỹ được trau dồi qua 10 năm kinh nghiệm, Your Style sẽ giúp hoàn thiện thiết kế
                            tuyệt vời nhất dựa trên ý tưởng của quý khách..</p>
                    </div>
                </div>
                <div class="text__compo">
                    <div class="compo">
                        <h4>TƯ VẤN, NHẬP NGUYÊN LIỆU SẢN XUẤT</h4>
                    </div>
                    <div class="text">
                        <p>Mối quan hệ thân thiết của Your Style với các đối tác cung ứng nguyên vật liệu, chính là đòn
                            bẩy giúp cho khách hàng có được những sản phẩm chất lượng mà giá cả vẫn cạnh tranh.</p>
                    </div>
                </div>
                <div class="text__compo">
                    <div class="compo">
                        <h4>SẢN XUẤT SẢN PHẨM VỚI DÂY CHUYỀN CHUYÊN NGHIỆP</h4>
                    </div>
                    <div class="text">
                        <p>Đội ngũ Your Style được đào tạo chuyên nghiệp, trải nghiệm sâu sắc trong ngành may. Đảm bảo
                            quý khách có hàng đúng như mong muốn, trong đúng khoảng thời gian đã thống nhất.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="chosing">
            <div class="content">
                <h2 class="sub__title">LÝ DO NÊN CHỌN YOUR STYLE</h2>
                <ul class="chosing__list">
                    <li>Thợ may mẫu có kinh nghiệm lâu năm</li>
                    <li>Là xưởng may sản xuất sản phẩm cho nhiều shop thời trang thiết kế</li>
                    <li>Đội ngũ tư vấn, quản lí hàng hoá chuyên nghiệp, cập nhật thông tin hàng hoá một cách nhanh chóng
                        cho khách hàng
                    </li>
                    <li>Khả năng thích ứng và sản xuất theo xu hướng thị trường nhanh chóng</li>
                    <li>Chi phí gia công rẻ</li>
                    <li>Máy móc được đầu tư bài bản, hiện đại</li>
                    <li>Khả năng nhận biết xu hướng, thẩm mỹ sản phẩm tốt</li>
                    <li>Chu đáo – nhiệt tình – tin cậy và uy tín</li>
                </ul>
            </div>
            <div class="pic">
                <img src="../assets/img/YourStyleLogo.png">
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
                        <a href="./about.html" class="footer__link">Về chúng tôi</a>
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
<script>
    const diamonds = document.querySelectorAll('.diamond');
    const textCompos = document.querySelectorAll('.text__compo');
    diamonds.forEach((diamond, index) => {
        diamond.addEventListener('click', () => {
            diamonds.forEach((item) => {
                item.classList.remove('active');
            });
            textCompos.forEach((item) => {
                item.style.display = 'none';
            });
            diamond.classList.add('active');
            textCompos[index].style.display = 'block';
        });
    });
</script>
</body>
</html>