window.addEventListener('message', function (event) {
    const form = document.querySelector(".product__form");
    const receivedData = event.data;

    if (receivedData.state === 2) {
        // Workflow: Get data -> apply data to form -> apply rule for form -> Get obj -> send server

        // Get data: Use ajax call -> Read productDetail
        callAjaxRead();

        function callAjaxRead() {
            $.ajax({
                url: "admin-read-product?id=" + receivedData.productId,
                type: "POST",
                contentType: false,
                processData: false,
                dataType: "json",
                cache: false,
                success: function (data) {
                    applyDateToForm(data);
                },
                error: function (error) {
                },
            });
        }

        // apply data to form -> lấy ra các thông tin size + color + img vào
        let product;
        let sizes;
        let colors;
        let images = [];

        function applyDateToForm(data) {
            product = data["product"];
            sizes = data["sizes"];
            colors = data["colors"];
            images = data["images"];
            // Name
            name.value = product.name;
            // Category
            categoryId.querySelector(`option[value="${product.categoryId}"]`).selected = true;
            // Original Price
            originalPrice.value = product.originalPrice;
            // Sale Price
            salePrice.value = product.salePrice;
            // Description
            editorCK.setData(product.description);
            // Sizes
            setUpSize(sizes);
            addSize();//allow add size when click

            // Colors
            setUpColor(colors);
            addColor();//allow add color when click

            // Images
            imgPreviewsAdded.innerHTML = "";
            imgPreviewsExist.innerHTML = "";
            imagesLoading(images);
        }

        const imgPreviewsExist = document.querySelector(".form__img-exist .img__previews");

        // async function asyncImageLoading(images) {
        //     // Get the current URL to fetch img from server
        //     const currentURL = window.location.href;
        //     const url = new URL(currentURL);
        //     const basePath = `${url.protocol}//${url.hostname}:${url.port}/${url.pathname.split('/')[1]}`;
        //
        //     function addImages(blobUrl) {
        //         const imageHTML = `<div class="img__preview">
        //                                     <img src="${blobUrl}" alt="">
        //                                      <i class="form__img-delete fa-solid fa-xmark"></i>
        //                                   </div>`
        //         imgPreviewsExist.insertAdjacentHTML("beforeend", imageHTML);
        //         const lastElement = imgPreviewsExist.lastElementChild;
        //         lastElement.querySelector(".form__img-delete").addEventListener("click", function (e) {
        //             removeImg(lastElement);
        //         })
        //     }
        //
        //     function removeImg(addedFormImg) {
        //         addedFormImg.remove()
        //     }
        //
        //     for (let i = 0; i < images.length; i++) {
        //         const url = `${basePath}/read-image?name=${images[i]["nameImage"]}`
        //         const response = await fetch(url)
        //         const blob = await response.blob();
        //         const blobUrl = URL.createObjectURL(blob);
        //         addImages(blobUrl);
        //     }
        // }

        function imagesLoading(images) {
            // Get the current URL to fetch img from server
            const currentURL = window.location.href;
            const url = new URL(currentURL);
            const basePath = `${url.protocol}//${url.hostname}:${url.port}/${url.pathname.split('/')[1]}`;
            for (let i = 0; i < images.length; i++) {
                const url = `${basePath}/read-image?name=${images[i]["nameImage"]}`
                const response = fetch(url)
                // const blob = response.blob();
                // const blobUrl = URL.createObjectURL(blob);
                response.then(function (response) {
                    if (!response.ok) {
                        throw new Error('Network response was not ok.');
                    }
                    return response.blob();
                })
                    .then(function (blob) {
                        addImages(blob);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }

            function addImages(blob) {
                const imageHTML = `<div class="img__preview">
                                            <img src="${URL.createObjectURL(blob)}" alt="">
                                             <i class="form__img-delete fa-solid fa-xmark"></i>    
                                          </div>`
                imgPreviewsExist.insertAdjacentHTML("beforeend", imageHTML);
                const lastElement = imgPreviewsExist.lastElementChild;
                lastElement.querySelector(".form__img-delete").addEventListener("click", function (e) {
                    removeImg(lastElement);
                })
            }

            function removeImg(addedFormImg) {
                addedFormImg.remove()
            }
        }

        // apply rule for form -> add exist rule of field
        let ruleObj = {
            name: [Validation.isRequired("#name")],
            originalPrice: [Validation.isRequired("#originalPrice"), Validation.isNumber("#originalPrice")],
            salePrice: [Validation.isRequired("#salePrice"), Validation.isNumber("#salePrice")],
            description: [Validation.isRequired("#description")],
            nameSize: [Validation.isRequired("#nameSize")],
            sizePrice: [Validation.isRequired("#sizePrice"), Validation.isNumber("#sizePrice")],

        };

        let ruleArray = [];

        let validate = new Validation({
            formSelector: ".product__form",
            formBlockClass: "form__block",
            errorSelector: ".form__error",
            rules: ruleArray,
            submitSelector: "#form__submit",
            onSubmit: callAjaxUpdate,
        });

        function loadRules() {
            ruleArray = [];
            for (const key in ruleObj) {
                for (const keyElement of ruleObj[key]) {
                    ruleArray.push(keyElement);
                }
            }
            validate = new Validation({
                formSelector: ".product__form",
                formBlockClass: "form__block",
                errorSelector: ".form__error",
                rules: ruleArray,
                submitSelector: "#form__submit",
                onSubmit: callAjaxUpdate,
            });
        }

        loadRules();

        function pushRule(selectorId, rule) {
            if (!Array.isArray(ruleObj[selectorId])) {
                ruleObj[selectorId] = [rule];
            } else {
                ruleObj[selectorId].push(rule);
            }
            loadRules();
        }

        function removeRule(selectorId) {
            delete ruleObj[selectorId];
            loadRules();
        }


        const name = form.querySelector(`input[name ="name"]`);
        const categoryId = form.querySelector(`select[name ="idCategory"]`);
        const originalPrice = form.querySelector(`input[name ="originalPrice"]`);
        const salePrice = form.querySelector(`input[name ="salePrice"]`);
        const formSizes = document.querySelector(".form__sizes");
        let countSize = 0;

        // Thêm size
        // index == 0 -> ko cho xóa
        // index >0 -> cho xóa -> add event cho element đó
        function setUpSize(sizes) {
            formSizes.innerHTML = "";
            let formSizeHTML = '';
            sizes.forEach(function (size, index) {
                if (index == 0) {
                    formSizeHTML = `<div class="form__size">        
                                          <div class="form__block">
                                             <label>
                                                Tên kích thước
                                                <input type="text" name="nameSize"
                                                       class="form__size-input" id="nameSize" value="${size.nameSize}">
                                            </label>
                                              <span class="form__error"></span>
                                          </div>
                                           <div class="form__block">
                                                <label class="form__size-price">
                                                    Giá:
                                                    <input type="text" id="sizePrice" name="sizePrice" value="${size.sizePrice}">
                                                    <span>VNĐ</span>
                                                </label>
                                                  <span class="form__error"></span>
                                            </div>
                                      </div>`;
                    formSizes.insertAdjacentHTML("beforeend", formSizeHTML);
                    pushRule(`nameSize_${countSize}`, Validation.isRequired(`#nameSize`));
                    pushRule(`sizePrice_${countSize}`, Validation.isRequired(`#sizePrice`));
                    pushRule(`sizePrice_${countSize}`, Validation.isNumber(`#sizePrice`));
                } else {
                    countSize++;
                    formSizeHTML = `<div class="form__size">        
                                          <div class="form__block">
                                             <label>
                                                Tên kích thước
                                                <input type="text" name="nameSize"
                                                       class="form__size-input" id="nameSize_${countSize}" value="${size.nameSize}">
                                            </label>
                                              <span class="form__error"></span>
                                          </div>
                                           <div class="form__block">
                                                <label class="form__size-price">
                                                    Giá:
                                                    <input type="text" id="sizePrice_${countSize}" name="sizePrice" value="${size.sizePrice}">
                                                    <span>VNĐ</span>
                                                </label>
                                                  <span class="form__error"></span>
                                           </div>
                                        <i class="form__size-delete fa-solid fa-xmark" ></i>    
                                    </div>`;
                    formSizes.insertAdjacentHTML("beforeend", formSizeHTML);

                    const addedFormSize = formSizes.lastElementChild;

                    addedFormSize.querySelector(".form__size-delete").addEventListener("click", function () {
                        removeSize(addedFormSize);
                    });

                    pushRule(`nameSize_${countSize}`, Validation.isRequired(`#nameSize_${countSize}`));
                    pushRule(`sizePrice_${countSize}`, Validation.isRequired(`#sizePrice_${countSize}`));
                    pushRule(`sizePrice_${countSize}`, Validation.isNumber(`#sizePrice_${countSize}`));
                }
            });
        }

        function addSize() {
            const addSizeBtn = document.querySelector(".form__add-size");
            const formSizes = document.querySelector(".form__sizes");

            addSizeBtn.onclick = function () {
                countSize++;
                const formSizeHTML = `<div class="form__size">        
                                          <div class="form__block">
                                             <label>
                                                Tên kích thước
                                                <input type="text" name="nameSize"
                                                       class="form__size-input" id="nameSize_${countSize}">
                                            </label>
                                              <span class="form__error"></span>
                                          </div>
                                       <div class="form__block">
                                            <label class="form__size-price">
                                                Giá:
                                                <input type="text" id="sizePrice_${countSize}" name="sizePrice">
                                                <span>VNĐ</span>
                                            </label>
                                              <span class="form__error"></span>
                                        </div>
                                        <i class="form__size-delete fa-solid fa-xmark" ></i>    
                                      </div>`;
                formSizes.insertAdjacentHTML("beforeend", formSizeHTML);

                const addedFormSize = formSizes.lastElementChild;

                addedFormSize.querySelector(".form__size-delete").addEventListener("click", function () {
                    removeSize(addedFormSize);
                });

                pushRule(`nameSize_${countSize}`, Validation.isRequired(`#nameSize_${countSize}`));
                pushRule(`sizePrice_${countSize}`, Validation.isRequired(`#sizePrice_${countSize}`));
                pushRule(`sizePrice_${countSize}`, Validation.isNumber(`#sizePrice_${countSize}`));
            }
        }

        function removeSize(formSize) {
            const formSizeDelete = formSize.querySelector(".form__size-delete");
            const inputs = formSize.querySelectorAll(`input[name]`);
            for (const input of inputs) {
                removeRule(input.id);
            }
            formSizeDelete.onclick = function (e) {
                formSize.remove();
            }
            loadRules();
        }

        const formColors = document.querySelector(".form__colors");

        function setUpColor(colors) {
            formColors.innerHTML = "";
            let formColorHTML = "";
            colors.forEach(function (color, index) {
                if (index == 0) {
                    formColorHTML = `<div class="form__color">
                                        <input type="color" name="color" class="form__size-input" value="${color["codeColor"]}">
                                    </div>`;
                    formColors.insertAdjacentHTML("beforeend", formColorHTML);
                } else {
                    formColorHTML = `<div class="form__color">
                                        <input type="color" name="color" class="form__size-input" value="${color["codeColor"]}">
                                            <i class="form__color-delete fa-solid fa-xmark" ></i>
                                    </div>`;
                    formColors.insertAdjacentHTML("beforeend", formColorHTML);
                    const addedFormColor = formColors.lastElementChild;
                    addedFormColor.querySelector(".form__color-delete").addEventListener("click", function () {
                        removeColor(addedFormColor);
                    });
                }

            })
        }

        function addColor() {
            const addColorBtn = document.querySelector(".form__add-color");
            addColorBtn.onclick = function () {
                const formColorHTML = `<div class="form__color">
                                        <input type="color" name="color" class="form__size-input">
                                            <i class="form__color-delete fa-solid fa-xmark" ></i>
                                    </div>`;
                formColors.insertAdjacentHTML("beforeend", formColorHTML);

                const addedFormColor = formColors.lastElementChild;
                addedFormColor.querySelector(".form__color-delete").addEventListener("click", function () {
                    removeColor(addedFormColor);
                });
            }
        }

        function removeColor(formColor) {
            const formSizeDelete = formColor.querySelector(".form__color-delete");
            formSizeDelete.onclick = function (e) {
                formColor.remove();
            }
        }

        //Image
        const inputImg = document.querySelector(".img__input");


        const imgPreviewsAdded = document.querySelector(".form__img-added .img__previews");
        // Images
        inputImg.addEventListener("change", function (e) {
            imgPreviewsAdded.innerHTML = "";
            const files = e.target.files;
            // validate file
            for (let i = 0; i < files.length; i++) {
                const file = files[i];
                if (!file.name.endsWith(".jpg") && !file.name.endsWith(".png") && !file.name.endsWith(".jpeg")) continue;
                const formImgHTML =
                    `<div class="img__preview">
                      <img src="${URL.createObjectURL(file)}" alt="" >
                    </div>`;

                imgPreviewsAdded.insertAdjacentHTML("beforeend", formImgHTML);
                if (!ruleObj["image"]) {
                    pushRule("image", Validation.isRequired("#image"));
                }
            }
        })

        //Update------------------------------------------------------------------------------------------
        function callAjaxUpdate() {
            $.ajax({
                url: "admin-update-product",
                type: "POST",
                contentType: false,
                processData: false,
                dataType: "json",
                cache: false,
                data: getDataForm(form),
                success: function (data) {
                    console.log(data)
                    if (data.status === true) {
                        notifySuccess();
                        setTimeout(function () {
                            window.location.reload();
                        }, 3500);
                    }
                },
                error: function (error) {
                },
            });
        }

        const inputDesc = document.querySelector(`input[name = "description"]`)
        editorCK.on('change', function () {
            inputDesc.value = editorCK.getData();
        });

        function getDataForm(form) {
            const formData = new FormData(form);
            const quantityImgDelete = images.length - document.querySelectorAll(`.form__img-exist img`).length;
            formData.append("quantityImgDelete", quantityImgDelete + "");
            const productId = receivedData.productId;
            formData.append("id", productId);
            return formData;
        }

        const toastList = document.querySelector(".toast__list");

        function notifySuccess() {
            toastList.innerHTML = `<div class="toast" id="snackbar">
            <div class="toast__header">
                <span class="toast__icon-wrapper toast__icon--success">
                    <i class="toast__icon fa-solid fa-check"></i>
                </span>
                <strong class="toast__title">Cập nhập sản phẩm thành công</strong>
                <i class="toast__icon-close fa-solid fa-xmark"></i>
            </div>
            <div class="toast__body">
                Sản phẩm đã được thêm vào gian hàng.
            </div>
        </div>`;
            // Get the snackbar DIV
            const x = document.getElementById("snackbar");

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function () {
                x.className = x.className.replace("show", "");
                x.remove();
            }, 3000);

            // Send a message to the parent window
            window.parent.postMessage('Reload', `${window.location.origin}+"/adminProducts.jsp`);
        }
    }
})