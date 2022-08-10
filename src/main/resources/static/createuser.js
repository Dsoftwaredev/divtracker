let createUserForm = document.getElementById('user')
let uname = document.getElementById('uname');
let balance = document.getElementById('balance');
let email = document.getElementById('Email');


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
            console.log(uname.value)
            document.body.innerHTML = JSON.stringify(body)
        })
    }).catch(err => {
        console.log(err)
    })
}
        
 
createUserForm.addEventListener("submituser", (e) => {
     
  console.log(e);
  e.preventDefault();
postUser(e);
});

