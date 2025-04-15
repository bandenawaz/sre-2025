import EventEmitter from 'events';
import fs from 'fs';
import os from 'os';

class LoggingMonitor extends EventEmitter{

    constructor(){
        super();
        this.logFile = 'system-health.log';
        this.checkInterval = 5000;

        //lets create a logfile if it doesn't exist
        if(!fs.existsSync(this.logFile)){
            fs.writeFileSync(this.logFile, 'TIMESTAMP, CPU_USAGE, MEMORY_USAGE\n');
        }

        //this.startMonitoring();
    }

    async getCpuUsagePercentage(){
        return new Promise((resolve) => {
            const startMeasurement = os.cpus();

            setTimeout(() => {
                const endMeasurement = os.cpus();
                let totalIdle = 0;
                let totalTick = 0;

                endMeasurement.forEach((core, i) => {
                    const statCore = startMeasurement[i].times;
                    const endCore = core.times;

                    //Calculate the difference in idle and total time
                    const idleDiff = endCore.idle - statCore.idle;
                    const totalDiff = Object.values(endCore).reduce((acc, val) => acc + val, 0) -
                                     Object.values(statCore).reduce((acc, val) => acc + val, 0);

                    totalIdle += idleDiff;
                    totalTick += totalDiff;
                });

                //Average CPU usage across all cores
                const cpuUsage = ((1 - totalIdle / totalTick) * 100).toFixed(2);
                resolve(cpuUsage);
            }, 2000);
        });
    }

    async start(){

        console.log(`Starting monitoring with log at ${this.logFile}`);

        setInterval(async () => {

            //Lets get the metrics
            const cpuUsage = await this.getCpuUsagePercentage();
            const memoryUsage =((1 - os.freemem() / os.totalmem()) * 100).toFixed(2);
            const timestamp = new Date().toISOString();

            //Create a log entry
            const logEntry = `${timestamp}, ${cpuUsage}%, ${memoryUsage}%\n`;

            //Append to the log file
            fs.appendFile(this.logFile, logEntry, (err) => {
                if(err) {
                    console.error(`Error writing to log file: ${err}`) 
                    return;
                }
                //Emit an event with the data
                this.emit('metrics_logged', {
                    timestamp,
                    cpu: cpuUsage,
                    memory: memoryUsage
                });
            });

        }, this.checkInterval);
    }

    getLatestLogs(lines = 10){
        try{
            const data = fs.readFileSync(this.logFile, 'utf8');
            return data.split('\n').slice(-lines).join('\n');
        }catch(err){
            console.error(`Error reading log file: ${err}`);
            return 'Error reading logs';
        }
    }
}

//lets instantiate and use the logging monitor
const monitor = new LoggingMonitor();
monitor.on('metrics_logged', (data) => {
    console.log(`Logged metrics: Timestamp - ${data.timestamp}, CPU Usage - ${data.cpu}%, 
        Memory Usage - ${data.memory}%`);
});

monitor.start();

//After 30 seconds, display the latest logs
setTimeout(() => {
    console.log('\nLatest logs from file :');
    console.log(monitor.getLatestLogs());
}, 30000);

//To stop monitoring, you can call monitor.stop()