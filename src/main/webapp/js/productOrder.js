// Form quantity
var quantityCurrent = 1;
var quantityInput = document.querySelector("#quantity");
var quantityDecrease = document.querySelector(".form___quantity--decrease");
var quantityIncrease = document.querySelector(".form___quantity--increase");
quantityDecrease.onclick = function () {
    if (quantityCurrent > 1) {
        quantityCurrent -= 1;
    }
    quantityInput.value = quantityCurrent;
}
quantityIncrease.onclick = function () {
    quantityCurrent += 1;
    quantityInput.value = quantityCurrent;
}
//Validate
var rules = [
    Validation.isRequiredRadio(`input[name="color"]`),
];
const quantityInputParameter = document.querySelectorAll(".order__log-padding .order__group").length;
for (let i = 0; i < quantityInputParameter; i++) {
    rules.push(Validation.isRequired(`#parameter${i}`));
    rules.push(Validation.isNumber(`#parameter${i}`));
    const minValue = document.querySelector(`#minValueParameter${i}`).innerText;
    const maxValue = document.querySelector(`#maxValueParameter${i}`).innerText;
    rules.push(Validation.range(`#parameter${i}`, minValue, maxValue));
}
console.log(rules)
let validation = new Validation({
    formSelector: ".form",
    formBlockClass: "order__group",
    errorSelector: ".order__error",
    rules: rules,
    submitSelector: "#order__submit",
    onSubmit: addToCart,
})

function addToCart() {
    console.log(1)
}