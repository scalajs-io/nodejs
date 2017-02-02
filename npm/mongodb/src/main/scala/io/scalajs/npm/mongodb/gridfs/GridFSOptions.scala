package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridFSOptions(var bucketName: js.UndefOr[String] = js.undefined,
                    var chunkSizeBytes: js.UndefOr[Int] = js.undefined,
                    var readPreference: js.UndefOr[js.Any] = js.undefined,
                    var writeConcern: js.UndefOr[js.Any] = js.undefined)
    extends js.Object
