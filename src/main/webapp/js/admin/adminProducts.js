// Date format (now)
const dateInputs = document.querySelectorAll(`input[type="date"]`);
dateInputs.forEach(function (dateInput) {
// Get today's date
    const today = new Date();

// Format today's date as yyyy-mm-dd (required by input type="date")
    const formattedToday = today.toISOString().split('T')[0];

    // Set the default value to today's date in dd/mm/yyyy format
    dateInput.value = formattedToday;
})

//View product
const iframe = document.querySelector(".modal__product-iframe");
// Get the current window's origin
const currentOrigin = window.location.origin;
const dataViewElement = document.querySelectorAll(".table__data-view");
const modalView = document.querySelector("#dialog-product-view");
const elementClose = document.querySelector(".modal__product-close");
elementClose.onclick = function (){
    modalView.style.display = "none";
}
dataViewElement.forEach(function (element) {
    element.onclick = function () {
        // Open dialog
        modalView.style.display = "block";
        // Send via iframe
        const tableRow = this.parentNode;
        const productId = tableRow.querySelector(".table__data-id").textContent.trim();
        iframe.contentWindow.postMessage(productId, `${currentOrigin}/addNewProduct.jsp`);
    }

})