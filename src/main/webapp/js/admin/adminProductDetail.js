//Validate form
var ruleObj = {
    name: [Validation.isRequired("#name")],
    originalPrice: [Validation.isRequired("#originalPrice"), Validation.isNumber("#originalPrice")],
    salePrice: [Validation.isRequired("#salePrice"), Validation.isNumber("#salePrice")],
    description: [Validation.isRequired("#description")],
    nameSize: [Validation.isRequired("#nameSize")],
    sizePrice: [Validation.isRequired("#sizePrice"), Validation.isNumber("#sizePrice")],
};
var ruleArray = [];
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

const form = document.querySelector(".product__form");

form.onsubmit = function (e) {
    e.preventDefault();
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
const inputDesc = document.querySelector("#description")
editorCK.on('change', function () {
    inputDesc.value = editorCK.getData();
});


function getDataForm(form) {
    const name = form.querySelector(`input[name ="name"]`);
    const selectedIdCategory = form.querySelector(`select[name ="idCategory"]`).selectedIndex;
    const idCategory = form.querySelector(`select[name ="idCategory"]`).options[selectedIdCategory];
    const originalPrice = form.querySelector(`input[name ="originalPrice"]`);
    const salePrice = form.querySelector(`input[name ="salePrice"]`);
    const description = editorCK.getData();
    const nameSizes = form.querySelectorAll(`input[name ="nameSize"]`);
    const priceSizes = form.querySelectorAll(`input[name ="sizePrice"]`);
    const colors = form.querySelectorAll(`input[name ="color"]`);
    function getSizes() {
        return Array.from(nameSizes).map(function (size, index) {
            return {
                nameSize: size.value,
                sizePrice: parseInt(priceSizes[index].value),
            }
        });
    }

    function getColors() {
        return Array.from(colors).map(function (color) {
            return color.value;
        });
    }

    const product = {};
    product.name = name.value;
    product.idCategory = idCategory.value;
    product.originalPrice = parseInt(originalPrice.value);
    product.salePrice = parseInt(salePrice.value);
    product.description = description;
    product.sizes = getSizes();
    product.colors = getColors();

    const formData = new FormData(form);

    // Append the file data to the form data
    // const inputFile = document.querySelector(".img__input");
    // if (inputFile && inputFile.files) {
    //     for (let i = 0; i < inputFile.files.length; i++) {
    //         formData.append('image', inputFile.files[i]);
    //     }
    // }
    return formData;
}

// Ajax
function addNewProduct() {
    const formElement = document.querySelector(".product__form");
    const product = getDataForm(formElement);
    $.ajax({
        url: "admin-add-product",
        type: "POST",
        contentType: false,
        processData: false,
        dataType: "json",
        cache: false,
        data: product,
        success: function (data) {
            console.log("Thêm sản phẩm thành công");
        },
        error: function (error) {

        },
    });

}