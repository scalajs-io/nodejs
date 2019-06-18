package io.scalajs.npm.mongodb

import io.scalajs.nodejs._
import io.scalajs.npm.mongodb.CursorTest.Sample
import org.scalatest.FunSpec

import scala.concurrent.Promise
import scala.concurrent.duration._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js


/**
  * Cursor Tests
  * @author lawrence.daniels@gmail.com
  */
class CursorTest extends FunSpec with MongoDBTestSupport {

  describe("Cursor") {

    it("supports streaming") {

      withMongo("Cursor") { db =>

        val  coll = db.collection("cursor_test")
        for {
          // remove any existing docs
          _ <- coll.deleteMany(doc()).toFuture

          // insert our new docs
          iwr <- coll.insertMany(js.Array(new Sample(a = 1), new Sample(a = 2), new Sample(a = 3))).toFuture

          data <- {
            // did we get at least 3 records?
            if (iwr.result.n < 3) throw js.JavaScriptException("At least 3 records were expected")

            // get the results using a find stream
            val promise = Promise[Unit]()
            val stream = coll.find[Sample](doc()).stream()
            stream
              .onData[Sample](doc => info(doc.toString))
              .onError(error => promise.failure(js.JavaScriptException(error.message)))
              .onEnd(() => promise.success(()))

            // if the promise hasn't complete in 1 sec, trigger it.
            setTimeout(() => if (!promise.isCompleted) promise.success(()), 1.second)

            promise.future
          }
        } yield data

      }

    }

  }

}

/**
  * Cursor Test Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorTest {


  class Sample(var _id: js.UndefOr[ObjectID] = js.undefined,
               var a: js.UndefOr[Int] = js.undefined)
    extends js.Object

}
