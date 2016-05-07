/**
 * Mongo Grid Example
 * @author lawrence.daniels@gmail.com
 */
(function () {

    var Db = require('mongodb').Db,
        Server = require('mongodb').Server,
        Grid = require('mongodb').Grid,
        assert = require('assert');
    
    console.log(Grid);
  
    var db = new Db('test', new Server('localhost', 27017));
    // Establish connection to db
    db.open(function (err, db) {
        // Create a new grid instance
        var grid = new Grid(db, 'fs');
        // Some data to write
        var originalData = new Buffer('Hello world');
        // Write data to grid
        grid.put(originalData, {}, function (err, result) {
            // Fetch the content
            grid.get(result._id, function (err, data) {
                assert.deepEqual(originalData.toString('base64'), data.toString('base64'));

                // Should fail due to illegal objectID
                grid.get('not an id', function (err, result) {
                    assert.ok(err != null);

                    db.close();
                });
            });
        });
    });

})();


