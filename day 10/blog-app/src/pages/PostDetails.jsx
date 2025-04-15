import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";


export default function PostDetails(){

    const { id } = useParams();
    const [post, setPost] = useState(null);

    useEffect(() => {
        // eslint-disable-next-line no-undef
        axios.get(`${process.env.BASE_URL}/${id}`).then((res) => {
            setPost(res.data);
        });
    }, [id]);

    if (!post) {
        return <h2>Loading...</h2>;
    }

    return(
        <div>
            <h2>{post.title}</h2>
            <p>{post.content}</p>
        </div>
    );
}