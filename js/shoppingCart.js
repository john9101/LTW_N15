const cartItems = [
    {
        productItem: {
            name: 'Áo polo nam trơn basic form regular vải cá sấu',
            color: 'Đen',
            requiredSize: '{"Dài áo":50,"Rộng vai":50,"Rộng ngực":50, "Dài tay":50}',
            image: '../assets/img/product_img/product1.jpg'
        },
        unitPrice: 279000,
        quality: 1,
    },
    {
        productItem: {
            name: 'Áo polo thể thao unisex nam nữ',
            color: 'Xanh navy',
            requiredSize: '{"Dài áo":50,"Rộng vai":50,"Rộng ngực":50, "Dài tay":50}',
            image: '../assets/img/product_img/product2.jpg'
        },
        unitPrice: 239000,
        quality: 1,
    },
    {
        productItem: {
            name: 'Áo polo phối khóa kéo unisex nam nữ',
            color: 'Beige',
            requiredSize: '{"Dài áo":50,"Rộng vai":50,"Rộng ngực":50, "Dài tay":50}',
            image: '../assets/img/product_img/product3.jpg'
        },
        unitPrice: 289000,
        quality: 1,
    }
];

function formatCurrency(amount) {
    return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(amount);
}

function getAmountPrice(amountCurrency) {
    return parseFloat(amountCurrency.replaceAll('₫', '').replaceAll('.', ''));
}

function removeCartItem(cartItems, index) {
    if (index > -1) {
        cartItems.splice(index, 1);
    }
}

function updateProvisionalItemNo(){
    const provisionalPriceText = document.querySelector('.price__text:first-child');
    provisionalPriceText.textContent = `Tạm tính (${cartItems.length} mẫu đồ)`;
}
updateProvisionalItemNo();

function renderCartItem(cartItems) {
    const cartItemsElement = document.querySelector(".cart__items");
    const shoppingCart = cartItems.map(cartItem => {
        return `<div class="cart__item">
                        <div class="cart__detail--info grid__cart--template">
                            <div class="product__item">
                                <a class="product__image" href="#"> <!-- Back-to-detail_product-page-->
                                    <img src='${cartItem.productItem.image}'>
                                </a>
                                <div class="order__product--info">
                                    <a href="#" class="product__name">${cartItem.productItem.name}</a> <!-- Back-to-detail_product-page-->
                                    <p class="order__color">Màu sắc: ${cartItem.productItem.color}</p>
                                    <ul class="order__size--specification">
                                        Kích thước:
                                    </ul>
                                    <div class="edit__wishlist--button">
                                        <button class="edit--button"><i class="fa-solid fa-pen-to-square"></i> Chỉnh sửa</button>
                                        <button class="wishlist--button"><i class="fa-solid fa-heart"></i> Yêu thích</button>
                                    </div>
                                </div>
                            </div>
                            <span class="unit__price">${formatCurrency(cartItem.unitPrice)}</span>
                            <form class="quality__swapper">
                                <button class="minus__quality change__quality"><i class="fa-solid fa-minus"></i></button>
                                <input type="number" name="quality__required" class="quality__required" min="1" value="${cartItem.quality}">
                                <button class="plus__quality change__quality"><i class="fa-solid fa-plus"></i></button>
                            </form>
                            <span class="subtotal__item">${formatCurrency(cartItem.unitPrice * cartItem.quality)}</span>
                            <span class="remove__action"><i class="fa-solid fa-trash-can"></i></span>
                        </div>
                        </div>`
    });
    const cartItemsHTML = shoppingCart.join('');
    cartItemsElement.innerHTML = cartItemsHTML;

    const orderSizeSpecs = document.querySelectorAll('.order__size--specification');
    console.log(orderSizeSpecs);
    orderSizeSpecs.forEach((orderSizeSpec, index) =>{
        const requiredSizeObject = JSON.parse(cartItems[index].productItem.requiredSize);
        for (const key in requiredSizeObject){
            const sizeSpecItem = document.createElement('li');
            sizeSpecItem.classList.add('size__spec--item');
            sizeSpecItem.textContent = `${key}: ${requiredSizeObject[key]} cm` ;
            orderSizeSpec.appendChild(sizeSpecItem);
        }
    })
}
renderCartItem(cartItems);

const voucherItems = [
    {
        voucherID: "MGG25",
        description: "Mã giảm giá 25.000 ₫",
        minimumPrice: 200000,
        discountPrice: 25000
    },
    {
        voucherID: "MGG35",
        description: "Mã giảm giá 35.000 ₫",
        minimumPrice: 250000,
        discountPrice: 35000
    },
    {
        voucherID: "MGG50",
        description: "Mã giảm giá 50.000 ₫",
        minimumPrice: 400000,
        discountPrice: 50000
    },
    {
        voucherID: "MGG70",
        description: "Mã giảm giá 70.000 ₫",
        minimumPrice: 550000,
        discountPrice: 70000
    },
    {
        voucherID: "MGG100",
        description: "Mã giảm giá 100.000 ₫",
        minimumPrice: 700000,
        discountPrice: 100000
    },
    {
        voucherID: "MGG150",
        description: "Mã giảm giá 150.000 ₫",
        minimumPrice: 850000,
        discountPrice: 150000
    },
    {
        voucherID: "MGG200",
        description: "Mã giảm giá 200.000 ₫",
        minimumPrice: 1000000,
        discountPrice: 200000
    },
    {
        voucherID: "MGG300",
        description: "Mã giảm giá 300.000 ₫",
        minimumPrice: 1500000,
        discountPrice: 300000
    },
    {
        voucherID: "MGG350",
        description: "Mã giảm giá 350.000 ₫",
        minimumPrice: 2000000,
        discountPrice: 350000
    },
    {
        voucherID: "MGG400",
        description: "Mã giảm giá 400.000 ₫",
        minimumPrice: 2500000,
        discountPrice: 400000
    }
];

const voucherIDs = voucherItems.map((voucherItem) => {
    return voucherItem.voucherID
});

const cartItemElements = document.querySelectorAll(".cart__item");
const minusButtonElements = document.querySelectorAll(".minus__quality");
const plusButtonElements = document.querySelectorAll(".plus__quality");
const qualityRequiredElements = document.querySelectorAll(".quality__required");
const subtotalItemElements = document.querySelectorAll(".subtotal__item");
const unitPriceElements = document.querySelectorAll(".unit__price");
const removeButtonElements = document.querySelectorAll(".remove__action");
const priceValueElements = document.querySelectorAll(".price__value");
const promotionCodeElement = document.getElementById("promotion_code");
const applyCodeElement = document.getElementById("apply");
const applyStatusElement = document.querySelector(".apply__status");
const totalPriceValueElement = document.querySelector(".price__value--final");

function displayShoppingCart() {
    function updateSubtotal(index) {
        const quantity = qualityRequiredElements[index].value;
        const unitPrice = getAmountPrice(unitPriceElements[index].textContent);
        const subtotal = quantity * unitPrice;
        subtotalItemElements[index].textContent = formatCurrency(subtotal);
    }

    function calculateProvisionalPrice() {
        let provisionalPrice = 0;
        subtotalItemElements.forEach(subtotalItem => {
            const subtotal = getAmountPrice(subtotalItem.textContent);
            provisionalPrice += subtotal;
        });
        return provisionalPrice;
    }
    calculateProvisionalPrice();

    function updateProvisionalPrice() {
        const provisionalPrice = calculateProvisionalPrice();
        priceValueElements[0].textContent = formatCurrency(provisionalPrice);
        appliedOrUnappliedVoucher();
    }
    updateProvisionalPrice();

    function updateTotalPriceValue() {
        const provisionalPrice = getAmountPrice(priceValueElements[0].textContent);
        let discountPrice;
        if (priceValueElements[1].textContent === "") {
            discountPrice = 0;
        } else {
            discountPrice = getAmountPrice(priceValueElements[1].textContent);
        }
        totalPriceValueElement.textContent = formatCurrency(provisionalPrice - discountPrice);
    }
    updateTotalPriceValue();

    function appliedOrUnappliedVoucher() {
        const promotionCodeValue = promotionCodeElement.value;
        const priceItemDiscount = document.querySelector(".price__item:last-child");
        if (promotionCodeValue !== "") {
            voucherItems.forEach(voucherItem => {
                if (promotionCodeValue === voucherItem.voucherID) {
                    if (getAmountPrice(priceValueElements[0].textContent) >= voucherItem.minimumPrice) {
                        applyStatusElement.textContent = `Đã áp dụng mã ${promotionCodeValue}`;
                        applyStatusElement.classList.remove("invalid")
                        applyStatusElement.classList.add("valid")
                        priceItemDiscount.style.display = 'flex';
                        priceValueElements[1].textContent = formatCurrency(voucherItem.discountPrice);
                    } else {
                        applyStatusElement.textContent = `Không đủ điều kiện áp dụng mã ${promotionCodeValue}`;
                        applyStatusElement.classList.remove("valid")
                        applyStatusElement.classList.add("invalid")
                        priceItemDiscount.style.display = 'none';
                        priceValueElements[1].textContent = formatCurrency(0);
                    }
                    updateTotalPriceValue();
                } else if (!voucherIDs.includes(promotionCodeValue)) {
                    applyStatusElement.textContent = `Không tồn tại mã ${promotionCodeValue}`;
                    applyStatusElement.classList.remove("valid")
                    applyStatusElement.classList.add("invalid")
                    priceValueElements[1].textContent = formatCurrency(0);
                    priceItemDiscount.style.display = 'none';
                    updateTotalPriceValue();
                }
            });
        }
    }
    appliedOrUnappliedVoucher();

    applyCodeElement.addEventListener("click", (event) => {
        event.preventDefault();
        appliedOrUnappliedVoucher();
    });

    minusButtonElements.forEach((minusButton, index) => {
        minusButton.addEventListener("click", (event) => {
            event.preventDefault();
            if (qualityRequiredElements[index].value > 1) {
                qualityRequiredElements[index].value--;
                updateSubtotal(index);
                updateProvisionalPrice()
                updateTotalPriceValue();
            }
        })
    })

    plusButtonElements.forEach((plusButton, index) => {
        plusButton.addEventListener("click", (event) => {
            event.preventDefault();
            qualityRequiredElements[index].value++;
            updateSubtotal(index);
            updateProvisionalPrice();
            updateTotalPriceValue();
        });
    });

    removeButtonElements.forEach((removeButton, index) => {
        removeButton.addEventListener("click", () => {
            cartItemElements[index].classList.add("fade--out");
            let subtotal = getAmountPrice(subtotalItemElements[index].textContent);
            let provisionalPrice = getAmountPrice(priceValueElements[0].textContent);
            provisionalPrice -= subtotal;
            priceValueElements[0].textContent = formatCurrency(provisionalPrice);

            //cartItemElements[index].parentElement.childElementCount

            if (cartItems.length - 1 === 0) {
                setTimeout(() => {
                    document.querySelector(".cart__container").innerHTML = `<div class="cart__container--empty">
                                                                                        <p>Không có sản phẩm nào trong giỏ hàng của bạn</p>
                                                                                        <button>Tiếp tục mua sắm</button>
                                                                                        <img src="../assets/img/continueShopping.svg">
                                                                                    </div>`;
                }, 1)
            } else {
                setTimeout(() => {
                    cartItemElements[index].remove();
                    console.log(cartItems[index]);
                    removeCartItem(cartItems, index);


                    updateProvisionalItemNo();
                    subtotalItemElements[index].textContent = formatCurrency(0);
                    qualityRequiredElements[index].value = 0;
                    unitPriceElements[index].textContent = formatCurrency(0);
                }, 300);
            }
            appliedOrUnappliedVoucher();
            updateTotalPriceValue();
        });
    });

}
displayShoppingCart();