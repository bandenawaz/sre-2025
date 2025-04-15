import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function CreatePost(){

    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const [author, setAuthor] = useState("");

    const navigate = useNavigate();

    //lets write a function to handle submit
    const handleSubmit = async (e) => {
        e.preventDefault();
        // eslint-disable-next-line no-undef
        await axios.post(process.env.BASE_URL, {
            title,
            content,
            author
        });
        //lets navigate to home page
        navigate("/");
    };

    return(
        <div>
            <h1>Create a New Post</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Title:
                    <input type="text" value={title} 
                    onChange={(e) => setTitle(e.target.value)} />
                </label>
                <br />
                <label>
                    Content:
                    <textarea value={content} 
                    onChange={(e) => setContent(e.target.value)} />
                </label>
                <br />
                <label>
                    Author:
                    <input type="text" value={author} 
                    onChange={(e) => setAuthor(e.target.value)} />
                </label>
                <br />
                <button type="submit">Create Post</button>
            </form>
        </div>
    );
}