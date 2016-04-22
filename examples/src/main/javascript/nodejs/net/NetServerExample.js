/**
 * Net Server Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const net = require('net');
    
    const client = net.connect({port: 8124}, function () {
        console.log('connected to server!');
        client.write('world!\r\n');
    });

    client.on('data', function (data) {
        console.log(data.toString());
        client.end();
    });

    client.on('end', function () {
        console.log('disconnected from server');
    });
    
})();