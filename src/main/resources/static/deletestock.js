let deleteStockForm = document.querySelector("#deleteS")
let deleteId = document.getElementById('deleteStockID').value;

const deleteStock = (e) => {
fetch(`/stocks/${deleteId}`, {
    method: "DELETE",
    headers: {
        'Content-type': 'application/json'
    }
}).then(res => {
    if (res.ok) { console.log("HTTP request successful") }
    else { console.log("HTTP request unsuccessful") }
    return res
})
.then(res => res.json())
.then(data => console.log(data))
.catch(error => console.log(error))
}
deleteStockForm.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(e);
    deleteStock();
})