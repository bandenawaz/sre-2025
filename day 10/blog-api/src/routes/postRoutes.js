import { getPosts, createPost, updatePost, deletePost } from '../controllers/postController.js'; 
import express from 'express';

const router = express.Router();

// @route GET /api/posts
router.get('/', getPosts);

// @route POST /api/posts
router.post('/', createPost);

// @route PUT /api/posts/:id
router.put('/:id', updatePost);

// @route DELETE /api/posts/:id
router.delete('/:id', deletePost);

export default router;
