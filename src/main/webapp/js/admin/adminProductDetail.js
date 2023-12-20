


function addSize() {
    const addSizeBtn = document.querySelector(".form__add-size");
    const formSizes = document.querySelector(".form__sizes");
    addSizeBtn.onclick = function () {
        const formSizeHTML = `<div class="form__size" onclick="removeSize(this)">
                                        <input type="text" name="size" class="form__size-input">
                                            <i class="form__size-delete fa-solid fa-xmark" ></i>
                                    </div>`;
        formSizes.insertAdjacentHTML("beforeend", formSizeHTML);
    }
}

addSize();

function removeSize(formSize) {
    const formSizeDelete = formSize.querySelector(".form__size-delete");
    formSizeDelete.onclick = function (e) {
        formSize.remove();
    }
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

function getContent() {
    const content = editor.getData();
    console.log('Editor content:', content);
}

//Dropzone
Dropzone.autoDiscover = false;
var dropzone = new Dropzone('#dropzone', { // camelized version of the `id`
    paramName: "file", // The name that will be used to transfer the file
    maxFilesize: 100, // MB
    uploadMultiple: true,
    parallelUploads: 100,
    maxFiles: 5,
    dictDefaultMessage: 'Bạn có thể kéo ảnh hoặc click để chọn',
    previewsContainer: "#dropzone-preview",
    addRemoveLinks: true,
});
const newButton = document.createElement('button');
newButton.setAttribute('type', 'submit');
newButton.setAttribute('class', 'form__submit button button--hover');
newButton.textContent = 'Thêm sản phẩm';
newButton.addEventListener('click', getContent); // Attach the click event

// Append the button element to the container
form.appendChild(newButton);
// form.innerHTML += `<button type="submit" onclick="getContent()" class="form__submit button button--hover">Thêm sản phẩm</button>`;
