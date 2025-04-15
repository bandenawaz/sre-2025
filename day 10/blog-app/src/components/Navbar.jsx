import { Link } from "react-router-dom";
import styled from "styled-components";

const Nav = styled.nav`
    display: flex;
    justify-content: space-between;
    background: #333;
    padding: 10px;
`;

const StyledLink = styled(Link)`
    color: white;
    text-decoration: none;
    margin: 0 15px;
`;

export default function Navbar(){

    return(
        <Nav>
            <StyledLink to="/">Home</StyledLink>
            <StyledLink to="/create">Create Post</StyledLink>
            
        </Nav>
    );
}