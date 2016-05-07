package com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * GridFS Bucket Find Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridFSBucketFindOptions extends js.Object {
  // Optional batch size for cursor
  var batchSize: js.UndefOr[Int] = _

  // Optional limit for cursor
  var limit: js.UndefOr[Int] = _

  // Optional maxTimeMS for cursor
  var maxTimeMS: js.UndefOr[Int] = _

  // Optionally set cursor's noCursorTimeout flag
  var noCursorTimeout: js.UndefOr[Boolean] = _

  // Optional skip for cursor
  var skip: js.UndefOr[Int] = _

  // Optional sort for cursor
  var sort: js.UndefOr[js.Object] = _

}

/**
  * GridFS Bucket Find Options Companion
  * @author lawrence.daniels@gmail.com
  */
object GridFSBucketFindOptions {

  def apply(batchSize: js.UndefOr[Int] = js.undefined,
            limit: js.UndefOr[Int] = js.undefined,
            maxTimeMS: js.UndefOr[Int] = js.undefined,
            noCursorTimeout: js.UndefOr[Boolean] = js.undefined,
            skip: js.UndefOr[Int] = js.undefined,
            sort: js.UndefOr[js.Object] = js.undefined) = {
    val options = new GridFSBucketFindOptions()
    options.batchSize = batchSize
    options.limit = limit
    options.maxTimeMS = maxTimeMS
    options.noCursorTimeout = noCursorTimeout
    options.skip = skip
    options.sort = sort
    options
  }

}