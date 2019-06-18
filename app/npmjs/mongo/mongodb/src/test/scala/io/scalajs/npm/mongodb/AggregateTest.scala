package io.scalajs.npm.mongodb

import io.scalajs.nodejs._
import org.scalatest.FunSpec

import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Aggregate Test
  * @author lawrence.daniels@gmail.com
  */
class AggregateTest extends FunSpec with MongoDBTestSupport {
  private val docs = js.Array(
    doc(
      "title" -> "this is my title",
      "author" -> "bob",
      "posted" -> new js.Date(),
      "pageViews" -> 5,
      "tags" -> js.Array("fun", "good", "fun"),
      "other" -> doc("foo" -> 5),
      "comments" -> js.Array(
        doc("author" -> "joe"),
        doc("text" -> "this is cool"),
        doc("author" -> "sam"),
        doc("text" -> "this is bad")
      )
    ))

  describe("Aggregate") {

    it("supports aggregating data") {

      withMongo("Aggregate") { db =>

        // if the promise hasn't complete in 1 sec, trigger it.
        setTimeout(() => db.close(), 2.seconds)

        // get a reference to the 'test' collection
        val coll = db.collection("aggregate_test")

        for {
        // remove any existing docs
          _ <- {
            info("Aggregate: deleting old docs...")
            coll.deleteMany(doc()).toFuture
          }

          // Insert the docs
          _ <- {
            info("Aggregate: inserting new docs...")
            coll.insertMany(docs, new WriteOptions(w = 1)).toFuture
          }

        // Execute aggregate, notice the pipeline is expressed as an Array
        /*
          result <- {
            info("Aggregate: aggregating data...")
            coll.aggregateFuture[Data](
              js.Array(
                doc("$project" -> doc("author" -> 1, "tags" -> 1)),
                doc("$unwind" -> "$tags"),
                doc("$group" -> doc("_id" -> doc("tags" -> "$tags"), "authors" $addToSet "$author"))
              ))
          }*/
        } yield {
          /*
          info(s"Aggregate: result => ${result.toJson}")
          Assert.equal("good", result(0)._id.tags)
          Assert.deepEqual(js.Array("bob"), result(0).authors)
          Assert.equal("fun", result(1)._id.tags)
          Assert.deepEqual(js.Array("bob"), result(1).authors)*/
        }
      }

    }

  }
}

/**
  * Aggregate Test Companion
  * @author lawrence.daniels@gmail.com
  */
object AggregateTest {

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
