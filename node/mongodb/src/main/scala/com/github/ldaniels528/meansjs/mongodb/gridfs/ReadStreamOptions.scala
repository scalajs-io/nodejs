package com.github.ldaniels528.meansjs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Read Stream Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ReadStreamOptions extends js.Object {
  /** Optional sort for the file find query. */
  var sort: js.UndefOr[Integer] = _

  /** Optional skip for the file find query. */
  var skip: js.UndefOr[Integer] = _

  /** Optional 0-based offset in bytes to start streaming from */
  var start: js.UndefOr[Integer] = _

  /** Optional 0-based offset in bytes to stop streaming before */
  var end: js.UndefOr[Integer] = _

}

/**
  * GridFS Bucket Read Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ReadStreamOptions {

  def apply(sort: js.UndefOr[Integer] = js.undefined,
            skip: js.UndefOr[Integer] = js.undefined,
            start: js.UndefOr[Integer] = js.undefined,
            end: js.UndefOr[Integer] = js.undefined) = {
    val options = new ReadStreamOptions()
    options.sort = sort
    options.skip = skip
    options.start = start
    options.end = end
    options
  }

}
