package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.mongodb.{Db, MongoDB, ReadPreference, _}
import com.github.ldaniels528.meansjs.nodejs.{Assert, Bootstrap}

import scala.scalajs.js

/**
  * MongoDB Collection Example
  * @author lawrence.daniels@gmail.com
  */
class MongoCollectionExample(bootstrap: Bootstrap) {
  import bootstrap._

  val assert = require[Assert]("assert")
  val mongodb = require[MongoDB]("mongodb")

  val uri = "mongodb://localhost:27017/test"

  mongodb.MongoClient.connect(uri, (error: js.Any, db: Db) => {
    assert.ifError(error)

    val collection = db.collection("test")
    collection.find(doc()).project(doc("a" -> 1)) // Create a projection of field a
    collection.find(doc()).skip(1).limit(10) // Skip 1 and limit 10
    collection.find(doc()).batchSize(5) // Set batchSize on cursor to 5
    collection.find(doc()).filter(doc("a" -> 1)) // Set query on the cursor
    collection.find(doc()).comment("add a comment") // Add a comment to the query, allowing to correlate queries
    collection.find(doc()).addCursorFlag("tailable", value = true) // Set cursor as tailable
    collection.find(doc()).addCursorFlag("oplogReplay", value = true) // Set cursor as oplogReplay
    collection.find(doc()).addCursorFlag("noCursorTimeout", value = true) // Set cursor as noCursorTimeout
    collection.find(doc()).addCursorFlag("awaitData", value = true) // Set cursor as awaitData
    collection.find(doc()).addCursorFlag("partial", value = true) // Set cursor as partial
    collection.find(doc()).addQueryModifier("$orderby", doc("a" -> 1)) // Set $orderby {a:1}
    collection.find(doc()).max(10) // Set the cursor maxScan
    collection.find(doc()).maxScan(10) // Set the cursor maxScan
    collection.find(doc()).maxTimeMS(1000) // Set the cursor maxTimeMS
    collection.find(doc()).min(100) // Set the cursor min
    collection.find(doc()).returnKey(10) // Set the cursor returnKey
    collection.find(doc()).setReadPreference(ReadPreference.PRIMARY) // Set the cursor readPreference
    collection.find(doc()).showRecordId(true) // Set the cursor showRecordId
    collection.find(doc()).snapshot(true) // Set the cursor snapshot
    collection.find(doc()).sort(js.Array(js.Array("a", 1))) // Sets the sort order of the cursor query
    collection.find(doc()).hint("a_1") // Set the cursor hint
  })

}
