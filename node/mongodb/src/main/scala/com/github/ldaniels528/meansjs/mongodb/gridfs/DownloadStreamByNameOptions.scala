package com.github.ldaniels528.meansjs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Download Stream (By Name) Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DownloadStreamByNameOptions extends js.Object {
  /** The revision number relative to the oldest file with the given filename. 0 gets you the oldest file,
    * 1 gets you the 2nd oldest, -1 gets you the newest. */
  var revision: js.UndefOr[Integer] = _

  /** Optional 0-based offset in bytes to start streaming from */
  var start: js.UndefOr[Integer] = _

  /** Optional 0-based offset in bytes to stop streaming before */
  var end: js.UndefOr[Integer] = _

}

/**
  * GridFS Bucket Download Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DownloadStreamByNameOptions {

  def apply(revision: js.UndefOr[Integer] = js.undefined,
            start: js.UndefOr[Integer] = js.undefined,
            end: js.UndefOr[Integer] = js.undefined) = {
    val options = new DownloadStreamByNameOptions()
    options.revision = revision
    options.start = start
    options.end = end
    options
  }

}