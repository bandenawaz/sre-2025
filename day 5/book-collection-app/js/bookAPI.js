 export const fetchBookFromAPI = () => {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
             {
                id: 1,
                title: "The Great Gatsby",
                author: "F. Scott Fitzgerald",
                genre: "Fiction",
            
             },
             {
                id: 2,
                title: "To Kill a Mockingbird",
                author: "Harper Lee",
                genre: "Fiction",
            }
                
            ]);
        }, 1000); // Simulate API request delay
    });
}