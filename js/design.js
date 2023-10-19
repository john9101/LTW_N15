// Defined properties to draw canvas
var imgShirt = undefined;
var backgroundShirt = undefined;
var text = undefined;
var img = undefined;
var shapes = [];
//Choose design__frame
var designButton = document.querySelectorAll(".design-aside__item");
var designFrame = document.querySelectorAll(".design__frame");

designButton.forEach(function (element, index) {
    element.onclick = function (e) {
        designButton.forEach(element => element.classList.remove("design-aside__item--clicked"))
        element.classList.add("design-aside__item--clicked");
        designFrame.forEach(element => element.classList.remove("design__frame--show"))
        designFrame[index].classList.add("design__frame--show");
    }
});

// Click to choose color
var colorInput = document.querySelector("#color__picker");

var design__img = document.querySelector(".design__img img");
colorInput.oninput = function (e) {
    backgroundShirt = e.target.value;
    // design__img.style.backgroundColor = color;
    canvas();
}

// Click to choose Image insert
var imageButton = document.querySelector(".form__chose-img");
var imageInput = document.querySelector("#file");
imageButton.onclick = function () {
    imageInput.click();
};

// Show img preview
var previewImg = document.querySelector(".form__preview-img");
const loadImage = function () {
    let file = imageInput.files[0];
    if (!file) return;
    previewImg.src = URL.createObjectURL(file)
}
imageInput.addEventListener("change", loadImage);

// Click to choose text
var textInput = document.querySelector(".form__choose-text")
textInput.oninput = function (e) {
    text = this.value;
    console.log(text);
    canvas();
}

// Draw Canvas
function canvas() {
    const canvas = document.querySelector(".design__canvas");
    const ctx = canvas.getContext("2d");
    canvas.width = design__img.width;
    canvas.height = design__img.height;
    ctx.fillStyle = backgroundShirt;
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    if (design__img) ctx.drawImage(design__img, 0, 0, canvas.width, canvas.height);
    if (text) {
        ctx.font = "30px Arial";
        ctx.fillText(text, 50, 50);
    }
}

var canvas = document.querySelector(".design__canvas");
// let mouseDown = function (event) {
//     let startX = parseInt(event.clientX);
//     let startY = parseInt(event.clientY);
//
//
//
// }
// canvas.addEventListener("mousedown", mouseDown)
