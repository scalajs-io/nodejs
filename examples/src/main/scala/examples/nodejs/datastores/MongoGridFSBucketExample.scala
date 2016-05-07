package examples.nodejs.datastores

import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import com.github.ldaniels528.meansjs.nodejs.mongodb.{Db, MongoDB}
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * GridFS Bucket Example
  * @author lawrence.daniels@gmail.com
  */
class MongoGridFSBucketExample(bootstrap: Bootstrap) {
  import bootstrap._

  val assert = require[Assert]("assert")
  val fs = require[Fs]("fs")
  val mongodb = require[MongoDB]("mongodb")

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
