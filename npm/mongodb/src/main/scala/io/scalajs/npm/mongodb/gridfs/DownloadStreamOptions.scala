package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Download Stream Options
  * @param start Optional 0-based offset in bytes to start streaming from
  * @param end   Optional 0-based offset in bytes to stop streaming before
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DownloadStreamOptions(var start: js.UndefOr[Int] = js.undefined, var end: js.UndefOr[Int] = js.undefined)
    extends js.Object
