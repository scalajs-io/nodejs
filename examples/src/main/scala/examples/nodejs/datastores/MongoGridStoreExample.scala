package examples.nodejs.datastores

import examples.nodejs.datastores.MongoGridStoreExample.FileData
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.mongodb.gridfs.GridStore
import org.scalajs.nodejs.mongodb.{Db, MongoDB}

import scala.scalajs.js

/**
  * Mongo Grid Store Example
  * @author lawrence.daniels@gmail.com
  */
class MongoGridStoreExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val Db = MongoDB().Db
  val MongoClient = MongoDB().MongoClient
  val Server = MongoDB().Server
  val ReplSetServers = MongoDB().ReplSetServers
  val ObjectID = MongoDB().ObjectID
  val Binary = MongoDB().Binary
  val GridStore = MongoDB().GridStore
  val Grid = MongoDB().Grid
  val Code = MongoDB().Code
  val BSON = MongoDB().pure().BSON
  val assert = Assert()

  // Establish connection to db
  var db = Db("test", Server("localhost", 27017))

  db.open((err: String, db: Db) => {
    // Create a file and open it
    val gridStore = GridStore(db, ObjectID(), "test_gs_getc_file", "w")
    gridStore.open((err: String, _: GridStore) => {
      // Write some content to the file
      gridStore.write(Buffer.from("hello, world!", "utf8"), (err: String, _: GridStore) => {
        // Flush the file to GridFS
        gridStore.close((err: String, fileData: js.Any) => {
          assert.equal(null, err)

          // Create another file with same name and and save content to it
          val gridStore = GridStore(db, ObjectID(), "test_gs_getc_file", "w")
          gridStore.open((err: String, _: GridStore) => {
            // Write some content to the file
            gridStore.write(Buffer.from("hello, world!", "utf8"), (err: String, _: GridStore) => {
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
