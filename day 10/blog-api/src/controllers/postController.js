import Post from "../models/Post.js";  // Ensure `.js` extension is included

// @desc Fetch all posts
// @route GET /api/posts
const getPosts = async (req, res) => {
    try {
        const posts = await Post.find();
        res.status(200).json(posts);
    } catch (err) {
        res.status(500).json({ error: "Server error" });
    }
};

// @desc Create a new post
// @route POST /api/posts
const createPost = async (req, res) => {
    try {
        const { title, content, author } = req.body;
        const newPost = new Post({ title, content, author });
        await newPost.save();
        res.status(201).json(newPost);
    } catch (err) {
        res.status(500).json({ error: "Server error" });
    }
};

// @desc Update an existing post
// @route PUT /api/posts/:id
const updatePost = async (req, res) => {
    try {
        const updatedPost = await Post.findByIdAndUpdate(req.params.id, req.body, { new: true });
        if (!updatedPost) {
            return res.status(404).json({ error: "Post not found" });
        }
        res.status(200).json(updatedPost);
    } catch (err) {
        res.status(500).json({ error: "Unable to update post" });
    }
};

// @desc Delete a post
// @route DELETE /api/posts/:id
const deletePost = async (req, res) => {
    try {
        const deletedPost = await Post.findByIdAndDelete(req.params.id);
        if (!deletedPost) {
            return res.status(404).json({ error: "Post not found" });
        }
        res.status(200).json({ message: "Post deleted successfully" });
    } catch (err) {
        res.status(500).json({ error: "Unable to delete post" });
    }
};

export { getPosts, createPost, updatePost, deletePost };  // Use named exports
