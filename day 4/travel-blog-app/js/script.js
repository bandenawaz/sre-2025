console.log("Travel Blog Loaded");
document.addEventListener("DOMContentLoaded", () => {
    const blogContainer = document.getElementById("blog-posts");

    //lets fetch the blog articles from the json file
    fetch("articles.json")
       .then(response => response.json())
       .then(data => {
        data.forEach(article => {
             //Create a new blog post for each article
             const postElement = document.createElement("div");
             postElement.classList.add("blog-post");

            //  postElement.innerHTML = `
            //   <h2>${article.title}</h2>
            //   <img class="lazy" data-src="${article.image}" alt="${article.title}"</img>
            //   <p>${article.content}</p>
            //   `;
            //Use textContent instead of innerHTML to prevent XSS
            const titleElement = document.createElement("h2");
            titleElement.textContent = article.title;

            const imageElement = document.createElement("img");
            imageElement.classList.add("lazy");
            imageElement.setAttribute("data-src", article.image);
            imageElement.setAttribute("alt", article.title);

            const contentElement = document.createElement("p");
            contentElement.textContent = article.content;

            postElement.appendChild(titleElement);
            postElement.appendChild(imageElement);
            postElement.appendChild(contentElement);

              //Append the post to the blog container
              blogContainer.appendChild(postElement);

        });

        //Implement lazy loading for images using Intersection Observer API
        const lazyImages = document.querySelectorAll(".lazy");
        const observer = new IntersectionObserver((entries, observer) => {
            entries.forEach(entry => {
                if(entry.isIntersecting) {
                    const img = entry.target;
                    img.src = img.getAttribute("data-src");
                    img.classList.remove("lazy");
                    observer.unobserve(img);
                }
            });
        });

        lazyImages.forEach(image => {
            observer.observe(image);
        });
       })
       .catch(error => console.error("Error fetching blog articles: ", error));
});