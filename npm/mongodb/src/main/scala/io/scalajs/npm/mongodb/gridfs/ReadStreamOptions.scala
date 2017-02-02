package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Read Stream Options
  * @param sort  Optional sort for the file find query.
  * @param skip  Optional skip for the file find query.
  * @param start Optional 0-based offset in bytes to start streaming from.
  * @param end   Optional 0-based offset in bytes to stop streaming before.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ReadStreamOptions(var sort: js.UndefOr[Integer] = js.undefined,
                        var skip: js.UndefOr[Integer] = js.undefined,
                        var start: js.UndefOr[Integer] = js.undefined,
                        var end: js.UndefOr[Integer] = js.undefined)
    extends js.Object
