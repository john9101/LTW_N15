//Validate form
var ruleObj = {
    name: [Validation.isRequired("#name")],
    originalPrice: [Validation.isRequired("#originalPrice"), Validation.isNumber("#originalPrice")],
    salePrice: [Validation.isRequired("#salePrice"), Validation.isNumber("#salePrice")],
    description: [Validation.isRequired("#description")],
    nameSize: [Validation.isRequired("#nameSize")],
    sizePrice: [Validation.isRequired("#sizePrice"), Validation.isNumber("#sizePrice")],
    image: [Validation.isRequired("#image")],
};
var ruleArray = [];
loadRules();
var validate = new Validation({
    formSelector: ".product__form",
    formBlockClass: "form__block",
    errorSelector: ".form__error",
    rules: ruleArray,
    submitSelector: "#form__submit",
    onSubmit: addNewProduct,
});


function loadRules() {
    ruleArray = [];
    for (const key in ruleObj) {
        for (const keyElement of ruleObj[key]) {
            ruleArray.push(keyElement);
        }
    }
    validate = new Validation({
        formSelector: ".product__form",
        formBlockClass: "form__block",
        errorSelector: ".form__error",
        rules: ruleArray,
        submitSelector: "#form__submit",
        onSubmit: addNewProduct,
    });
}

function pushRule(selectorId, rule) {
    if (!Array.isArray(ruleObj[selectorId])) {
        ruleObj[selectorId] = [rule];
    } else {
        ruleObj[selectorId].push(rule);
    }
    loadRules();
}

function removeRule(selectorId) {
    delete ruleObj[selectorId];
    loadRules();
}


var countSize = 0;
function addSize() {
    const addSizeBtn = document.querySelector(".form__add-size");
    const formSizes = document.querySelector(".form__sizes");
    addSizeBtn.onclick = function () {
        countSize++;
        const formSizeHTML = `<div class="form__size" onclick="removeSize(this)">        
                                          <div class="form__block">
                                             <label>
                                                Tên kích thước
                                                <input type="text" name="nameSize"
                                                       class="form__size-input" id="nameSize_${countSize}">
                                            </label>
                                              <span class="form__error"></span>
                                          </div>
                                       <div class="form__block">
                                            <label class="form__size-price">
                                                Giá:
                                                <input type="text" id="sizePrice_${countSize}" name="sizePrice">
                                                <span>VNĐ</span>
                                            </label>
                                              <span class="form__error"></span>
                                        </div>
                                        <i class="form__size-delete fa-solid fa-xmark" ></i>    
                                      </div>`;
        formSizes.insertAdjacentHTML("beforeend", formSizeHTML);
        pushRule(`nameSize_${countSize}`, Validation.isRequired(`#nameSize_${countSize}`));
        pushRule(`sizePrice_${countSize}`, Validation.isRequired(`#sizePrice_${countSize}`));
        pushRule(`sizePrice_${countSize}`, Validation.isNumber(`#sizePrice_${countSize}`));
    }
}

addSize();

function removeSize(formSize) {
    const formSizeDelete = formSize.querySelector(".form__size-delete");
    const inputs = formSize.querySelectorAll(`input[name]`);
    for (const input of inputs) {
        removeRule(input.id);
    }
    formSizeDelete.onclick = function (e) {
        formSize.remove();
    }
    loadRules();
}

function addColor() {
    const addColorBtn = document.querySelector(".form__add-color");
    const formColors = document.querySelector(".form__colors");
    addColorBtn.onclick = function () {
        const formSizeHTML = `<div class="form__color" onclick="removeColor(this)">
                                        <input type="color" name="color" class="form__size-input">
                                            <i class="form__color-delete fa-solid fa-xmark" ></i>
                                    </div>`;
        formColors.insertAdjacentHTML("beforeend", formSizeHTML);
    }
}

addColor();

function removeColor(formColor) {
    const formSizeDelete = formColor.querySelector(".form__color-delete");
    formSizeDelete.onclick = function (e) {
        formColor.remove();
    }
}


const imgPreviews = document.querySelector(".img__previews");
const inputImg = document.querySelector(".img__input");

inputImg.onchange = function (e) {
    const files = e.target.files;
    const htmls = [];
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        if (!file.name.endsWith(".jpg") && !file.name.endsWith(".png") && !file.name.endsWith(".jpeg")) continue;
        htmls.push(`<div class="img__preview">
                      <img src="${URL.createObjectURL(file)}" alt="">
                   </div>`);
    }
    imgPreviews.innerHTML = htmls.join("");
}

const inputDesc = document.querySelector(`input[name = "description"]`)
editorCK.on('change', function () {
    inputDesc.value = editorCK.getData();
});


function getDataForm(form) {
    const formData = new FormData(form);
    return formData;
}

// Ajax
function addNewProduct() {
    const formElement = document.querySelector(".product__form");
    const product = getDataForm(formElement);
    const buttonForm = formElement.querySelector(`button[type="submit"]`);
    $.ajax({
        url: "admin-add-product",
        type: "POST",
        contentType: false,
        processData: false,
        dataType: "json",
        cache: false,
        data: product,
        success: function (data) {
            if (data.status === true) {
                notifySuccess();
            } else {
                notifyFailed();
            }
        },
        error: function (error) {
            console.log(error)
        },
    });
}

const toastList = document.querySelector(".toast__list");

function notifySuccess() {
    toastList.innerHTML =
        `<div class="toast" id="snackbar">
            <div class="toast__header">
                <span class="toast__icon-wrapper toast__icon--success">
                    <i class="toast__icon fa-solid fa-check"></i>
                </span>
                <strong class="toast__title">Thêm sản phẩm thành công</strong>
                <i class="toast__icon-close fa-solid fa-xmark"></i>
            </div>
            <div class="toast__body">
                Sản phẩm đã được thêm vào gian hàng.
            </div>
        </div>`;
    // Get the snackbar DIV
    const x = document.getElementById("snackbar");

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () {
        x.className = x.className.replace("show", "");
        x.remove();
    }, 3000);
}

function notifyFailed() {
    toastList.innerHTML =
        `<div class="toast" id="snackbar">
            <div class="toast__header">
                <span class="toast__icon-wrapper toast__icon--failed">
                    <i class="toast__icon fa-solid fa-xmark"></i>
                </span>
                <strong class="toast__title">Thêm sản phẩm không thành công thành công</strong>
                <i class="toast__icon-close fa-solid fa-xmark"></i>
            </div>
            <div class="toast__body">
                Sản phẩm đã có tên trên đã tồn tại vào gian hàng.
            </div>
        </div>`;
    // Get the snackbar DIV
    const x = document.getElementById("snackbar");

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () {
        x.className = x.className.replace("show", "");
        x.remove();
    }, 3000);
}

window.addEventListener('message', function(event) {
    // Access the received data
    const receivedData = event.data;
    console.log(receivedData);
});