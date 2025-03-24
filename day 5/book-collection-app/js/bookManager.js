import { fetchBookFromAPI } from "./bookAPI.js";


export default class BookManager{
    constructor(){
        this.books = [];
    }

    async loadBooks(){
        try{
            const books  = await fetchBookFromAPI();
            this.books = books;
            this.renderBooks();
            //log.info('Books loaded successfully');
            console.log('Books loaded successfully');

        }catch(error){
            console.error('Error loading books', error);
            //log.error('Error loading books');
            
        }
    }

    //lets add a method to add books
    addBook(title, author, genre){
        const newBook = {id: Date.now(), title, author, genre };
        this.books.push(newBook);
        console.log(this.books);
        this.renderBooks();
        console.log('Book added successfully');
    }

    //lets add a method to delete books
    deleteBook(id){
        this.books = this.books.filter(book => book.id !== id);
        this.renderBooks();
        console.log('Book deleted successfully');
    }

    //lets add a method to render books
    renderBooks(){
        const bookList = document.getElementById('book-list');
        bookList.innerHTML = '';
        this.books.forEach(({id, title, author, genre}) => {
            const bookItem = document.createElement('div');
            bookItem.className = 'book-item';
            bookItem.innerHTML = `
            <div>
                <strong>${title}</strong>
                <small>${author} | ${genre}</small>
            </div>
            <button onclick="bookManager.deleteBook(${id})">Delete</button>
            `;
            bookList.appendChild(bookItem);

        });

        document.getElementById('book-count').textContent = this.books.length;
    }
}