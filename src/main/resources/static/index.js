const responseField = document.querySelector('#responseField');
const submit = document.querySelector('#users');
const stocks = document.querySelector('#stocks')

const getUsers = () => {
  fetch('/users').then(response => {
console.log('test2')
      response.json().then(jsonResponse => {
                               renderRawResponse(jsonResponse);
                            //   renderResponse(jsonResponse);
                              })

  }).catch( networkError => {
              console.log(networkError.message)
            })
}

const displayUsers = (event) => {
    event.preventDefault()
    console.log('Test');
  getUsers();

};

submit.addEventListener('click', displayUsers);



const renderResponse = (res) => {

  // Creates an empty array to contain the HTML strings
  let userList = [];
  // Loops through the response and caps off at 10
  for(let i = 0; i < res.length; i++){
    // creating a list of words
    userList.push(JSON.stringify(res[i]));
  }

  // Manipulates responseField to render the modified response
  responseField.innerHTML = `<p>You might be interested in:</p><ol>${userList}</ol>`;
  console.log(userList);
  return
}

// Renders response before it is modified
const renderRawResponse = (res) => {
  // Takes the first 10 words from res
  let response = res;
  // Manipulates responseField to render the unformatted response
  responseField.innerHTML = `<text>${JSON.stringify(response)}</text>`;
}


const getStocks = () => {
  fetch('/stocks').then(response => {
console.log('teststock')
      response.json().then(jsonResponse => {
                               renderRawResponse(jsonResponse);
                              //  renderResponse(jsonResponse);
                              })

  }).catch( networkError => {
              console.log(networkError.message)
            })
}

const displayStocks = (event) => {
    event.preventDefault()
    console.log('Teststock2');
  getStocks();
};

stocks.addEventListener('click', displayStocks);

