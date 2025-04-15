import app from "./src/app.js";  // Ensure `.js` extension is included

const PORT = process.env.PORT || 5001;

app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
