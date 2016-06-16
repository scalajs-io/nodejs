package examples.nodejs.datastores

import org.scalajs.nodejs._
import org.scalajs.nodejs.buffer._
import org.scalajs.nodejs.mongodb.Db
import examples.nodejs.datastores.MongoGridExample.MyResult
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.mongodb.{Db, MongoDB}
import org.scalajs.nodejs.mongodb.gridfs.GridOptions

import scala.scalajs.js

/**
  * Mongo Grid Example
  * @author lawrence.daniels@gmail.com 
  */
class MongoGridExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val Db = MongoDB().Db
  val Server = MongoDB().Server
  val Grid = MongoDB().Grid
  val assert = Assert()

  val db = Db("test", Server("localhost", 27017))
  // Establish connection to db
  db.open((err: js.Any, db: Db) => {
    // Create a new grid instance
    val grid = Grid(db, "fs")
    // Some data to write
    val originalData = Buffer("Hello world")
    // Write data to grid
    grid.put(originalData, new GridOptions(), (err: js.Any, result: MyResult) => {
      // Fetch the content
      grid.get(result._id, (err: js.Any, data: Buffer) => {
        assert.deepEqual(originalData.toString("base64"), data.toString("base64"))

        // Should fail due to illegal objectID
        grid.get("not an id", (err: js.Any, result: MyResult) => {
          assert.ok(err != null)

          db.close()
        })
      })
    })
  })

}

object MongoGridExample {

  @js.native
  trait MyResult extends js.Object {
    var _id: js.Any = js.native
  }

}