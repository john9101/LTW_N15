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
}
// Show img preview
var previewImg = document.querySelector(".form__preview-img");
const loadImage = function () {
    let file = imageInput.files[0];
    if (!file) return;
    let image = URL.createObjectURL(file);
    previewImg.src = image;
    shapes.push({
        image: image,
        x: 0,
        y: 0,
        width: 200,
        height: 200,
    })
    drawSVG();
}

// Click to choose Image insert
var imageButton = document.querySelector(".form__chose-img");
var imageInput = document.querySelector("#file");
imageButton.onclick = function () {
    imageInput.click();
};
imageInput.addEventListener("change", loadImage);

// Click to choose Text insert
var textInput = document.querySelector("#text");
textInput.onchange = function (){
    let text = textInput.value;
    shapes.push({
        text: text,
        x: 0,
        y: 0,
        width: 200,
        height: 200,
    })
    drawSVG();
}

// Draw svg
function drawSVG() {
    const svgElement = document.querySelector(".design__img-decor");
    shapes.forEach(function (shape) {
        let decorElement = null;
        if (shape.image) {
            decorElement = `<g><image href="${shape.image}" height="200" width="200" x ="0" y="0"/></g>`;
            svgElement.innerHTML = decorElement;
            addPressAndHoldEvent(document.querySelector("image"))
        }
        if (shape.text) {
            decorElement = `<g><text x ="0" y="0" color="black"> ${shape.text}</text></g>`;
            svgElement.innerHTML = decorElement;
            addPressAndHoldEvent(document.querySelector("text"))
        }

    });
}

function addPressAndHoldEvent(element) {
    let offset = {
        x: 0,
        y: 0
    }
    element.addEventListener('mousedown', (event) => {
        offset.x = event.clientX;
        offset.y = event.clientY;
        element.addEventListener("mousemove", updatePosition);
        console.log(offset);
    });
    window.addEventListener("mouseup", (event) => {
        console.log(1)
        element.removeEventListener("mousemove", updatePosition);
    })

    function updatePosition(event) {
        let x = event.clientX - offset.x;
        let y = event.clientY - offset.y;
        let transformValue = `translate(${x}, ${y})`;
        console.log("X:" + x + " y: " + y);
        const parentElement = element.parentElement;
        parentElement.setAttribute('transform', transformValue);
    }
}

// Save img after design
