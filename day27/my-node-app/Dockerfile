# Step 1: Base Image
FROM node:18

# Step 2: Set Working Directory
WORKDIR /app

# Step 3: Copy Source Code
COPY . .

# Step 4: Install Dependencies
RUN npm install

# Step 5: Set Environment Variables
ENV NODE_ENV=production

# Step 6: Expose Port
EXPOSE 3000

# Step 7: Start Application
CMD ["node", "app.js"]
