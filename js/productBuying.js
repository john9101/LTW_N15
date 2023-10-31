const listProduct = [
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 1",
        category: "Áo dài tay",
        price: 19.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 2",
        category: "Áo dài tay",
        price: 24.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 3",
        category: "Áo nỉ dài tay",
        price: 14.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 4",
        category: "Quần short",
        price: 29.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 5",
        category: "Áo Polo",
        price: 39.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 6",
        category: "Áo sơ mi tay dài",
        price: 9.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 7",
        category: "Áo sơ mi ngắn tay",
        price: 49.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 8",
        category: "Quần jeans",
        price: 34.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 9",
        category: "Quần Kaki",
        price: 19.99,
    },
    {
        img: "../assets/img/product_img/product1/img1.png",
        name: "Product 10",
        category: "Áo ba lỗ",
        price: 59.99,
    }
];
const listProductElement = document.querySelector(".product__list");
function loadProduct() {
    const htmls = listProduct.map(product => {
        return `
            <div class="col-3">
                <a href="#!">
                    <div class="model_product item4">
                        <img src="${product.img}">
                        <div class="information-product">
                            <span class="status">Most required</span>
                            <a class="name-product" href="#">${product.name}</a>
                            <div class="review-product">
                                <div class="icon-review">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                </div>
                                <a href="#">1000 nhận xét</a>
                            </div>
                            <span class="price"><strong class="sale-price">${product.price}</strong> <s class="original-price">300,000₫</s></span>
                        </div>
                    </div> 
                    </a>
                </div>`;
    });
    listProductElement.innerHTML = htmls.join("");
}
loadProduct();


/*productSearch*/
const searchInput = document.getElementById("search-input");
const searchButton = document.getElementById("search-button");
searchButton.addEventListener("click", searchProduct);
function searchProduct() {
    const searchQuery = searchInput.value.toLowerCase();
    const filteredProducts = listProduct.filter(product => product.name.toLowerCase().includes(searchQuery));
    const htmls = filteredProducts.map(product => {
        return `
            <div class="col-3">
                <a href="#!">
                    <div class="model_product item4">
                        <img src="${product.img}">
                        <div class="information-product">
                            <span class="status">Most required</span>
                            <a class="name-product" href="#">${product.name}</a>
                            <div class="review-product">
                                <div class="icon-review">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                </div>
                                <a href="#">1000 nhận xét</a>
                            </div>
                            <span class="price"><strong class="sale-price">${product.price}</strong> <s class="original-price">300,000₫</s></span>
                        </div>
                    </div> 
                </a>
            </div>`;
    });
    listProductElement.innerHTML = htmls.join("");
}


//productKeyHint
let availableKeyWord = [
    'product 1',
    'product 2',
    'product 3',
    'product 4',
    'product 5',
    'product 6',
    'product 7',
    'product 8',
    'product 9',
    'product 10',
];
const resultBox = document.querySelector(".result-box");
const inputBox = document.getElementById("search-input");

inputBox.onkeyup = function () {
    let result = [];
    let input = inputBox.value;
    if (input.length) {
        result = availableKeyWord.filter((keyword) => {
            return keyword.toLowerCase().includes(input.toLowerCase());
        });
        console.log(result)
    }
    display(result);
    if (!result.length) {
        resultBox.innerHTML = '';
    }
}
function display(result) {
    const content = result.map((list) => {
        return "<li onclick=selectInput(this)>" + list + "</li>";
    });
    resultBox.innerHTML = "<ul>" + content.join('') + "</ul>";
}
function selectInput(list) {
    inputBox.value = list.innerHTML;
    resultBox.innerHTML = '';
}


/*categoryLoad*/
const listCategory = [
    'Áo dài tay',
    'Áo oversize',
    'Áo nỉ dài tay',
    'Quần short',
    'Áo Polo',
    'Áo sơ mi tay dài',
    'Áo sơ mi ngắn tay',
    'Quần jeans',
    'Quần Kaki',
    'Áo ba lỗ'
];
const listCategoryElement = document.querySelector(".category__list");
function loadCategory() {
    const htmls = listCategory.map(category => {
        return`<li class="category__item" onclick="filterProducts('${category}')">${category}</li>`;
    });
    htmls.unshift(` <li class="category__item" >
                                <span class="category__icon"></span>
                                Danh mục
                            </li>`)
    listCategoryElement.innerHTML = htmls.join("");
}
loadCategory();


// categorySearch
function filterProducts(category) {
    const filteredProducts = listProduct.filter(product => product.category.toLowerCase().includes(category.toLowerCase()));
    const htmls = filteredProducts.map(product => {
        return `
            <div class="col-3">
                <a href="#!">
                    <div class="model_product item4">
                        <img src="${product.img}">
                        <div class="information-product">
                            <span class="status">Most required</span>
                            <a class="name-product" href="#">${product.name}</a>
                            <div class="review-product">
                                <div class="icon-review">
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                    <i class="fa-solid fa-star"></i>
                                </div>
                                <a href="#">1000 nhận xét</a>
                            </div>
                            <span class="price"><strong class="sale-price">${product.price}</strong> <s class="original-price">300,000₫</s></span>
                        </div>
                    </div> 
                </a>
            </div>`;
    });
    listProductElement.innerHTML = htmls.join("");
}


