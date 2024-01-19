(function () {
    const labelFiles = document.querySelectorAll(".category__file");
    labelFiles.forEach(function (labelFile) {
        loadImg(labelFile)
    });
})();
const buttonAddParameter = document.querySelector(".parameter__add");
const parameterList = document.querySelector(".parameter__list")
buttonAddParameter.onclick = function () {
    const html = `<div class="parameter__item">
                            <div class="parameter__grid">
                                <label class="category__label">
                                    <div class="category__title">Tên tham số
                                        <i class="category__icon-guide fa-solid fa-circle-info">
                                        </i>
                                        <div class="category__guide">Tên tham số, ví dụ: dài áo, ngang vai,...
                                        </div>
                                    </div>
                                    <div class="category__block">
                                        <input type="text" class="category__name category__input">
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
                                        <input type="text" name="minValue" class="category__name category__input">
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
                                        <input type="text" name="minValue" class="category__name category__input">
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
                                        <input type="text" name="maxValue" class="category__name category__input">
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
                                        <input type="file" accept="image/*" hidden="hidden">
                                    </label>
                                    <p class="category__error"></p>
                                </div>
                            </label>
                            <span class="parameter__item-close" onclick="deleteParent(this)">
                                <i class="parameter__item-close-icon fa-solid fa-xmark"></i>
                            </span>
                        </div>`;
    parameterList.insertAdjacentHTML("beforeend", html);
    const lastElement = parameterList.lastElementChild;
    loadImg(lastElement.querySelector(`.category__file`));
}

function deleteParent(childElement) {
    childElement.parentElement.remove();
}

function loadImg(label) {
    const img = label.querySelector(".category__img");
    const inputFile = label.querySelector(`input[type="file"]`);
    inputFile.onchange = function (event) {
        const firstImg = event.target.files[0];
        if (firstImg) {
            label.insertAdjacentHTML("beforeend", `    <img class="category__img" src="${URL.createObjectURL(firstImg)}" alt="">`)
        }
    }
}