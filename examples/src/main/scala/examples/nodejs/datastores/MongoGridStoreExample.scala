package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs.mongodb.Db
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.mongodb.{Db, MongoDB}
import com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs.GridStore
import com.github.ldaniels528.meansjs.nodejs.{Assert, Bootstrap, Require}
import examples.nodejs.datastores.MongoGridStoreExample.FileData

import scala.scalajs.js

/**
  * Mongo Grid Store Example
  * @author lawrence.daniels@gmail.com
  */
class MongoGridStoreExample(bootstrap: Bootstrap) {
  import bootstrap._

  val Db = require[MongoDB]("mongodb").Db
  val MongoClient = require[MongoDB]("mongodb").MongoClient
  val Server = require[MongoDB]("mongodb").Server
  val ReplSetServers = require[MongoDB]("mongodb").ReplSetServers
  val ObjectID = require[MongoDB]("mongodb").ObjectID
  val Binary = require[MongoDB]("mongodb").Binary
  val GridStore = require[MongoDB]("mongodb").GridStore
  val Grid = require[MongoDB]("mongodb").Grid
  val Code = require[MongoDB]("mongodb").Code
  val BSON = require[MongoDB]("mongodb").pure().BSON
  val assert = require[Assert]("assert")

  // Establish connection to db
  var db = Db("test", Server("localhost", 27017))

  db.open((err: String, db: Db) => {
    // Create a file and open it
    val gridStore = GridStore(db, ObjectID(), "test_gs_getc_file", "w")
    gridStore.open((err: String, _: GridStore) => {
      // Write some content to the file
      gridStore.write(Buffer("hello, world!", "utf8"), (err: String, _: GridStore) => {
        // Flush the file to GridFS
        gridStore.close((err: String, fileData: js.Any) => {
          assert.equal(null, err)

          // Create another file with same name and and save content to it
          val gridStore = GridStore(db, ObjectID(), "test_gs_getc_file", "w")
          gridStore.open((err: String, _: GridStore) => {
            // Write some content to the file
            gridStore.write(Buffer("hello, world!", "utf8"), (err: String, _: GridStore) => {
              // Flush the file to GridFS
              gridStore.close((err: String, fileData: FileData) => {
                assert.equal(null, err)

                // Open the file in read mode using the filename
                var gridStore2 = GridStore(db, "test_gs_getc_file", "r")
                gridStore2.open((err: String, gridStore: GridStore) => {

                  // Read first character and verify
                  gridStore.getc((err: String, chr: String) => {
                    assert.equal("h", chr)

                    // Open the file using an object id
                    gridStore2 = GridStore(db, fileData._id, "r")
                    gridStore2.open((err: String, gridStore: GridStore) => {

                      // Read first character and verify
                      gridStore.getc((err: String, chr: String) => {
                        assert.equal("h", chr)

                        db.close()
                      })
                    })
                  })
                })
              })
            })
          })
        })
      })
    })
  })

}

/**
  * Mongo Example Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoGridStoreExample {

  @js.native
  trait FileData extends js.Object {
    var _id: js.Any = js.native
  }

}
