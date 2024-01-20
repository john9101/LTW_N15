const iframeCreate = document.querySelector("#dialog-category-create .modal__product-iframe");
const modalCreateBtn = document.querySelector("#button-create-category");
const modalCreate = document.querySelector("#dialog-category-create");
const elementCloseCreate = getClose(modalCreate);

elementCloseCreate.onclick = function () {
    modalCreate.style.display = "none";
}

function getClose(modal) {
    return modal.querySelector(".modal__product-close");
}

modalCreateBtn.onclick = function () {
    const pageTarget = `${window.location.origin}/adminProductForm.jsp`;
    modalCreate.style.display = "block";
    // Send via iframe
    iframeCreate.contentWindow.postMessage({
        state: 0,
    }, pageTarget);
}