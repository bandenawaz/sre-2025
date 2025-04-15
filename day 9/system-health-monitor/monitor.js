import os from 'os';
import chalk from 'chalk';

function getCpuUsage(callback) {
  
    //get initial CPU measurement
    const startMeasurement = os.cpus();

    //lets wait for a second
    setTimeout(() => {
        //get CPU measurement after a second
        const endMeasurement = os.cpus();

        //calculate the CPU usage
        const cpuUsage = endMeasurement.map((core, index) =>{

            const startTime = startMeasurement[index].times;
            const endTime = core.times;

            const idleDiff = endTime.idle - startTime.idle;
            const totalDiff = Object.values(endTime).reduce((acc, val) => acc + val, 0) -
                                 Object.values(startTime).reduce((acc, val) => acc + val, 0);

            return{
                coreIndex: index,
                usage: ((1 - idleDiff / totalDiff) * 100).toFixed(2) + '%'
            }
        });

        callback(cpuUsage);

       
    },3000);

    console.log("Measuring CPU Usage...");
    console.log("Meanwhile, Nodejs will continue to run other tasks");
}

getCpuUsage((cpuUsage) => {
    console.log(chalk.bold("CPU Usage:"));
    cpuUsage.forEach((core) => {
        const usage = parseFloat(core.usage);
        let color = chalk.green;
        if (usage > 70) color = chalk.yellow;
        if (usage > 90) color = chalk.red;
        console.log(`Core ${core.coreIndex}: ${color(core.usage)}`);
    });
});