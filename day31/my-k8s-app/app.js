//lets write our server file to serve our app
const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('Hello People! This is my first Kubernetes app.');
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
}
);