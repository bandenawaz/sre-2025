import BookManager from "./bookManager.js";

const bookManager = new BookManager();

//Lets initialize app by loading books
//Makes bookManager globally accessible  for button actions
window.bookManager = bookManager; 

document.addEventListener('DOMContentLoaded', () => {
    bookManager.loadBooks();
    console.log('App initialized');
    console.log('BookManager initialized');
    console.log('BookManager loaded books');

    //Event listener for adding book button
    const addBookButton = document.getElementById('add-book-btn');
    const titleInput = document.getElementById('title-input');
    const authorInput = document.getElementById('author-input');
    const genreInput = document.getElementById('genre-input');


    addBookButton = document.addEventListener('click', (event) => {

        event.preventDefault();
        const title = titleInput.value.trim();
        const author = authorInput.value.trim();
        const genre = genreInput.value.trim();

        //lets do field verification
        if (!title || !author || !genre) {
            alert('Please fill all fields');
            return;
        }else{
            //add book to the book manager
            bookManager.addBook(title, author, genre);
            //log event
            console.log(`Book added: Title - ${title}, Author - ${author}, Genre - ${genre}`);
        

        

        //clear input fields
        titleInput.value = '';
        authorInput.value = '';
        genreInput.value = '';
        }
    });
});