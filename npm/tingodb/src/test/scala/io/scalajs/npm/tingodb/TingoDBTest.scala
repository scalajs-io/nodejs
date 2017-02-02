package io.scalajs.npm.tingodb

import io.scalajs.nodejs.console
import io.scalajs.npm.mongodb.WriteOptions
import io.scalajs.npm.tingodb.DbClass._
import org.scalatest.FunSpec

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * TingoDB Test
  * @author lawrence.daniels@gmail.com
  */
class TingoDBTest extends FunSpec {

  describe("TingoDB") {
    val tingoDB = TingoDB(new TingoDbOptions())

    it("supports creating a local MongoDB server") {
      // TODO use mock or embedded server
      /*
      //val db = new Db("test", new js.Object())
      val db = tingoDB.Db("test", new js.Object())
      console.log("db => ", db)

      val collection = db.collection("batch_document_insert_collection_safe")
      collection.insertMany(
        js.Array(new TestDoc(hello = "world_safe1"), new TestDoc(hello = "world_safe2")),
        new WriteOptions(w = 1),
        (err, result) => {
          assert(err == null, err)
          console.log("result => ", result)

          collection.findOne(new TestDoc(hello = "world_safe2"), (err: String, item: TestDoc) => {
            assert(err == null, err)
            assert("world_safe2" == item.hello)
          })
        })*/
    }

  }

  @ScalaJSDefined
  class TestDoc(val hello: String) extends js.Object

}
