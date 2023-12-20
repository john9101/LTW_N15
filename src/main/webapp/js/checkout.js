const deliveryInfoRadioButtons = document.querySelectorAll(".delivery__info--container .radio__button");
const paymentMethodRadioButtons = document.querySelectorAll(".payment__method--container .radio__button");
const customizeDeliveryInfo = document.getElementById("customize__info--form");

function sectionSelectionHandleEvent(radioButtonElements) {
    let preRadioButtonElement = null;
    radioButtonElements.forEach((radioButtonElement, index) => {
        radioButtonElement.addEventListener("change", () => {
            if (preRadioButtonElement) {
                Object.assign(preRadioButtonElement.parentElement.style, {
                    backgroundColor: null,
                    color: null,
                    opacity: null
                })
            }
            if (radioButtonElement.checked) {
                Object.assign(radioButtonElement.parentElement.style, {
                    backgroundColor: "var(--blue-color-medium)",
                    color: "white",
                    opacity: "0.8"
                })
                preRadioButtonElement = radioButtonElement;
            }

            if (radioButtonElements === deliveryInfoRadioButtons) {
                if (index === radioButtonElements.length - 1) {
                    customizeDeliveryInfo.querySelectorAll('.error__notice').forEach(errorNotice => {
                        errorNotice.textContent = "";
                    });

                    Object.assign(customizeDeliveryInfo.style, {
                        display: "grid",
                        gap: "24px"
                    })
                } else {
                    customizeDeliveryInfo.style.display = "none"
                }
            }
        })
    })
}
sectionSelectionHandleEvent(deliveryInfoRadioButtons)
sectionSelectionHandleEvent(paymentMethodRadioButtons)

function ValidatorCustomizeDeliveryForm(options) {
    let selectorRules = {};

    function getRightParent(element, selector) {
        while (element.parentElement) {
            if (element.parentElement.matches(selector)) {
                return element.parentElement;
            } else {
                element = element.parentElement;
            }
        }
    }

    function validate(inputElement, rule, errorMessageElement) {
        let errorMessage;
        let arrayRules = selectorRules[rule.selector]
        for (let i = 0; i < arrayRules.length; i++) {
            errorMessage = arrayRules[i](inputElement.value);
            if (errorMessage) {
                break;
            }
        }

        if (errorMessage) {
            errorMessageElement.innerText = errorMessage;
            errorMessageElement.style.color = '#E40F0A';
            inputElement.classList.add('input__invalid')
        } else {
            errorMessageElement.innerText = '';
            inputElement.classList.remove('input__invalid')
        }
        return !errorMessage;
    }

    let customizeInfoForm = document.querySelector(options.form);
    if (customizeInfoForm) {
        customizeInfoForm.onsubmit = (event) => {
            event.preventDefault();
            let isFormValid = true;
            options.rules.forEach(rule => {
                let inputElement = customizeInfoForm.querySelector(rule.selector);
                let errorMessageElement = getRightParent(inputElement, options.formBlockSelector).querySelector(options.errorSelector);
                let isValid = validate(inputElement, rule, errorMessageElement);
                if (!isValid) {
                    isFormValid = false;
                }
            });

            if (isFormValid) {
                if (typeof options.onSubmit === 'function') {
                    let enableInput = customizeInfoForm.querySelectorAll('[name]:not([disabled])');
                    let formValues = Array.from(enableInput).reduce(function (values, input) {
                        values[input.name] = input.value
                        return values;
                    }, {});
                    options.onSubmit(formValues);
                } else {
                    customizeDeliveryInfo.submit();
                }
            }
        }
        options.rules.forEach(rule => {
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);
            } else {
                selectorRules[rule.selector] = [rule.test];
            }
            const inputElement = customizeInfoForm.querySelector(rule.selector);
            let errorMessageElement = getRightParent(inputElement, options.formBlockSelector).querySelector(options.errorSelector);
            if (inputElement) {
                inputElement.onblur = () => {
                    validate(inputElement, rule, errorMessageElement);
                }
                inputElement.oninput = () => {
                    errorMessageElement.innerText = '';
                    inputElement.classList.remove('input__invalid')
                }
            }
        })


        options.rules.forEach(function (rule) {
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);
            } else {
                selectorRules[rule.selector] = [rule.test];
            }
            let inputElement = customizeInfoForm.querySelector(rule.selector);
            let errorMessageElement = getRightParent(inputElement, options.formBlockSelector).querySelector(options.errorSelector);
            if (inputElement) {
                inputElement.onblur = function () {
                    validate(inputElement, rule, errorMessageElement);
                }
                inputElement.oninput = function () {
                    errorMessageElement.innerText = '';
                    inputElement.classList.remove('input-invalid')
                }

                inputElement.onfocus = function () {
                    errorMessageElement.innerText = '';
                }
            }
        });
    }
}

ValidatorCustomizeDeliveryForm.isRequired = (selector) => {
    return {
        selector: selector,
        test: (value) => {
            return value.trim() ? undefined : 'Vui lòng bạn nhập trường này'
        }
    }
}

ValidatorCustomizeDeliveryForm.isEmail = (selector) => {
    return {
        selector: selector,
        test: (value) => {
            const regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value.trim()) ? undefined : 'Thông tin bạn nhập không phải là email'
        }
    }
}

ValidatorCustomizeDeliveryForm.isPhone = (selector) => {
    return {
        selector: selector,
        test: (value) => {
            const regex = /(84|0[0-9])+([0-9]{8})\b/g;
            return regex.test(value.trim()) ? undefined : 'Vui lòng nhập số điện thoại hợp lệ (10 số bắt đầu từ 0)'
        }
    }
}

function getCartItemsLastArray() {
    const cartItemsRequiredJSON = localStorage.getItem('cartItemsRequired');
    localStorage.setItem("cartItemsLast", cartItemsRequiredJSON);
    let cartItemsLastArray = [];
    const cartItemsLastObject = JSON.parse(cartItemsRequiredJSON);
    for (let item in cartItemsLastObject) {
        cartItemsLastArray.push(cartItemsLastObject[item]);
    }
    return cartItemsLastArray;
}

function renderCartItemsLast() {
    const cartItemsLastArray = getCartItemsLastArray();
    const orderTableElement = document.querySelector(".order__table");
    const cartItemsList = cartItemsLastArray.map((cartItem, index) => {
        return `<tr class="row__content">
                            <td class="td__item">${index + 1}</td>
                            <td class="td__item">
                                <div class="product__item">
                                    <img src='${cartItem.productItem.image}'>
                                    <div class="order__product--info">
                                        <p class="product__name">${cartItem.productItem.name}</p>
                                        <p class="order__color">Màu sắc: ${cartItem.productItem.color}</p>
                                    </div>
                                </div>
                            </td>
                            <td class="td__item">${cartItem.quality}</td>
                            <td class="td__item">${formatCurrency(cartItem.unitPrice)}</td>
                        </tr>`
    })
    const cartItemsHTML = cartItemsList.join('');
    orderTableElement.innerHTML += cartItemsHTML;
    document.querySelector('.total__value').textContent = localStorage.getItem("totalPriceValue");
}
renderCartItemsLast();

function validateRadioSections() {
    const placeOrderButton = document.querySelector(".place__order");
    placeOrderButton.addEventListener('click', ()=>{
        const radioSections = document.querySelectorAll('.radio__section');
        let allSectionsSelected = true;
        radioSections.forEach(radioSection => {
            const radioButtons = radioSection.querySelectorAll('.radio__button');
            const errorMessage = radioSection.parentElement.querySelector('.non__selected');
            let sectionSelected = false;

            radioButtons.forEach(radioButton => {
                if (radioButton.checked) {
                    sectionSelected = true;
                }
            });

            if (!sectionSelected) {
                allSectionsSelected = false;
                errorMessage.style.display = 'block';
            } else {
                errorMessage.style.display = 'none';
            }
        });

        if (allSectionsSelected) {
            window.location.href = '../index.jsp';
            localStorage.setItem('resetShoppingCart', JSON.stringify([]));
        }
    })
    const radioButtons = document.querySelectorAll('.radio__button');
    radioButtons.forEach(radioButton =>{
        radioButton.addEventListener("click", ()=>{
            const radioSection = radioButton.closest(".radio__section");
            const errorMessage = radioSection.parentElement.querySelector('.non__selected');
            errorMessage.style.display = 'none';
        })
    })
}
validateRadioSections();