function sliderImageController() {
    const sliderItemsElement = document.querySelector(".slider__items");
    const prevButtonElement = document.querySelector(".nav__prev");
    const nextButtonElement = document.querySelector(".nav__next");
    const sliderWidth = sliderItemsElement.clientWidth;
    let currentIndex = 0;
    const indicators = document.querySelectorAll(".indicator");

    function slideTo(index) {
        sliderItemsElement.style.transform = `translateX(-${index * sliderWidth}px)`;
        updateIndicators(index);
    }

    window.addEventListener("resize", () => {
        const imageItems = sliderItemsElement.querySelectorAll(".slider__item")
        imageItems.forEach((item) => {
            item.style.width = `${sliderWidth}px`;
        });
    });

    function updateIndicators(index) {
        indicators.forEach((indicator, i) => {
            if (i === index) {
                indicator.classList.add("active");
            } else {
                indicator.classList.remove("active");
            }
        });
    }

    indicators.forEach((indicator, index) => {
        indicator.addEventListener("click", function () {
            currentIndex = index;
            slideTo(currentIndex);
        });
    });

    function nextSlide() {
        if (currentIndex < sliderItemsElement.childElementCount - 1) {
            currentIndex++;
        } else {
            currentIndex = 0;
        }
        slideTo(currentIndex);
    }

    nextButtonElement.addEventListener("click", function () {
        nextSlide();
    });

    prevButtonElement.addEventListener("click", function () {
        if (currentIndex > 0) {
            currentIndex--;
            slideTo(currentIndex);
        }
    });

    let interval = setInterval(nextSlide, 2000);

    sliderItemsElement.addEventListener('mouseover', function () {
        clearInterval(interval);
    });

    sliderItemsElement.addEventListener("mouseout", function () {
        interval = setInterval(nextSlide, 2000);
    })
}
sliderImageController();

function animationShowCategory() {
    const categoryItems = document.querySelectorAll(".category__item")
    let currentIndex = 0;

    function displayCategoryItem() {
        if (currentIndex < categoryItems.length) {
            categoryItems[currentIndex].style.display = "flex";
            currentIndex++;
            setTimeout(displayCategoryItem, 800)
        } else {
            currentIndex = 0;
            categoryItems.forEach(category_item => {
                category_item.style.display = "none"
            });
            setTimeout(displayCategoryItem, 100);
        }
    }
    displayCategoryItem()
}
animationShowCategory();

function sliderProductController() {
    const productWrapper = document.querySelector(".product__wrapper");
    const productItems = document.querySelector(".product__items");
    const firstProductWidth = productItems.querySelector(".product__item").offsetWidth;
    const arrowButtons = document.querySelectorAll(".product__wrapper button");
    const productItemChildrens = [...productItems.children];

    let isDragging = false, isAutoPlay = true, startX, startScrollLeft, timeoutId;
    let productPerView = Math.round(productItems.offsetWidth / firstProductWidth);

    productItemChildrens.slice(-productPerView).reverse().forEach(product => {
        productItems.insertAdjacentHTML("afterbegin", product.outerHTML);
    });

    productItemChildrens.slice(0, productPerView).forEach(product => {
        productItems.insertAdjacentHTML("beforeend", product.outerHTML);
    });

    productItems.classList.add("no-transition");
    productItems.scrollLeft = productItems.offsetWidth;
    productItems.classList.remove("no-transition");

    arrowButtons.forEach(btn => {
        btn.addEventListener("click", () => {
            productItems.scrollLeft += btn.className === "left__button" ? -firstProductWidth : firstProductWidth;
        });
    });

    const dragStart = (e) => {
        isDragging = true;
        productItems.classList.add("dragging");
        startX = e.pageX;
        startScrollLeft = productItems.scrollLeft;
    }

    const dragging = (e) => {
        if (!isDragging) return;
        productItems.scrollLeft = startScrollLeft - (e.pageX - startX);
    }

    const dragStop = () => {
        isDragging = false;
        productItems.classList.remove("dragging");
    }

    const infiniteScroll = () => {
        if (productItems.scrollLeft === 0) {
            productItems.classList.add("no-transition");
            productItems.scrollLeft = productItems.scrollWidth - (2 * productItems.offsetWidth);
            productItems.classList.remove("no-transition");
        } else if (Math.ceil(productItems.scrollLeft) === productItems.scrollWidth - productItems.offsetWidth) {
            productItems.classList.add("no-transition");
            productItems.scrollLeft = productItems.offsetWidth;
            productItems.classList.remove("no-transition");
        }
        clearTimeout(timeoutId);
        if (!productWrapper.matches(":hover")) autoPlay();
    }

    const autoPlay = () => {
        if (window.innerWidth < 800 || !isAutoPlay) return;
        timeoutId = setTimeout(() => productItems.scrollLeft += firstProductWidth, 2500);
    }
    autoPlay();

    productWrapper.addEventListener("mousedown", dragStart);
    productItems.addEventListener("mousemove", dragging);
    document.addEventListener("mouseup", dragStop);
    productItems.addEventListener("scroll", infiniteScroll);
    productWrapper.addEventListener("mouseenter", () => clearTimeout(timeoutId));
    productWrapper.addEventListener("mouseleave", autoPlay);
}
sliderProductController();