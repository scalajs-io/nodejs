/**
 * Producer Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    const kafka = require('kafka-node'),
        Producer = kafka.Producer,
        client = new kafka.Client('dev528:2181'),
        producer = new Producer(client);

    const payloads = [
        {topic: 'test', messages: 'This is the First Message I am sending'/*, partition: 0*/}
    ];


    // producer 'on' ready to send payload to kafka.
    producer.on('ready', function () {
        console.log("Received ready:");

        producer.send(payloads, function (err, data) {
            console.log("Received data:");
            console.log(data)
        });
    });

    producer.on('error', function (err) {
        console.log("Received error:");
        console.log(err)
    });
});