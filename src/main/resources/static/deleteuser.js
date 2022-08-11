let deleteUserForm = document.querySelector("#deleteUsersubmit")
let deleteUserId = document.getElementById('deleteUserId').value;

const deleteUser = (e) => {
fetch(`/users/${deleteUserId}`, {
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
deleteUserForm.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(e);
    deleteUser();
})