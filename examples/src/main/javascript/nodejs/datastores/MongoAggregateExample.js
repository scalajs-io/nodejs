/**
 * Mongo Aggregate Example
 * @author lawrence.daniels@gmail.com
 */
(function() {

    // Correctly call the aggregation framework using a pipeline in an Array.

    var MongoClient = require('mongodb').MongoClient,
        test = require('assert');
    MongoClient.connect('mongodb://localhost:27017/test', function(err, db) {
        // Some docs for insertion
        var docs = [{
            title : "this is my title", author : "bob", posted : new Date() ,
            pageViews : 5, tags : [ "fun" , "good" , "fun" ], other : { foo : 5 },
            comments : [
                { author :"joe", text : "this is cool" }, { author :"sam", text : "this is bad" }
            ]}];

        // Create a collection
        var collection = db.collection('aggregationExample1');
        // Insert the docs
        collection.insertMany(docs, {w: 1}, function(err, result) {

            // Execute aggregate, notice the pipeline is expressed as an Array
            collection.aggregate([
                { $project : {
                    author : 1,
                    tags : 1
                }},
                { $unwind : "$tags" },
                { $group : {
                    _id : {tags : "$tags"},
                    authors : { $addToSet : "$author" }
                }}
            ], function(err, result) {
                test.equal(null, err);
                test.equal('good', result[0]._id.tags);
                test.deepEqual(['bob'], result[0].authors);
                test.equal('fun', result[1]._id.tags);
                test.deepEqual(['bob'], result[1].authors);

                db.close();
            });
        });
    });

})();