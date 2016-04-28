var Db = require('mongodb').Db,
    MongoClient = require('mongodb').MongoClient,
    Server = require('mongodb').Server,
    ReplSetServers = require('mongodb').ReplSetServers,
    ObjectID = require('mongodb').ObjectID,
    Binary = require('mongodb').Binary,
    GridStore = require('mongodb').GridStore,
    Grid = require('mongodb').Grid,
    Code = require('mongodb').Code,
    BSON = require('mongodb').pure().BSON,
    assert = require('assert');

var db = new Db('test', new Server('localhost', 27017));
// Establish connection to db
db.open(function(err, db) {
    // Create a file and open it
    var gridStore = new GridStore(db, new ObjectID(), "test_gs_getc_file", "w");
    gridStore.open(function(err, gridStore) {
        // Write some content to the file
        gridStore.write(new Buffer("hello, world!", "utf8"), function(err, gridStore) {
            // Flush the file to GridFS
            gridStore.close(function(err, fileData) {
                assert.equal(null, err);

                // Create another file with same name and and save content to it
                gridStore = new GridStore(db, new ObjectID(), "test_gs_getc_file", "w");
                gridStore.open(function(err, gridStore) {
                    // Write some content to the file
                    gridStore.write(new Buffer("hello, world!", "utf8"), function(err, gridStore) {
                        // Flush the file to GridFS
                        gridStore.close(function(err, fileData) {
                            assert.equal(null, err);

                            // Open the file in read mode using the filename
                            var gridStore2 = new GridStore(db, "test_gs_getc_file", "r");
                            gridStore2.open(function(err, gridStore) {

                                // Read first character and verify
                                gridStore.getc(function(err, chr) {
                                    assert.equal('h', chr);

                                    // Open the file using an object id
                                    gridStore2 = new GridStore(db, fileData._id, "r");
                                    gridStore2.open(function(err, gridStore) {

                                        // Read first character and verify
                                        gridStore.getc(function(err, chr) {
                                            assert.equal('h', chr);

                                            db.close();
                                        })
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    });
});