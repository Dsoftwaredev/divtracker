const createStockForm = document.getElementById('stock');
let name = document.getElementById('name');
let quantity = document.getElementById('quantity');
let stockPrice = document.getElementById('stockPrice');
let divFrequency = document.getElementById('divFrequency');
let nextDividend = document.getElementById('nextDividend');

const postStock = (e) => {
    fetch('/stocks', {
        method: "POST",
        body: JSON.stringify(
            {
                "name": name.value,
                "quantity": quantity.value,
                "stockPrice": stockPrice.value,
                "divFrequency": divFrequency.value,
                "nextDividendPayment": nextDividend.value
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
        
 
createStockForm.addEventListener("submit", (e) => {
     
  console.log(e);
  e.preventDefault();
  postStock(e);
});

