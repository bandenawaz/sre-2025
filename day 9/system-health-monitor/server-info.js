import os from 'os';

console.log("System Health Monitor");

console.log("---------------------------------");
console.log(`HostName: ${os.hostname()}`);
console.log(`Operating System Type: ${os.type()} ${os.release()}`);
console.log(`CPU Architecture: ${os.arch()}`);
console.log(`Total Memory: ${Math.round(os.totalmem() / (1024 * 1024 * 1024))} GB`);
