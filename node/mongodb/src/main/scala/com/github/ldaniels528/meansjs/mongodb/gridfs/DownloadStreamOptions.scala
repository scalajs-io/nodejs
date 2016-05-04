package com.github.ldaniels528.meansjs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Download Stream Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DownloadStreamOptions extends js.Object {
  // Optional 0-based offset in bytes to start streaming from
  var start: js.UndefOr[Int] = _

  // Optional 0-based offset in bytes to stop streaming before
  var end: js.UndefOr[Int] = _

}

/**
  * GridFS Bucket Download Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DownloadStreamOptions {

  def apply(start: js.UndefOr[Int] = js.undefined,
            end: js.UndefOr[Int] = js.undefined) = {
    val options = new DownloadStreamOptions()
    options.start = start
    options.end = end
    options
  }

}