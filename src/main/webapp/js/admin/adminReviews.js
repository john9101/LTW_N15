//Read dialog
const iframeRead = document.querySelector("#dialog-review-read .modal__product-iframe");
const dataViewElement = document.querySelectorAll(".table__data-view");
const modalRead = document.querySelector("#dialog-review-read");
const elementCloseRead = getClose(modalRead);

function getClose(modal) {
    return modal.querySelector(".modal__review-close");
}

elementCloseRead.onclick = function () {
    modalRead.style.display = "none";
};

dataViewElement.forEach(function (element) {
    function getServletContext() {
        const currentURL = window.location.href;
        const substringToCut = '/adminReviews.jsp';
        const position = currentURL.indexOf(substringToCut);
        if (position !== -1) {
            // Extract the base URL
            const baseURL = currentURL.substring(0, position) + "/";
            return baseURL;
        }
        return null;
    }

    element.onclick = function () {
        const tableRow = this.parentNode;
        const reviewId = tableRow.querySelector(".table__data-id").textContent.trim();
        let pageTarget = getServletContext() + "admin-read-review?id=" + reviewId

        // Open dialog
        console.log(pageTarget)
        modalRead.style.display = "block";
        iframeRead.src = pageTarget;
    }
});

//Hide review
const dataHideElement = document.querySelectorAll(".table__data-visibility .button");
dataHideElement.forEach(function (element) {
    element.onclick = function () {
        // Get name product
        const tableRow = this.parentNode.parentNode;
        const idReview = tableRow.querySelector(".table__data-id").textContent.trim();
        // Show alert
        if (element.classList.contains("button__hide")) {
            hideProductAlert( idReview);
        }
        if (element.classList.contains("button__un-hide")) {
            unHideProductAlert(idReview);
        }

    }
});

function hideProductAlert( reviewId) {
    const message = `Bạn có muốn ẩn nhận xét này không?`;
    const result = window.confirm(message);
    if (result) {
        //     Handle
        $.ajax({
            url: "admin-hide-review?id=" + reviewId,
            type: "POST",
            contentType: false,
            processData: false,
            dataType: "json",
            cache: false,
            success: function (data) {
                const status = data.status;
                if (status) {
                    alert(`Ẩn nhận xét thành công`);
                } else {
                    alert(`Ẩn nhận xét không thành công`);
                }
            },
            error: function (error) {
            },
        });
    }
}

function unHideProductAlert(reviewId) {
    const message = `Bạn có muốn bỏ ẩn nhận xét không?`;
    const result = window.confirm(message);
    if (result) {
        //     Handle
        $.ajax({
            url: "admin-un-hide-review?id=" + reviewId,
            type: "POST",
            contentType: false,
            processData: false,
            dataType: "json",
            cache: false,
            success: function (data) {
                const status = data.status;
                if (status) {
                    alert(`Bỏ ẩn nhận xét thành công`);
                } else {
                    alert(`Bỏ ẩn nhận xét không thành công`);
                }
            },
            error: function (error) {
            },
        });
    }
}