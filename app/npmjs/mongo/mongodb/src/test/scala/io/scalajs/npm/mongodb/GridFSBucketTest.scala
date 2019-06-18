package io.scalajs.npm.mongodb

import io.scalajs.nodejs._
import io.scalajs.nodejs.fs.Fs
import io.scalajs.npm.mongodb.gridfs.GridFSBucket
import org.scalatest.FunSpec

import scala.concurrent.Promise
import scala.concurrent.duration._
import scala.language.existentials

/**
  * GridFSBucket Test
  * @author lawrence.daniels@gmail.com
  */
class GridFSBucketTest extends FunSpec with MongoDBTestSupport {
  private val imagePath = Fs.realpathSync("./src/test/resources/kermit-yoda.jpeg")

  describe("GridFSBucket") {

    it("supports streaming files to disk") {

      withMongo("GridFSBucket") { db =>

        val promise = Promise[Unit]()
        val bucket = new GridFSBucket(db)

        info(s"GridFSBucket: Transferring image '$imagePath'...")
        Fs.createReadStream(imagePath)
          .pipe(bucket.openUploadStream("kermit-yoda.jpeg"))
          .onError(error => promise.failure(new RuntimeException(error.message)))
          .onEnd(() => promise.success(()))

        // if the promise hasn't complete in 1 sec, trigger it.
        setTimeout(() => if (!promise.isCompleted) promise.success(()), 1.second)

        promise.future
      }

    }

  }

}
