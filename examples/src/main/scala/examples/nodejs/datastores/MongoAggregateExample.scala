package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.mongodb.{Db, MongoDB, MongoError, WriteOptions, _}
import com.github.ldaniels528.meansjs.nodejs.Bootstrap
import com.github.ldaniels528.meansjs.nodejs.core.Assert
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import examples.nodejs.datastores.MongoAggregateExample.Data

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Mongo Aggregate Example
  * @author lawrence.daniels@gmail.com
  */
class MongoAggregateExample(bootstrap: Bootstrap) {
  import bootstrap._

  // Correctly call the aggregation framework using a pipeline in an Array.

  var MongoClient = require[MongoDB]("mongodb").MongoClient
  val test = require[Assert]("assert")

  MongoClient.connect("mongodb://localhost:27017/test", (err: MongoError, db: Db) => {
    // Some docs for insertion
    val docs = js.Array(
      doc("title" -> "this is my title", "author" -> "bob", "posted" -> new js.Date(),
        "pageViews" -> 5, "tags" -> js.Array("fun", "good", "fun"), "other" -> doc("foo" -> 5),
        "comments" -> js.Array(
          doc("author" -> "joe"),
          doc("text" -> "this is cool"),
          doc("author" -> "sam"),
          doc("text" -> "this is bad")
        )))

    for {
      // Create a collection
      collection <- db.collectionFuture("aggregationExample1")

      // Insert the docs
      writeResults <- collection.insertMany(docs, WriteOptions(w = 1))

      // Execute aggregate, notice the pipeline is expressed as an Array
      result <- collection.aggregateFuture[Data](js.Array(
        doc("$project" -> doc("author" -> 1, "tags" -> 1)),
        doc("$unwind" -> "$tags"),
        doc("$group" -> doc("_id" -> doc("tags" -> "$tags"), "authors" $addToSet "$author"))
      ))
    } {
      test.equal("good", result(0)._id.tags)
      test.deepEqual(js.Array("bob"), result(0).authors)
      test.equal("fun", result(1)._id.tags)
      test.deepEqual(js.Array("bob"), result(1).authors)
      db.close()
    }
  })

}

/**
  * Mongo Aggregate Example Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoAggregateExample {

  @js.native
  trait Data extends js.Object {
    var _id: Tags = js.native
    var authors: js.Array[String] = js.native
  }

  @js.native
  trait Tags extends js.Object {
    var tags: String = js.native
  }

}
