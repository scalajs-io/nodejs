package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Download Stream (By Name) Options
  * @param revision The revision number relative to the oldest file with the given filename. 0 gets you the oldest file,
  *                 1 gets you the 2nd oldest, -1 gets you the newest.
  * @param start    Optional 0-based offset in bytes to start streaming from
  * @param end      Optional 0-based offset in bytes to stop streaming before
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DownloadStreamByNameOptions(var revision: js.UndefOr[Int] = js.undefined,
                                  var start: js.UndefOr[Int] = js.undefined,
                                  var end: js.UndefOr[Int] = js.undefined)
    extends js.Object
