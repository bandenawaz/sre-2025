// document.getElementById("signupform").addEventListener("submit", 
        
//     function(event) {
//     //prevent form from submitting automatically
//         event.preventDefault();
// try{
//         //lets get the input values
//         let username = document.getElementById("username").value.trim();
//         let email = document.getElementById("email").value.trim();
//         let password = document.getElementById("password").value.trim();
//         let confirmPassword = document.getElementById("confirmPassword").value.trim();

//         //Regular expression for validation
//         let usernameRegex = /^[A-Za-z\s]+$/;
//         let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; //valid email format
//         let passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/; //minimum 8 characters, at least one letter and one number


//         error = [];
//         //validate username
//         if(!username) throw new Error("Username is required");
//         if(!usernameRegex.test(username)) throw new Error("Username can only contain alphabets and spaces");

//         //validate email
//         if(!email) throw new Error("Email is required");
//         if(!emailRegex.test(email)) throw new Error("Invalid email format");

//         //validate password
//         if(!password) throw new Error("Password is required");
//         if(!passwordRegex.test(password)) throw new Error("Password must contain at least one letter and one number and must be minimum 8 characters long");

//         //validate confirm password
//         if(!confirmPassword) throw new Error("Confirm Password is required");
//         if(password !== confirmPassword) throw new Error("Passwords do not match");

//         //if no error
//         alert("Registration successful");
//         this.submit();
//     }catch(error){
//         console.error("Validation Error: ", error.message);
//         let errorElement = document.createElement("p");
//         let errorDiv = document.getElementById("errorMessages");
//         errorDiv.innerHTML = "";
//         errorElement.textContent = error.message;
//         errorElement.classList.add("alert", "alert-danger");
//         errorDiv.appendChild(errorElement);

//     }
//         });

class FormValidator {
    constructor(formId) {
        this.form = document.getElementById(formId);
        this.errorMessages = document.getElementById('errorMessages');
        this.form.addEventListener('submit', (event) => this.validateForm(event));
    }

    validateForm(event) {
        event.preventDefault();
        this.errorMessages.innerHTML ="";

        let errors = [];

        try {
          let username = document.getElementById("username").value.trim();
          let email = document.getElementById("email").value.trim();
          let password = document.getElementById("password").value.trim();
          let confirmPassword = document
            .getElementById("confirmPassword")
            .value.trim();

          //Regular expression for validation
          let usernameRegex = /^[A-Za-z\s]+$/;
          let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; //valid email format
          let passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/; //minimum 8 characters, at least one letter and one number

          //validate username
        if (!username) throw new Error("Username is required");
        if (!usernameRegex.test(username))
          throw new Error("Username can only contain alphabets and spaces");

        //validate email
        if (!email) throw new Error("Email is required");
        if (!emailRegex.test(email)) throw new Error("Invalid email format");

        //validate password
        if (!password) throw new Error("Password is required");
        if (!passwordRegex.test(password))
          throw new Error(
            "Password must contain at least one letter and one number and must be minimum 8 characters long"
          );

        //validate confirm password
        if (!confirmPassword) throw new Error("Confirm Password is required");
        if (password !== confirmPassword)
          throw new Error("Passwords do not match");

        //if no error
        alert("Registration successful");
        this.form.submit();


        } catch (error) {
            console.error("Validation Error: ", error.message);
            this.displayError(error.message);
            
        }

    }
    displayError(message) {
        let errorElement = document.createElement("p");
        // let errorDiv = document.getElementById("errorMessages");
        // errorDiv.innerHTML = "";
        errorElement.textContent = message;
        errorElement.classList.add("alert", "alert-danger");
        this.errorMessages.appendChild(errorElement);
    }
}

//Initialize the form validator
document.addEventListener('DOMContentLoaded', () => {
    new FormValidator('signupform');
}
);