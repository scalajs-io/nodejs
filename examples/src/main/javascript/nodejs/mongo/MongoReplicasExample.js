(function () {

    var async = require('async')
        , mongodb = require('mongodb')
        , Db = mongodb.Db
        , Connection = mongodb.Connection
        , Server = mongodb.Server
        , ReplSetServers = mongodb.ReplSetServers;

    async.waterfall([
        function (callback) {
            var rls = new ReplSetServers([
                new Server('localhost', 27017, {}), // Just mongod instance
                new Server('localhost', 27018, {}), // Offline
                new Server('localhost', 27019, {}) // Offline
            ]);

            new Db('test', rls, {w: 0}).open(function (err, db) {
                callback(err, db);
            });
        }
    ], function (err, db) {
        if (err) console.error(err);
        if (db) db.close();
    });

})();

