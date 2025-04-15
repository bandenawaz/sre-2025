import express from 'express';
import os from 'os';


const app = express();
const PORT = 3000;

//lets serve a static HTML 
app.get('/', (req, res) => {
    res.send(`
        <html>
            <head>
                <title>System Health Monitor</title>
                <style>
                    body{
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        margin: 20px;
                        padding: 0;
                    }
                        .metric{
                            border: 1px solid #ddd;
                            padding: 10px;
                            margin: 10px 0;
                        }
                </style>
            </head>

            <body>
                <h1>System Health Monitor</h1>
                <div class="metric">
                    <h3>Hostname: ${os.hostname()}</h3>
                    <p>OS: ${os.type()} ${os.release()}</p>
                    <p>Uptime: ${Math.floor(os.uptime() / 3600)} hours,
                        ${Math.floor((os.uptime() % 3600) / 60)} minutes </p>

                    <p>Free Memory: ${Math.round(os.freemem() / (1024 * 1024 * 1024))} GB / ${Math.round(os.totalmem() / (1024 * 1024 * 1024))} GB</p>
                </div>
            </body>
        </html>
        `);
});

//start the server
app.listen(PORT, () => {
    console.log(`System Health Monitor is running on http://localhost:${PORT}`);
});