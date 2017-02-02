package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Find Options
  * @param batchSize       Optional: batch size for cursor
  * @param limit           Optional: limit for cursor
  * @param maxTimeMS       Optional: maximum time (milliseconds) for cursor
  * @param noCursorTimeout Optional: set cursor's noCursorTimeout flag
  * @param skip            Optional: skip for cursor
  * @param sort            Optional: sort for cursor
  */
@ScalaJSDefined
class GridFSBucketFindOptions(var batchSize: js.UndefOr[Int] = js.undefined,
                              var limit: js.UndefOr[Int] = js.undefined,
                              var maxTimeMS: js.UndefOr[Int] = js.undefined,
                              var noCursorTimeout: js.UndefOr[Boolean] = js.undefined,
                              var skip: js.UndefOr[Int] = js.undefined,
                              var sort: js.UndefOr[js.Object] = js.undefined)
    extends js.Object
