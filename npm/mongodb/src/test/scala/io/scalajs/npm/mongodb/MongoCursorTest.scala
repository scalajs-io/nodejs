package io.scalajs.npm.mongodb

import io.scalajs.nodejs.console
import io.scalajs.npm.mongodb.MongoCursorTest.Sample
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * MongoDB Cursor Tests
  * @author lawrence.daniels@gmail.com
  */
class MongoCursorTest extends FunSpec {
  val url = "mongodb://localhost:27017/test"

  describe("Cursor") {

    it("supports streaming") {
      /*
      MongoClient.connect(url, (err, db) => {
        assert(null == err, err)
        console.log("Connected correctly to server")

        val col = db.collection("streams")

        // Insert a single document
        col.insertMany(js.Array(new Sample(a = 1), new Sample(a = 2), new Sample(a = 3)), (err, iwr) => {
          assert(null == err, err.toString)
          assert(3 == iwr.result.n)

          // Get the results using a find stream
          val cursor = col.find(doc()).stream(StreamTransform((doc: Sample) => JSON.stringify(doc)))

          cursor.onData((doc: Sample) => console.log(doc))

          cursor.onOnce(() => db.close())
        })
      })*/

    }

  }

}

/**
  * MongoCursorTest Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoCursorTest {

  @ScalaJSDefined
  class Sample(var _id: js.UndefOr[ObjectID] = js.undefined,
               var a: js.UndefOr[Int] = js.undefined) extends js.Object

}