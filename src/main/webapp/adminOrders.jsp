<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap-->
    <link rel="stylesheet" href="assets/bootstrap/bootstrap-grid.min.css">
    <link rel="stylesheet" href="assets/fontIcon/fontawesome-free-6.4.2-web/css/all.min.css">

    <link rel="stylesheet" href="assets/font/webfonts/Montserrat.css">
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="assets/css/admin/admin.css">
    <link rel="stylesheet" href="assets/css/admin/adminOrders.css">
    <title>Admin</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main id="main">
    <nav class="navbar">
        <div class="container-xl">
            <ul class="navbar__list">
                <li
                        class="navbar__item"><a href="adminProducts.jsp"
                                                class="navbar__link button button button--hover ">Sản
                    phẩm</a>
                </li>
                <li class="navbar__item"><a href="./adminOrders.html"
                                            class="navbar__link button button button--hover navbar__link--clicked">Đơn
                    hàng</a>
                </li>
                <li class="navbar__item"><a href="adminUsers.jsp" class="navbar__link button button button--hover ">Khách
                                                                                                                    hàng</a>
                </li>
            </ul>
        </div>
    </nav>
    <section class="content">
        <div class="container-xl">
            <div class="row">
                <div class="col-3">
                    <aside class="filler">
                        <form class="form">
                            <article action="#!" class="filler__block">
                                <h2 class="filler__heading">Thời gian đặt hàng</h2>
                                <div class="interval__filler">
                                    <div class="filler__date">
                                        <span class="filler__title">Từ:</span>
                                        <input type="date" name="" id="date-start">
                                    </div>
                                    <div class="filler__date">
                                        <span class="filler__title">Đến:</span>
                                        <input type="date" name="" id="date-end">
                                    </div>
                                </div>
                            </article>
                            <article class="filler__payment-method filler__block">
                                <h2 class="filler__heading">Phương thức thanh toán</h2>
                                <label class="filter__label check">
                                    <input type="radio" name="payment" class="filter__input" hidden="true">
                                    Tiền mặt
                                </label>
                                <label class="filter__label check">
                                    <input type="radio" name="payment" class="filter__input" hidden="true">
                                    Chuyển khoản ngân hàng
                                </label>
                                <label class="filter__label check">
                                    <input type="radio" name="payment" class="filter__input" hidden="true">
                                    Ví điện tử
                                </label>
                            </article>

                            <article class="filler__block">
                                <h2 class="filler__heading">Trạng thái đơn hàng</h2>
                                <label class="filter__label check">
                                    <input type="radio" name="passing" class="filter__input" hidden="true">
                                    Đơn hàng mới
                                </label>
                                <label class="filter__label check">
                                    <input type="radio" name="passing" class="filter__input" hidden="true">
                                    Đã xác nhận
                                </label>

                                <label class="filter__label check">
                                    <input type="radio" name="passing" class="filter__input" hidden="true">
                                    Đang vận chuyển
                                </label>

                                <label class="filter__label check">
                                    <input type="radio" name="passing" class="filter__input" hidden="true">
                                    Hoàn thành
                                </label>

                                <label class="filter__label check">
                                    <input type="radio" name="passing" class="filter__input" hidden="true">
                                    Đã hủy
                                </label>
                            </article>

                            <article class="filler__block">
                                <h2 class="filler__heading">Trạng thái giao dịch</h2>
                                <label class="filter__label check">
                                    <input type="radio" name="delivery" class="filter__input" hidden="true">
                                    Chưa thanh toán
                                </label>
                                <label class="filter__label check">
                                    <input type="radio" name="delivery" class="filter__input" hidden="true">
                                    Đã thanh toán
                                </label>
                            </article>

                            <div class="filter__buttons">
                                <input type="reset" class="button filter__button button--hover" value="Chọn lại">
                                <button class="button filter__button button--hover" type="submit">Lọc</button>
                            </div>
                        </form>
                    </aside>
                </div>
                <div class="col-9">
                    <form action="" class=form__search>
                        <article action="#!" class="form__search-block">
                            <i class="search__icon fa-solid fa-magnifying-glass"></i>
                            <input type="text" name="search">
                            <select name="" id="" class="search__select">
                                <option value="" class="search__option">Mã đơn hàng</option>
                                <option value="" class="search__option">Tên khách hàng</option>
                            </select>
                        </article>
                        <div class="button button__delete">
                            <i class="fa-solid fa-minus"></i>
                            Xóa đơn hàng
                        </div>
                    </form>
                    <div class="table__wrapper">
                        <table class="table table__order">
                            <thead>
                            <tr class="table__row">
                                <th class="table__checkbox"></th>
                                <th class="table__head">Cập nhật</th>
                                <th class="table__head">Mã đơn hàng</th>
                                <th class="table__head">Ngày tạo</th>
                                <th class="table__head">Tên khách hàng</th>
                                <th class="table__head">Phương thức thanh toán</th>
                                <th class="table__head">Trạng thái đơn hàng</th>
                                <th class="table__head">Trạng thái giao dịch</th>
<!--                                <th class="table__head">Trạng thái vận chuyển</th>-->
                                <th class="table__head">Tổng tiền</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                        <!--Paging-->
                        <ul class="paging"></ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<div id="dialog-order-update" class="modal">
    <article class="modal__content modal__product modal__order">
        <div class="head__dialog--bar">
            <h1>Chỉnh sửa thông tin</h1>
            <i class="modal__product-close modal__order-close fa-solid fa-xmark"></i>
        </div>
        <form action="#!" class="order__update--form">
            <div class="grid__template">
                <div class=" grid__block grid__productsBought">
                    <span class="grid__area--title">Thông tin đơn hàng</span>
                    <div class="products__bought--container">
                        <span class="order__id">Mã đơn hàng: 2</span>
                        <span class="order__date">Ngày tạo: 29-10-2022</span>
                        <span class="order__payment">Phương thức thanh toán: Chuyển khoản ngân hàng</span>
                        <span class="order__voucher">Mã giảm giá áp dụng: MGG50</span>
                        <span class="order__products">Các sản phẩm đã đặt</span>
                        <div class="order__swapper">
                            <table class="order__table">
                                <thead>
                                <tr class="row__header">
                                    <th class="thead__item"></th>
                                    <th class="thead__item">Sản phẩm</th>
                                    <th class="thead__item">Màu sắc</th>
                                    <th class="thead__item">Kích thước</th>
                                    <th class="thead__item">Số lượng</th>
                                    <th class="thead__item">Giá may</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="row__content">
                                    <td class="td__item">1</td>
                                    <td class="td__item">
                                        <div class="product__item">
                                            <img src="assets/img/product_img/product1.jpg">
                                            <p class="product__name">Áo polo nam trơn basic form regular vải cá sấu</p>
                                        </div>
                                    </td>
                                    <td class="td__item">Đen</td>
                                    <td class="td__item">XXL</td>
                                    <td class="td__item">1</td>
                                    <td class="td__item">279.000&nbsp;₫</td>
                                </tr>
                                <tr class="row__content">
                                    <td class="td__item">2</td>
                                    <td class="td__item">
                                        <div class="product__item">
                                            <img src="assets/img/product_img/product2.jpg">
                                            <p class="product__name">Áo polo thể thao unisex nam nữ</p>
                                        </div>
                                    </td>
                                    <td class="td__item">Xanh navy</td>
                                    <td class="td__item">XXL</td>
                                    <td class="td__item">1</td>
                                    <td class="td__item">239.000&nbsp;₫</td>
                                </tr>

                                <tr class="row__content">
                                    <td class="td__item">3</td>
                                    <td class="td__item">
                                        <div class="product__item">
                                            <img src="assets/img/product_img/product3.jpg">
                                            <p class="product__name">Áo polo phối khóa kéo unisex nam nữ</p>
                                        </div>
                                    </td>
                                    <td class="td__item">Beige</td>
                                    <td class="td__item">XXL</td>
                                    <td class="td__item">1</td>
                                    <td class="td__item">289.000&nbsp;₫</td>
                                </tr>
                                <tr class="row__content">
                                    <td class="td__item">4</td>
                                    <td class="td__item">
                                        <div class="product__item">
                                            <img src="assets/img/product_img/product4.jpg">
                                            <p class="product__name">Áo hoodie form rộng unisex nam nữ nỉ chân cua</p>
                                        </div>
                                    </td>
                                    <td class="td__item">Đen</td>
                                    <td class="td__item">XL</td>
                                    <td class="td__item">1</td>
                                    <td class="td__item">259.000&nbsp;₫</td>
                                </tr>
                                <tr class="row__content">
                                    <td class="td__item">5</td>
                                    <td class="td__item">
                                        <div class="product__item">
                                            <img src="assets/img/product_img/product5.jpg">
                                            <p class="product__name">Áo hoodie zip form boxy unisex nỉ bông dày</p>
                                        </div>
                                    </td>
                                    <td class="td__item">Xanh lá</td>
                                    <td class="td__item">X</td>
                                    <td class="td__item">1</td>
                                    <td class="td__item">250.000&nbsp;₫</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <button class="update__button">Cập nhật</button>
                </div>
                <div class=" grid__block grid__DeliveryInfo">
                    <span class="grid__area--title">Thông tin giao hàng</span>
                    <div class="info__items">
                        <div class="info__item">
                            <p class="info__text">Mã người dùng:</p>
                            <p class="info__value">7</p>
                        </div>
                        <div class="info__item">
                            <p class="info__text">Họ và tên:</p>
                            <p class="info__value">Cáp Hữu Ðạt</p>
                        </div>
                        <div class="info__item">
                            <p class="info__text">Email:</p>
                            <p class="info__value">HuuDat@gmail.com</p>
                        </div>
                        <div class="info__item">
                            <p class="info__text">Số điện thoại:</p>
                            <p class="info__value">0328012964</p>
                        </div>
                        <div class="info__item">
                            <p class="info__text">Địa chỉ:</p>
                            <p class="info__value">Xã Vĩnh Thạnh Trung, Huyện Châu Phú, An Giang</p>
                        </div>
                    </div>

                </div>
                <div class=" grid__block grid__updateStatus">
                    <span class="grid__area--title">Cập nhật trạng thái</span>
                    <div id="update__status--container">
                        <div class="select-menu order__status">
                            <div class="select-btn">
                                <span class="sBtn-text">Chọn trạng thái</span>
                                <i class="fa-solid fa-chevron-down"></i>
                            </div>
                            <ul class="options">
                                <li class="option">Đơn hàng mới</li>
                                <li class="option">Đã xác nhận</li>
                                <li class="option">Đang vận chuyển</li>
                                <li class="option">Hoàn thành</li>
                            </ul>
                        </div>

                        <div class="select-menu transaction__status">
                            <div class="select-btn">
                                <span class="sBtn-text">Chọn trạng thái</span>
                                <i class="fa-solid fa-chevron-down"></i>
                            </div>
                            <ul class="options">
                                <li class="option">Chưa thanh toán</li>
                                <li class="option">Đã thanh toán</li>
                            </ul>
                        </div>
                    </div>

                    <p class="update__noted">Quản trị viên phải cập nhật trạng thái đơn hàng và trạng thái giao dịch để
                        khách hàng đễ dàng theo dõi tiến độ đơn hàng</p>
                </div>
            </div>
        </form>
    </article>
    <div class="modal__blur"></div>
</div>
<script src="js/data.js"></script>
<script src="js/paging.js"></script>
<script src="js/admin/adminOrders.js"></script>
</body>
</html>