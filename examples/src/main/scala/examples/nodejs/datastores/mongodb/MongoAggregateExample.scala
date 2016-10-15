package examples.nodejs.datastores.mongodb

import examples.nodejs.datastores.mongodb.MongoAggregateExample._
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.mongodb._
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Mongo Aggregate Example
  * @author lawrence.daniels@gmail.com
  */
class MongoAggregateExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  // Correctly call the aggregation framework using a pipeline in an Array.

  var MongoClient = MongoDB().MongoClient
  val test = Assert()

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
      writeResults <- collection.insertMany(docs, new WriteOptions(w = 1))

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
