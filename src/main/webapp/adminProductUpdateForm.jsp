<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="productFactory" class="utils.ProductFactory" scope="session"/>
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
    <link rel="stylesheet" href="assets/css/admin/adminProductDetail.css">
    <link rel="stylesheet" href="assets/css/notify.css">
    <title>Thêm sản phẩm</title>
</head>
<body>
<div class="container-xl">
    <form class="product__form " action="#!" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-12">
                <h2>Thông tin</h2>
                <label class="form__label form__block">
                    <span class="form__title">Tên sản phẩm
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Đây là tên của sản phẩm</p>
                    </span>
                    <input type="text" id="name" name="name" class="form__input">
                    <span class="form__error"></span>
                </label>
                <label class="form__label form__block">
                    <span class="form__title">Phân loại sản phẩm
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Lựa chọn phân loại cho sản phẩm!</p>
                    </span>
                    <select name="idCategory"
                            class="form__select">
                        <c:forEach items="${pageContext.servletContext.getAttribute('categoryList')}"
                                   var="category">
                            <option value="${category.id}"
                                    class="form__option">${category.nameType}
                            </option>
                        </c:forEach>
                    </select>
                </label>
                <div class="row">
                    <div class="col-6">
                        <label class="form__label form__block">
                            <span class="form__title">Giá bán
                                <i class="form__detail fa-solid fa-circle-info"></i>
                                <p>Giá bán của sản phẩm</p>
                            </span>
                            <div class="price-wrapper">
                                <input id="originalPrice" type="text" name="originalPrice"
                                       class="form__input">
                                <span>VND</span>
                            </div>
                            <span class="form__error"></span>
                        </label>
                    </div>

                    <div class="col-6">
                        <label class="form__label form__block">
                            <span class="form__title">Giá giảm
                                <i class="form__detail fa-solid fa-circle-info"></i>
                                <p>Giá giảm của sản phẩm!</p>
                            </span>
                            <span class="price-wrapper">
                                <input type="text" id="salePrice" name="salePrice"
                                       class="form__input">
                                <span>VND</span>
                            </span>
                            <span class="form__error"></span>
                        </label>
                    </div>
                </div>
                <label class="form__label form__block">
                    <span class="form__title form__desc">Mô tả
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Mô tả của sản phẩm</p>
                    </span>
                    <div id="ck-editor">
                    </div>
                    <input type="text" id="description" name="description" hidden="hidden" value="">
                    <span class="form__error"></span>
                </label>

            </div>
            <div class="col-6">
                <!--Size-->

                <div class="form__label form__block">
                    <span class="form__title">
                        <h2>Kích thước</h2>
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Mỗi sản phẩm có ít nhất một kích thước, mỗi kích thước gồm tên kích thước và giá của kích
                           thước đó. Giá kích thước sẽ được cộng cùng với giá sản phẩm ở trên</p>
                    </span>
                    <div class="form__sizes-wrapper">
                        <div class="form__sizes">
                            <div class="form__size">
                                <div class="form__block">
                                    <label>
                                        Tên kích thước
                                        <input id="nameSize" type="text" name="nameSize"
                                               class="form__size-input">
                                    </label>
                                    <span class="form__error"></span>
                                </div>
                                <div class="form__block">
                                    <label class="form__size-price">
                                        Giá:
                                        <input id="sizePrice" type="text" name="sizePrice">
                                        <span>VNĐ</span>
                                    </label>
                                    <span class="form__error"></span>
                                </div>
                            </div>
                        </div>
                        <span class="form__add-size">Thêm kích cỡ</span>
                    </div>
                </div>
            </div>

            <div class="col-6">
                <!--Color-->
                <div class="form__label form__block">
                    <span class="form__title">
                        <h2>Màu sắc có sẵn</h2>
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Màu sắc của sản phẩm, mỗi sản phẩm phải có ít nhất 1 màu, mã màu được lưu dưới dạng mã
                           HEX</p>
                    </span>
                    <div class="form__colors-wrapper">
                        <div class="form__colors">
                            <div class="form__color">
                                <input type="color" name="color"
                                       class="form__color-input">
                            </div>
                        </div>
                        <span class="form__add-color">Thêm màu sắc</span>
                    </div>
                </div>
            </div>
            <!--Hình ảnh của sản phầm (chỉ được xóa)-->
            <div class="col-12">
                <div class="form__label form__block form__img-exist">
                    <span class="form__title">
                        <h2>Hình ảnh đã có của sản phẩm</h2>
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Hình ảnh đã có của sản phẩm, các ảnh ở khu vực này chỉ có thể xóa</p>
                    </span>
                    <div class="form__img">
                        <div class="img__previews">
                        </div>
                    </div>
                    <span class="form__error"></span>
                </div>
            </div>
            <!--Hình ảnh cần thêm (chỉ được thêm sản phẩm-->
            <div class="col-12">
                <div class="form__label form__block form__img-added">
                    <span class="form__title">
                        <h2>Thêm ảnh</h2>
                        <i class="form__detail fa-solid fa-circle-info"></i>
                        <p>Hình ảnh cần thêm sản phẩm</p>
                    </span>
                    <div class="form__img ">
                        <div class="img__previews">
                        </div>
                        <label class="img__label">
                            <input id="image" class="img__input" name="image" type="file" hidden="hidden" multiple>
                            <i class="img__icon fa-regular fa-images"></i>
                        </label>
                    </div>
                    <span class="form__error"></span>
                </div>
            </div>
            <div class="col-12">
                <button id="form__submit" type="submit" class="form__submit button button--hover">Cập nhập sản phẩm</button>

            </div>
        </div>
    </form>
</div>
<div class="toast__list">

</div>
<script>
    var editorCK = CKEDITOR.replace('ck-editor',);
    CKFinder.setupCKEditor(editorCK, "ckfinder/");
</script>
<script src="js/validateForm.js"></script>
<script src="js/notify.js"></script>
<script src="js/admin/adminUpdateProduct.js"></script>
</body>
</html>