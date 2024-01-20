window.addEventListener('message', function (event) {
    (function () {
        const labelFiles = document.querySelectorAll(".category__file");
        labelFiles.forEach(function (labelFile) {
            loadImg(labelFile);
        });
        const buttonAddParameter = document.querySelector(".parameter__add");
        buttonAddParameter.onclick = function () {
            addParameter();
        }
    })();
    const receivedData = event.data;
    if (receivedData.state == 0) {
        function create() {
            let category = new FormData(form);
            $.ajax({
                url: "admin-create-category",
                type: "POST",
                contentType: false,
                processData: false,
                dataType: "json",
                data: category,
                cache: false,
                success: function (data) {
                    console.log(data)
                },
                error: function (error) {
                },
            });
        }
    }

    function deleteParameter(parameter) {
        const closeBtn = parameter.querySelector(".parameter__item-close");
        const idCount = parameter.getAttribute("id-count");
        closeBtn.onclick = function () {
            parameter.remove();
        }
        removeRule(`nameParameter${idCount}`);
        removeRule(`minValue${idCount}`);
        removeRule(`maxValue${idCount}`);
        removeRule(`guideImg${idCount}`);
    }

    function loadImg(label) {
        const inputFile = label.querySelector(`input[type="file"]`);
        inputFile.addEventListener('change', function () {
            const file = inputFile.files[0];
            if (file) {
                let imgElement = label.querySelector(".category__img");
                if (!imgElement) {
                    const html = `<img class="category__img" src="" alt="">`;
                    label.insertAdjacentHTML("beforeend", html);
                }
                imgElement = label.querySelector(".category__img");
                imgElement.src = URL.createObjectURL(file);
            }
        })
    }

    var countIdRule = 0;
    const parameterList = document.querySelector(".parameter__list");

    function addParameter() {
        countIdRule++;
        const html = `<div class="parameter__item" id-count="${countIdRule}">
                            <div class="parameter__grid">
                                <label class="category__label">
                                    <div class="category__title">Tên tham số
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Tên tham số, ví dụ: dài áo, ngang vai,...
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input name="nameParameter" id="nameParameter${countIdRule}" type="text" class="category__name category__input">
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
                                        <input type="text" name="unit" id="unit${countIdRule}" class="category__name category__input">
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
                                        <input type="text" name="minValue" id="minValue${countIdRule}" class="category__name category__input">
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
                                        <input type="text" name="maxValue" id="maxValue${countIdRule}" class="category__name category__input">
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
                                        <input name="guideImg" type="file" id="guideImg${countIdRule}" accept="image/*" hidden="hidden">
                                    </label>
                                    <p class="category__error"></p>
                                </div>
                            </label>
                              <span class="parameter__item-close" >
                                <i class="parameter__item-close-icon fa-solid fa-xmark"></i>
                            </span>
                        </div>`;
        parameterList.insertAdjacentHTML("beforeend", html);
        const lastElement = parameterList.lastElementChild;
        loadImg(lastElement.querySelector(`.category__file`));
        lastElement.addEventListener('click', function () {
            deleteParameter(lastElement);
        });
        pushRule(`nameParameter${countIdRule}`, Validation.isRequired(`#nameParameter${countIdRule}`));
        pushRule(`unit${countIdRule}`, Validation.isRequired(`#unit${countIdRule}`));
        pushRule(`minValue${countIdRule}`, Validation.isRequired(`#minValue${countIdRule}`));
        pushRule(`minValue${countIdRule}`, Validation.isNumber(`#minValue${countIdRule}`));
        pushRule(`minValue${countIdRule}`, Validation.smallerThan(`#minValue${countIdRule}`, `maxValue${countIdRule}`))
        pushRule(`maxValue${countIdRule}`, Validation.isRequired(`#maxValue${countIdRule}`));
        pushRule(`maxValue${countIdRule}`, Validation.isNumber(`#maxValue${countIdRule}`));
        pushRule(`maxValue${countIdRule}`, Validation.greaterThan(`#maxValue${countIdRule}`, `minValue${countIdRule}`))
        pushRule(`guideImg${countIdRule}`, Validation.isRequired(`#guideImg${countIdRule}`));
        loadRules();
        console.log(ruleObj)
    }

    let ruleArray = [
        // Validation.isRequired("#nameCategory"),
        // Validation.isRequired("#sizeTableImage"),
        // Validation.isRequired("#nameParameter"),
        // Validation.isRequired("#unit"),
        // Validation.isRequired("#minValue"),
        // Validation.isNumber("#minValue"),
        // Validation.isRequired("#maxValue"),
        // Validation.isNumber("#maxValue"),
        // Validation.isRequired("#guideImg"),
    ];
// --------------------------------------------------------
//Validate
    let validateCreateForm = new Validation({
        formSelector: ".category__form",
        formBlockClass: "category__block",
        errorSelector: ".category__error",
        rules: ruleArray,
        submitSelector: "#form__submit",
        onSubmit: create,
    })
    const form = document.querySelector('.category__form');
    let ruleObj = {
        nameCategory: [Validation.isRequired("#nameCategory")],
        sizeTableImage: [Validation.isRequired("#sizeTableImage")],
        nameParameter: [Validation.isRequired("#nameParameter")],
        unit: [Validation.isRequired("#unit")],
        minValue: [Validation.isRequired("#minValue"), Validation.isNumber("#minValue"), Validation.smallerThan("#minValue", "maxValue")],
        maxValue: [Validation.isRequired("#maxValue"), Validation.isNumber("#maxValue"), Validation.greaterThan("#maxValue", "minValue")],
        guideImg: [Validation.isRequired("#guideImg")],

    }
    loadRules();

    function loadRules() {
        ruleArray = [];
        for (const ruleObjKey in ruleObj) {
            ruleObj[ruleObjKey].forEach(function (rule) {
                ruleArray.push(rule);
            })
        }
        validateCreateForm = new Validation({
            formSelector: ".category__form",
            formBlockClass: "category__block",
            errorSelector: ".category__error",
            rules: ruleArray,
            submitSelector: "#form__submit",
            onSubmit: create,
        });
    }

    function pushRule(key, rule) {
        if (!Array.isArray(ruleObj[key])) {
            ruleObj[key] = [rule];
        } else {
            ruleObj[key].push(rule);
        }
    }

    function removeRule(key) {
        if (ruleObj[key]) {
            delete ruleObj[key];
        }
    }
});

