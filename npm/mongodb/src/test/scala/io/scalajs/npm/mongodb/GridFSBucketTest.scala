package io.scalajs.npm.mongodb

import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.mongodb.gridfs.GridFSBucket
import org.scalatest.FunSpec

/**
  * GridFSBucket Test
  * @author lawrence.daniels@gmail.com
  */
class GridFSBucketTest  extends FunSpec  {
  val url = "mongodb://localhost:27017/test"

  describe("GridFSBucket") {

    it("supports streaming files to disk") {
      MongoClient.connect(url, (err, db) => {
        assert(null == err, err)

        val bucket = new GridFSBucket(db)
        Fs.createReadStream(Fs.realpathSync("./npm/mongodb/src/test/resources/kermit-yoda.jpeg"))
          .pipe(bucket.openUploadStream("kermit+yoda.jpeg"))
          .on("error", (error: MongoError) => assert(null == error, error))
      })
    }

  }

}
