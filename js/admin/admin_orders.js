function formatCurrency(amount) {
    return new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(amount);
}

function formatLetter(letter){
    return letter.charAt(0).toUpperCase() + letter.slice(1).toLowerCase();
}

function renderOrderTable(listOrders) {
    const bodyTable = document.querySelector(".table tbody");
    let orderHtmlRows = listOrders.map(order => {
        return `<tr class="table__row">
                                    <td class="table__date-checkbox">
                                        <label class="check">
                                            <input type="checkbox" name="passing" class="filter__input" hidden="true">
                                        </label>
                                    </td>
                                    <td class="table__data-edit">
                                        <label class="" for="">
                                            <i class="fa-solid fa-pen-to-square"></i>
                                        </label>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${order.id}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${order.dateOrder}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${order.fullName}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${formatLetter(order.paymentMethod)}</p>
                                    </td>                                                          
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${formatLetter(order.statusOrder)}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${formatLetter(order.statusTransaction)}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${formatLetter(order.statusDelivery)}</p>
                                    </td>
                                    
                                    <td class="table__data">
                                        <p class="table__cell">${formatCurrency(240000)}</p>
                                    </td>
                                </tr>`
    })
    bodyTable.innerHTML = orderHtmlRows.join('');
}
renderOrderTable(listOrders)