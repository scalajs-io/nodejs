var Db = require('tingodb')({memStore: true}).Db,
    assert = require('assert'),
    fs = require("fs"),
    util = require("util");

var tingodb = require('tingodb')()
console.log(util.inspect(tingodb))

var db = new Db("", {});
// Fetch a collection to insert document into
var collection = db.collection("batch_document_insert_collection_safe");
// Insert a single document
collection.insert([{hello:'world_safe1'}, {hello:'world_safe2'}], {w:1}, function(err, result) {
  assert.equal(null, err);

  // Fetch the document
  collection.findOne({hello:'world_safe2'}, function(err, item) {
    console.info(JSON.stringify(item))
    assert.equal(null, err);
    assert.equal('world_safe2', item.hello);
  })
});