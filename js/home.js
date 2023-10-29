document.addEventListener("DOMContentLoaded", function() {
    function sliderImageController(){
        const sliderList = document.querySelector(".slider-list");
        const prevButton = document.querySelector(".nav_prev");
        const nextButton = document.querySelector(".nav_next");
        const sliderWidth = sliderList.clientWidth;
        let currentIndex = 0;

        function slideTo(index) {
            sliderList.style.transform = `translateX(-${index * sliderWidth}px)`;
        }

        function nextSlide() {
            if (currentIndex < sliderList.childElementCount - 1) {
                currentIndex++;
            } else {
                currentIndex = 0;
            }
            slideTo(currentIndex);
        }

        nextButton.addEventListener("click", function() {
            nextSlide();
        });

        prevButton.addEventListener("click", function() {
            if (currentIndex > 0) {
                currentIndex--;
                slideTo(currentIndex);
            }
        });

        let interval = setInterval(nextSlide, 2000);

        sliderList.addEventListener('mouseover',function (){
            clearInterval(interval);
        });

        sliderList.addEventListener("mouseout", function (){
            interval = setInterval(nextSlide, 2000);
        })
    }
    sliderImageController();

});
