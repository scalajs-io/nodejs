package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.buffer._
import com.github.ldaniels528.meansjs.nodejs.core.Assert
import com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs.GridOptions
import com.github.ldaniels528.meansjs.nodejs.mongodb.{Db, MongoDB}

import scala.scalajs.js

/**
  * Mongo Grid Example
  * @author lawrence.daniels@gmail.com 
  */
class MongoGridExample(bootstrap: Bootstrap) {
  import bootstrap._

  val Db = require[MongoDB]("mongodb").Db
  val Server = require[MongoDB]("mongodb").Server
  val Grid = require[MongoDB]("mongodb").Grid
  val assert = require[Assert]("assert")

  val db = Db("test", Server("localhost", 27017))
  // Establish connection to db
  db.open((err: js.Any, db: Db) => {
    // Create a new grid instance
    val grid = Grid(db, "fs")
    // Some data to write
    val originalData = Buffer("Hello world")
    // Write data to grid
    grid.put(originalData, GridOptions(), (err: js.Any, result: MyResult) => {
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

@js.native
trait MyResult extends js.Object {
  var _id: js.Any = js.native
}
