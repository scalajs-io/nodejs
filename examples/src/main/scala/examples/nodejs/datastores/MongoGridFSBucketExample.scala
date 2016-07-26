package examples.nodejs.datastores

import org.scalajs.nodejs._
import org.scalajs.nodejs.globals.process
import org.scalajs.nodejs.mongodb.Db
import org.scalajs.dom.console
import org.scalajs.nodejs.Bootstrap
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.fs.Fs
import org.scalajs.nodejs.mongodb.{Db, MongoDB}

import scala.scalajs.js

/**
  * GridFS Bucket Example
  * @author lawrence.daniels@gmail.com
  */
class MongoGridFSBucketExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val assert = Assert()
  val fs = Fs()
  val mongodb = MongoDB()

  val uri = "mongodb://localhost:27017/test"

  mongodb.MongoClient.connect(uri, (error: js.Any, db: Db) => {
    assert.ifError(error)

    val bucket = mongodb.GridFSBucket(db)

    fs.createReadStream("/tmp/kickin_combo_2.jpg").
      pipe(bucket.openUploadStream("meistersinger.mp3")).
      on("error", (error: js.Any) => assert.ifError(error)).
      on("finish", () => {
        console.log("done!")
        process.exit(0)
      })
  })

}
