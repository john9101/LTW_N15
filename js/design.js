// Defined properties to draw canvas
var imgShirt = undefined;
var backgroundShirt = undefined;
var text = undefined;
var img = undefined;

var shapes = [];
var canvasShapeCurrent = null;

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
var design__img = document.querySelector(".design__img");
colorInput.oninput = function (e) {
    backgroundShirt = e.target.value;
    design__img.style.backgroundColor = backgroundShirt;
    // canvas();
}

// Click to choose Image insert
var imageButton = document.querySelector(".form__chose-img");
var imageInput = document.querySelector("#file");
imageButton.onclick = function () {
    imageInput.click();

};

// // Show img preview
// var previewImg = document.querySelector(".form__preview-img");
// const loadImage = function () {
//     let file = imageInput.files[0];
//     if (!file) return;
//     let image = URL.createObjectURL(file);
//     previewImg.src = image;
//     shapes.push({
//         value: image,
//         x: 0,
//         y: 0,
//         width: 200,
//         height: 200,
//     })
//     canvas();
// }
// imageInput.addEventListener("change", loadImage);
//
// // Click to choose text
// var textInput = document.querySelector(".form__choose-text")
// textInput.onblur = function (e) {
//     text = this.value;
//     shapes.push({
//         value: text,
//         x: 0,
//         y: 0,
//         width: text.width,
//         height: text.height,
//     })
//     canvas();
// }
//
// // Draw Canvas
// const canvasElement = document.querySelector(".design__canvas");
// const contextCanvas = canvasElement.getContext("2d");
// canvasElement.width = design__img.width;
// canvasElement.height = design__img.height;
//
// function baseDrawCanvas() {
//     contextCanvas.fillStyle = backgroundShirt;
//     contextCanvas.fillRect(0, 0, canvasElement.width, canvasElement.height);
// }
//
// function canvas() {
//     contextCanvas.clearRect(0, 0, canvasElement.width, canvasElement.height);
//     baseDrawCanvas();
//
//     if (design__img) contextCanvas.drawImage(design__img, 0, 0, canvasElement.width, canvasElement.height);
//     // if (text) {
//     //     ctx.font = "30px Arial";
//     //     ctx.fillText(text, 50, 50);
//     // }
//     console.log(shapes);
// }
//
// // Drag and drop canvas
// // Đựa tất cả các shape muốn chèn vào shape[{}, {}]
// // Mỗi phần tử có property: value, x, y, width, height
// // Function draw_shape để vẽ lại hình
// // Mặc định luôn vẽ imgProduct
// var isMouseInShape = function (x, y, shape){
//
// }
//
// let mouseDown = function (event) {
//     let startX = parseInt(event.clientX);
//     let startY = parseInt(event.clientY);
//
//     let index = 0;
//     for (let shape of shapes) {
//         if (isMouseInShape(x, y, shape))
//             canvasShapeCurrent = index;
//         index++;
//     }
//
// }
// canvas.addEventListener("mousedown", mouseDown)
