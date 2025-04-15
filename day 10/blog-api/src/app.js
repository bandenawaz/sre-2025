import express from 'express';
import cors from 'cors';
import bodyParser from 'body-parser';
import dotenv from 'dotenv';
import connectDb from './config/db.js';  // Use ES module import
import postRoutes from './routes/postRoutes.js';  // Add `.js` extension

dotenv.config();

// Initialize the app
const app = express();

// Connect to MongoDB
connectDb();

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Routes    
app.use('/api/posts', postRoutes);

export default app;  // Use ES module export
