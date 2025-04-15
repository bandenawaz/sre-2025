import { Link } from "react-router-dom";
import styled from "styled-components";

const Card = styled.div`
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 10px;
    margin: 10px;
`;

function PostCard( { post }){
    return (
        <Card>
            <h3>{post.title}</h3>
            <p>{post.content.substring(0, 100)}...</p>
            <Link to={`/post/${post.id}`}>Read More</Link>
        </Card>
    );
}

export default PostCard;