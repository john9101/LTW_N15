document.addEventListener("DOMContentLoaded", function() {

    function sliderImageController(){
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
            indicator.addEventListener("click", function() {
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

        nextButtonElement.addEventListener("click", function() {
            nextSlide();
        });

        prevButtonElement.addEventListener("click", function() {
            if (currentIndex > 0) {
                currentIndex--;
                slideTo(currentIndex);
            }
        });

        let interval = setInterval(nextSlide, 2000);

        sliderItemsElement.addEventListener('mouseover',function (){
            clearInterval(interval);
        });

        sliderItemsElement.addEventListener("mouseout", function (){
            interval = setInterval(nextSlide, 2000);
        })
    }
    sliderImageController();

    function animationShowCategory(){
        const categoryItems = document.querySelectorAll(".category__item")
        let currentIndex = 0;
        function displayCategoryItem(){
            if (currentIndex < categoryItems.length) {
                categoryItems[currentIndex].style.display = "flex";
                currentIndex++;
                setTimeout(displayCategoryItem, 800)
            } else {
                currentIndex = 0;
                categoryItems.forEach(category_item =>{
                    category_item.style.display = "none"
                });
                setTimeout(displayCategoryItem, 100);
            }
        }
        displayCategoryItem()

    }
    animationShowCategory();
    function sliderProductController(){
        const productItemsElement =  document.querySelector(".product__items");
        const modelProductItem = productItemsElement.querySelector(".product__item");
        const leftButtonElement = document.getElementById("left__button");
        const rightButtonElement = document.getElementById("right__button");
        let modelProductItemWidth = modelProductItem.clientWidth + 20;
        let currentPosition = 0

        leftButtonElement.addEventListener("click",()=>{
            if (currentPosition > 0){
                currentPosition -= modelProductItemWidth
            }
            productItemsElement.style.transform = `translateX(-${currentPosition}px)`;

        })

        rightButtonElement.addEventListener("click", ()=>{
            if (currentPosition < productItemsElement.scrollWidth - productItemsElement.clientWidth){
                currentPosition += modelProductItemWidth
            }
            productItemsElement.style.transform = `translateX(-${currentPosition}px)`;
        })
    }
    sliderProductController();
});
