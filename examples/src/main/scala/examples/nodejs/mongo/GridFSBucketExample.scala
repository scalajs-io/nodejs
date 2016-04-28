package examples.nodejs.mongo

import com.github.ldaniels528.meansjs.mongodb._
import com.github.ldaniels528.meansjs.nodejs._
import com.github.ldaniels528.meansjs.nodejs.fs.Fs
import org.scalajs.dom.console

import scala.scalajs.js

/**
  * GridFS Bucket Example
  * @author lawrence.daniels@gmail.com
  */
class GridFSBucketExample(require: Require) {

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
