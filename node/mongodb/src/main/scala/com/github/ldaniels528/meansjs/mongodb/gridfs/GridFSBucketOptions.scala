package com.github.ldaniels528.meansjs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridFSBucketOptions extends js.Object {
  var bucketName: js.UndefOr[String] = _
  var chunkSizeBytes: js.UndefOr[Int] = _
  var readPreference: js.UndefOr[js.Any] = _
  var writeConcern: js.UndefOr[js.Any] = _

}

/**
  * GridFS Bucket Options
  * @author lawrence.daniels@gmail.com
  */
object GridFSBucketOptions {

  def apply(bucketName: js.UndefOr[String] = js.undefined,
            chunkSizeBytes: js.UndefOr[Int] = js.undefined,
            readPreference: js.UndefOr[js.Any] = js.undefined,
            writeConcern: js.UndefOr[js.Any] = js.undefined) = {
    val options = new GridFSBucketOptions()
    options.bucketName = bucketName
    options.chunkSizeBytes = chunkSizeBytes
    options.readPreference = readPreference
    options.writeConcern = writeConcern
    options
  }

}
