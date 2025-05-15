//Masks
$('#inputPrice').mask('000.000.000.000.000,00', {reverse: true});

function convertToNumber(priceFormat) {
    return priceFormat.replace(/\./g, '').replace(',', '.');
}

var products = [];

var categories = [];

var formatter = new Intl.NumberFormat('pt-BR', {
    style: 'currency',
    currency: 'BRL',
});

//OnLoad
loadProducts();
loadCategories();

//load all categories
function loadCategories() {
    $.ajax({
        url: 'http://localhost:8080/categories',
        type: 'GET',
        async: false,
        success: (response) => {
            categories = response;
        }
    });
    
}

//Load all prodcuts
function loadProducts(){
    $.getJSON('http://localhost:8080/products', (response) => {
        let products = response;
        for(let prod of products) {
        addNewRow(prod);
        }
    });
}

//save a product
function save() {

   var prod =  {
        id: products.length + 1,
        name: document.getElementById('inputName').value,
        description: document.getElementById('inputDescription').value,
        price: convertToNumber(document.getElementById('inputPrice').value),
        category: document.getElementById('selectCategory').value,
        promotion: document.getElementById('checkBoxPromotion').checked,
        new: document.getElementById('checkBoxNewProduct').checked
    };

    addNewRow(prod);
    products.push(prod);

    document.getElementById('formProduct').reset();
}

//Add new row
function addNewRow(prod) {
    var table = document.getElementById('productsTable');

    var newRow = table.insertRow();

    //Insert product id
    var idNode = document.createTextNode(prod.id);
    newRow.insertCell().appendChild(idNode);

    //Insert product name
    var nameNode = document.createTextNode(prod.name);
    newRow.insertCell().appendChild(nameNode);

    //Insert product description
    var descriptionNode = document.createTextNode(prod.description);
    var cell = newRow.insertCell();
    cell.className = 'd-none d-md-table-cell';
    cell.appendChild(descriptionNode);

    //Insert product price
    var priceNode = document.createTextNode(formatter.format(prod.price));
    newRow.insertCell().appendChild(priceNode);

    //Insert product category
    var categoryNode = document.createTextNode(categories[prod.idCategory - 1].name);
    newRow.insertCell().appendChild(categoryNode);

    var options = '';

    if(prod.promotion) {
        options += '<span class="badge text-bg-success me-1">P</span>';
    }

    if(prod.newProduct) {
        options += '<span class="badge text-bg-primary">L</span>';
    }

    cell = newRow.insertCell();
    cell.className = 'd-none d-md-table-cell';
    cell.innerHTML = options;
    
}


