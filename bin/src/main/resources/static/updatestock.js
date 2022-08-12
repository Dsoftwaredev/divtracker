const updateStockForm = document.querySelector("#updatestock");
let id = document.getElementById('id').value;

let Sname = document.getElementById('Sname');
let Squantity = document.getElementById('Squantity');
let SstockPrice = document.getElementById('SstockPrice');
let SdivFrequency = document.getElementById('SdivFrequency');
let SnextDividend = document.getElementById('SnextDividend');

const updateStock = (e) => {
    fetch(`/stocks/${id}`, {
        method: "PUT",
        body: JSON.stringify(
            {
                "name": Sname.value,
                "quantity": Squantity.value,
                "stockPrice": SstockPrice.value,
                "divFrequency": SdivFrequency.value,
                "nextDividendPayment": SnextDividend.value
        }),
        headers:{
            "Content-Type":"application/json"
        }
    }).then(res => {
        res.json().then(body => {
            document.body.innerHTML = JSON.stringify(body)
        })
    }).catch(err => {
        console.log(err)
    })
}

updateStockForm.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(e); 
    updateStock(e);
    });
    