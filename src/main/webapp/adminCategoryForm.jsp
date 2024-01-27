<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
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
    <%--jquery--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!--CK Editor-->
    <script src="ckeditor/ckeditor.js"></script>
    <!--Ck Finder-->
    <script src="ckfinder/ckfinder.js"></script>
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
    <link rel="stylesheet" href="assets/css/admin/adminProducts.css">
    <link rel="stylesheet" href="assets/css/admin/adminCategoryForm.css">
    <link rel="stylesheet" href="assets/css/notify.css">
    <title></title>
</head>
<body>
<main>
    <div class="container-fluid">
        <form action="#!" class="category__form" enctype="multipart/form-data">
            <div class="row">
                <div class="col-12">
                    <div class="category__wrapper">
                        <label class="category__label">
                            <div class="category__title">Tên phân loại
                                <i class="category__icon-guide fa-solid fa-circle-info">
                                </i>
                                <div class="category__guide">Đặt tên cho phân loại sản phẩm
                                </div>
                            </div>
                            <div class="category__block">
                                <input type="text" name="nameCategory" id="nameCategory" class="category__name category__input">
                                <p class="category__error"></p>
                            </div>
                        </label>
                        <label class="category__label">
                            <div class="category__title">Ảnh kích thước có sẵn
                                <i class="category__icon-guide fa-solid fa-circle-info">
                                </i>
                                <div class="category__guide">Ảnh dành cho các size có sẵn cho sản phẩm
                                </div>
                            </div>
                            <div class="category__block">
                                <label class="category__file">
                                    <input name="sizeTableImage" id="sizeTableImage" type="file" hidden="hidden">
                                </label>
                                <p class="category__error"></p>
                            </div>
                        </label>
                    </div>
                </div>
                <div class="col-12">
                    <div class="parameter__list">
                        <div class="parameter__item">
                            <div class="parameter__grid">
                                <label class="category__label">
                                    <div class="category__title">Tên tham số
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Tên tham số, ví dụ: dài áo, ngang vai,...
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input name="nameParameter" id="nameParameter" type="text" class="category__name category__input">
                                        <p class="category__error"></p>
                                    </div>
                                </label>
                                <label class="category__label">
                                    <div class="category__title">Đơn vị tính toán
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Đơn vị của giá trị tối thiểu và giá trị tối đa
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input type="text" name="unit" id="unit" class="category__name category__input">
                                        <p class="category__error"></p>
                                    </div>
                                </label>
                                <label class="category__label">
                                    <div class="category__title">Giá trị tổi thiểu
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Giá trị tối thiểu mà người dùng có thể đặt may đồ
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input type="text" name="minValue" id="minValue" class="category__name category__input">
                                        <p class="category__error"></p>
                                    </div>
                                </label>
                                <label class="category__label">
                                    <div class="category__title">Giá trị tối đa
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Giá trị tối đa mà người dùng có thể đặt may đồ
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input type="text" name="maxValue" id="maxValue" class="category__name category__input">
                                        <p class="category__error"></p>
                                    </div>
                                </label>
                            </div>
                            <label class="category__label">
                                <div class="category__title">Ảnh hướng dẫn may đo
                                    <i class="category__icon-guide fa-solid fa-circle-info">
                                    </i>
                                    <div class="category__guide">Ảnh hướng dẫn may đo cho thông số, chỉ được chọn 1 ảnh
                                    </div>
                                </div>
                                <div class="category__block">
                                    <label class="category__file">
                                        <input id="guideImg" name="guideImg" type="file" accept="image/*" hidden="hidden">
                                    </label>
                                    <p class="category__error"></p>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-12">
                    <div class="button button--hover parameter__add">
                        <i class="fa-solid fa-plus parameter__add-icon"></i> Thêm thông số
                    </div>
                    <button type="submit" id="form__submit" class="button__submit button button--hover button--hover parameter__add">
                        Tạo phân loại
                    </button>
                </div>
            </div>
        </form>
    </div>
</main>
<div class="toast__list">
</div>
<script src="js/validateForm.js"></script>
<script src="js/notify.js"></script>
<script src="js/admin/adminCategoryForm.js"></script>
</body>
</html>
