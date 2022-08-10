let createUserForm = document.querySelector("#submituser")
let uname = document.getElementById('uname');
let balance = document.getElementById('balance');
let email = document.getElementById('email');


const postUser = (e) => {
    fetch('/users', {
        method: "POST",
        body: JSON.stringify(
            {
                "name": uname.value,
                "balance": balance.value,
                "email": email.value
               
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
        
 
createUserForm.addEventListener('click', (e) => {
e.preventDefault();
console.log(e); 
postUser(e);
});