import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import CreatePost from './pages/CreatePost'
import PostDetails from './pages/PostDetails'
import Navbar from './components/Navbar'


function App() {

  return (
    <>
      <h1>Blog App</h1>
  
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/create" element={<CreatePost />} />
          <Route path="/:id" element={<PostDetails />} />
        </Routes>
      </Router>
    </>
  )
}

export default App
