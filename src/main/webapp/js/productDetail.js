
// Form quantity
var quantityCurrent = 1;
var quantityInput = document.querySelector("#quantity");
var quantityDecrease = document.querySelector(".form___quantity--decrease");
var quantityIncrease = document.querySelector(".form___quantity--increase");
quantityDecrease.onclick = function () {
    if (quantityCurrent > 1) {
        quantityCurrent -= 1;
    }
    quantityInput.value = quantityCurrent;
}
quantityIncrease.onclick = function () {
    quantityCurrent += 1;
    quantityInput.value = quantityCurrent;
}

// show/hide description and review product
function showHideDescAndReview() {
    var productDesc = document.querySelector(".product__desc");
    var productReview = document.querySelector(".product__review");
    var productPage = document.querySelectorAll(".product__page");
    var productPageDesc = productPage[0];
    var productPageReview = productPage[1];

    productPageDesc.onclick = function () {
        this.classList.add("product__page--clicked");
        productPageReview.classList.remove("product__page--clicked");
        productReview.style.display = "none";
        productDesc.style.display = "block";
    }
    productPageReview.onclick = function () {
        this.classList.add("product__page--clicked");
        productPageDesc.classList.remove("product__page--clicked");
        productDesc.style.display = "none";
        productReview.style.display = "block";
    }
    var reviewPara = document.querySelectorAll(".review__para");
    reviewPara.forEach(function (element) {
        element.onclick = function () {
            this.classList.toggle("line-clamp");
        }
    });
}

showHideDescAndReview();

function clickTransImg() {
    let imgCurrenct;
    const productImg = document.querySelector(".product__img");
    const productImgItems = document.querySelectorAll(".product__img-item");
    productImgItems.forEach(function (productItem, index) {
        productItem.onclick = function () {
            if (!this.classList.contains("product__img-item--clicked")) {
                this.classList.add("product__img-item--clicked");
                imgCurrenct = productItem.querySelector("img").src;
                productImgItems.forEach(function (productItemOther, indexOther) {
                    if (indexOther !== index) {
                        productItemOther.classList.remove("product__img-item--clicked");
                    }
                });
                productImg.src= imgCurrenct;
            }
        }
    })
}

clickTransImg();

const sizePriceShow = document.querySelector(".size__price");
const vndFormat = Intl.NumberFormat("vi-VI", {
    style: "currency",
    currency: "VND",
});

function addSizePrice(input) {
    sizePriceShow.innerText = "+ " + vndFormat.format(input.getAttribute("size-price"));
}

var formObj = new Validation({
    formSelector: "#form__product",
    formBlockClass: "form__block",
    errorSelector: ".form__error",
    rules: [
        Validation.isRequiredRadio(`input[name="color"]`),
        Validation.isRequiredRadio(`input[name="size"]`),
    ],
    submitSelector: ".form__submit--add",
    onSubmit: addToCart,
})

function getFormData(form) {
    const productId = encodeURIComponent(form.querySelector('input[name="productId"]').value);
    const color = encodeURIComponent(form.querySelector('input[name="color"]').value);
    const size = encodeURIComponent(form.querySelector('input[name="size"]').value);
    const quantity = encodeURIComponent(form.querySelector('input[name="quantity"]').value);

    const formData = `productId=${productId}&color=${color}&size=${size}&quantity=${quantity}`;

    return formData;
}
function addToCart() {
    const form = document.getElementById("form__product");
    const formData = getFormData(form);
    $.ajax({
        url: "AddToCart",
        type: "POST",
        data: formData,
        contentType: "application/x-www-form-urlencoded",
        processData: false,
        success: function (data) {
            document.querySelector(".qlt__value").innerText = data
        },
        error: function (error) {
        },
    });
}