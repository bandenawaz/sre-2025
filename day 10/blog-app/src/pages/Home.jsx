import { useEffect, useState } from "react";
import PostCard from "../components/PostCard";
import axios from "axios";


export default function Home(){
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        // eslint-disable-next-line no-undef
        axios.get(process.env.BASE_URL).then((res) => {
            setPosts(res.data);

        });
    },[]);

    return(
        <div>
            <h2>All Blog Posts</h2>
            {posts.map(post => (
                <PostCard key={post.id} post={post} />
            ))}
            
        </div>
    );
}