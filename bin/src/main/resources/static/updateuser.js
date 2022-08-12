let updateUserForm = document.querySelector("#submitUpdateuser")
let updateId = document.getElementById('updateId').value;
let updateName = document.getElementById('updateName');
let updateBalance = document.getElementById('updateBalance');
let updateEmail = document.getElementById('updateEmail');


const updateUser = (e) => {
    fetch(`/users/${updateId}`, {
        method: "PUT",
        body: JSON.stringify(
            {
                "name": updateName.value,
                "balance": updateBalance.value,
                "email": updateEmail.value
               
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
        
 
updateUserForm.addEventListener('click', (e) => {
e.preventDefault();
console.log(e); 
updateUser(e);
});