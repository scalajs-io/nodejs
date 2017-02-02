package io.scalajs.npm.mongodb

import io.scalajs.nodejs.Assert
import io.scalajs.npm.mongodb.MongoAggregateTest._
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * MongoDB Aggregate Test
  * @author lawrence.daniels@gmail.com
  */
class MongoAggregateTest extends FunSpec {
  val jsAssert = Assert()

  it("supports aggregation") {

    MongoClient.connect(
      "mongodb://localhost:27017/test",
      (err, db) => {
        jsAssert.equal(err == null, err.toString)

        // Some docs for insertion
        val docs = js.Array(
          doc(
            "title"     -> "this is my title",
            "author"    -> "bob",
            "posted"    -> new js.Date(),
            "pageViews" -> 5,
            "tags"      -> js.Array("fun", "good", "fun"),
            "other"     -> doc("foo" -> 5),
            "comments" -> js.Array(
              doc("author" -> "joe"),
              doc("text"   -> "this is cool"),
              doc("author" -> "sam"),
              doc("text"   -> "this is bad")
            )
          ))

        for {
          // Create a collection
          collection <- db.collectionFuture("aggregationExample1")

          // Insert the docs
          writeResults <- collection.insertMany(docs, new WriteOptions(w = 1))

          // Execute aggregate, notice the pipeline is expressed as an Array
          result <- collection.aggregateFuture[Data](
            js.Array(
              doc("$project" -> doc("author" -> 1, "tags" -> 1)),
              doc("$unwind"  -> "$tags"),
              doc("$group"   -> doc("_id" -> doc("tags" -> "$tags"), "authors" $addToSet "$author"))
            ))
        } {
          jsAssert.equal("good", result(0)._id.tags)
          jsAssert.deepEqual(js.Array("bob"), result(0).authors)
          jsAssert.equal("fun", result(1)._id.tags)
          jsAssert.deepEqual(js.Array("bob"), result(1).authors)
          db.close()
        }
      }
    )
  }

}

/**
  * AggregateTest Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoAggregateTest {

  @js.native
  trait Data extends js.Object {
    var _id: Tags                 = js.native
    var authors: js.Array[String] = js.native
  }

  @js.native
  trait Tags extends js.Object {
    var tags: String = js.native
  }

}
