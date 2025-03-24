//function to calculate total price
function calculateTotal() {
    let items = document.querySelectorAll('.cart-item'); //get all items
    let totalPrice = 0;
    items.forEach(item => {
        let price = parseFloat(item.querySelector('.price').innerText.replace("$", "")); //get price from item
        let quantity = parseInt(item.querySelector('.quantity').value); //get quantity from item
        totalPrice += price * quantity; //calculate total price
        console.log(totalPrice);
    });

    //lets update total price
    document.getElementById("totalPrice").innerHTML = "$" + totalPrice.toFixed(2);
}

// let user = {
//     name: "John Doe",
//     age: 25,
// }

// console.log(user.name); //John Doe
// console.log(user.age); //25

//property value shorthand
function makeUser(name, age) {
    return {
        name: name,
        age: age
    };
} 

let user = makeUser("John Doe",30);
console.log("Name: "+user.name +" Age: "+user.age); //John Doe