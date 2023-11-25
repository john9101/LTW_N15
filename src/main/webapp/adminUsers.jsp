<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
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
    <link rel="stylesheet" href="assets/css/admin/admin.css">
    <link rel="stylesheet" href="assets/css/admin/adminUsers.css">
    <title>Quản lí người dùng</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<main id="main">
    <nav class="navbar">
        <div class="container-xl">
            <ul class="navbar__list">
                <li class="navbar__item"><a href="adminProducts.jsp" class="navbar__link button button button--hover ">Sản phẩm</a></li>
                <li class="navbar__item"><a href="adminOrders.jsp" class="navbar__link button button button--hover ">Đơn hàng</a></li>
                <li class="navbar__item"><a href="./adminUsers.html" class="navbar__link button button button--hover navbar__link--clicked">Khách hàng</a></li>
            </ul>
        </div>
    </nav>
    <section class="content">
        <div class="container-xl">
            <div class="row">
                <div class="col-12">
                    <div>
                        <h1>Danh sách người dùng</h1>
                        <article action="#!" class="form__search-block filler__block">
                            <i class="search__icon fa-solid fa-magnifying-glass"></i>
                            <input id="search-input" type="text" name="search">

                        </article>
                        <button id="button-remove-product" class="button button__delete">
                            <i class="fa-solid fa-minus"></i>
                            Xóa người dùng
                        </button>
                    </div>
                    <div class="table__wrapper">
                        <table class="table ">
                            <thead>
                                <tr class="table__row">
                                    <th class="table__head table__checkbox"></th>
                                    <th class="table__head table__id">Mã người dùng</th>
                                    <th class="table__head table__username">Tên người dùng</th>
                                    <th class="table__head table__email">Email</th>
                                    <th class="table__head table__fullname">Họ tên</th>
                                    <th class="table__head table__gender">Giới tính</th>
                                    <th class="table__head table__birthday">Ngày sinh</th>
                                    <th class="table__head table__phone">Số điện thoại </th>
                                    <th class="table__head table__address">Địa chỉ </th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <ul class="paging"></ul>
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

    </article>
    <div class="modal__blur"></div>
</div>
<script src="js/data.js"></script>
<script src="js/paging.js"></script>
<script src="js/admin/adminUsers.js"></script>
</body>
</html>