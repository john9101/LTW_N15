// function ValidatorContactForm(options){
//     var selectorRules = {};
//
//     function getRightParent(element, selector){
//         while (element.parentElement){
//             if(element.parentElement.matches(selector)){
//                 return element.parentElement;
//             }else{
//                 element = element.parentElement;
//             }
//         }
//     }
//     function validate(inputElement, rule, errorMessageElement){
//         var errorMessage;
//         var arrayRules = selectorRules[rule.selector];
//         for(var i = 0; i < arrayRules.length; i++){
//             errorMessage = arrayRules[i](inputElement.value);
//             if(errorMessage){
//                 break;
//             }
//         }
//         if(errorMessage){
//             errorMessageElement.style.display = 'block';
//             errorMessageElement.innerText = errorMessage;
//             errorMessageElement.style.color = '#E40F0A';
//             inputElement.classList.add('input-invalid')
//         }else {
//             errorMessageElement.style.display = 'none';
//             errorMessageElement.innerText = '';
//             inputElement.classList.remove('input-invalid')
//         }
//         return !errorMessage;
//     }
//
//     var contactFormElement = document.querySelector(options.form);
//     if(contactFormElement){
//         contactFormElement.onsubmit = function (e){
//             e.preventDefault();
//             var isFormValid = true;
//             options.rules.forEach(function (rule){{
//                 var inputElement = contactFormElement.querySelector(rule.selector);
//                 var errorMessageElement = getRightParent(inputElement, options.formBlockSelector).querySelector(options.errorSelector);
//                 var isValid = validate(inputElement,rule, errorMessageElement);
//                 if(!isValid){
//                     isFormValid = false;
//                 }
//             }});
//
//
//             if(isFormValid){
//                 contactFormElement.submit();
//                 // document.querySelector("success__notification").classList.add("active");
//                 // if(typeof options.onSubmit === 'function'){
//                 //     var enableInput = contactFormElement.querySelectorAll('[name]:not([disabled])');
//                 //     var formValues = Array.from(enableInput).reduce(function (values, input){
//                 //         values[input.name] = input.value
//                 //         return values;
//                 //     },{});
//                 //     options.onSubmit(formValues);
//                 // }else{
//                 //     contactFormElement.submit();
//                 // }
//             }
//         }
//
//
//         options.rules.forEach(function (rule){
//             if(Array.isArray(selectorRules[rule.selector])){
//                 selectorRules[rule.selector].push(rule.test);
//             }else{
//                 selectorRules[rule.selector] = [rule.test];
//             }
//             var inputElement = contactFormElement.querySelector(rule.selector);
//             // var errorMessageElement = inputElement.parentElement.querySelector(options.errorSelector);
//             var errorMessageElement = getRightParent(inputElement, options.formBlockSelector).querySelector(options.errorSelector);
//             if (inputElement){
//                 inputElement.onblur = function (){
//                     validate(inputElement,rule,errorMessageElement);
//                 }
//                 inputElement.oninput = function (){
//                     errorMessageElement.style.display = 'none';
//                     errorMessageElement.innerText = '';
//                     inputElement.classList.remove('input-invalid')
//                 }
//                 inputElement.onfocus = function (){
//                     errorMessageElement.style.display = 'none';
//                     errorMessageElement.innerText = '';
//                 }
//             }
//         });
//     }
// }
//
// ValidatorContactForm.isRequired = function (selector){
//     return {
//         selector: selector,
//         test: function (value){
//             return value.trim() ? undefined : 'Vui lòng bạn nhập trường này'
//         }
//     }
// }
//
// ValidatorContactForm.isEmail = function (selector){
//     return {
//         selector: selector,
//         test: function (value){
//             var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//             return regex.test(value.trim()) ? undefined : 'Thông tin bạn nhập không phải là email'
//         }
//     }
// }
//
// ValidatorContactForm.isPhone = function (selector) {
//     return {
//         selector: selector,
//         test: (value) => {
//             const regex = /(84|0[0-9])+([0-9]{8})\b/g;
//             return regex.test(value.trim()) ? undefined : 'Vui lòng nhập số điện thoại hợp lệ (10 số bắt đầu từ 0)'
//         }
//     }
// }

const contactFormElement = document.forms["contact__form"];
let fullNameFieldElement = contactFormElement["fullName"];
let phoneFieldElement = contactFormElement["phone"];
let emailFieldElement = contactFormElement["email"];
let submitElement = contactFormElement.querySelector(".form__submit");
function handleValidationContactForm(){

    contactFormElement.addEventListener("submit", function (event) {
        validateInputField(fullNameFieldElement);
        validateInputField(phoneFieldElement);
        validateInputField(emailFieldElement);
    })
}
handleValidationContactForm();

function validateInputField(fieldElement){
    if (fieldElement.value.trim() !== '') {
        fieldElement.parentElement.querySelector(".error-notice").style.display = "none";
        fieldElement.parentElement.querySelector(".error-notice").textContent = "";
    }
}

function handleInputtingField(fieldElement){
    fieldElement.addEventListener('input', function (){
        validateInputField(fieldElement);
    })
}
handleInputtingField(fullNameFieldElement);
handleInputtingField(phoneFieldElement);
handleInputtingField(emailFieldElement);

function autoRemoveSuccessNotification (){
    const successNotification = document.querySelector(".success__notification");
    setTimeout(function() {
        if (successNotification) {
            successNotification.classList.add('slideOut');
            setTimeout(function() {
                successNotification.remove();
            }, 1000);
        }
    }, 1000);
}
autoRemoveSuccessNotification();