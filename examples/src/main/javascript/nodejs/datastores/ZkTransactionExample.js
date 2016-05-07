/**
 * Transaction Example
 * @author lawrence.daniels@gmail.com
 */
(function() {

    const zookeeper = require("node-zookeeper-client");
    const client = zookeeper.createClient(process.argv[2] || 'localhost:2181');

    client.once('connected', function () {
        console.log("Creating '/txn'...");
        client.transaction().
        create('/txn').
        create('/txn/1', new Buffer('transaction')).
        setData('/txn/1', new Buffer('test'), -1).
        check('/txn/1').
        remove('/txn/1', -1).
        remove('/txn').
        commit(function (error, results) {
            if (error) {
                console.log(
                    'Failed to execute the transaction: %s, results: %j',
                    error,
                    results
                );

                return;
            }

            console.log('Transaction completed.');
            client.close();
        });
    });

    client.connect();
})();
