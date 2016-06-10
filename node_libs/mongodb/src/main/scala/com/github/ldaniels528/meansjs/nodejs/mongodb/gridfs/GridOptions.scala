package com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs

import com.github.ldaniels528.meansjs.nodejs.mongodb.Chunk

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Grid Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridOptions extends js.Object {
  /** unique id for this file */
  var _id: js.Any = _

  /** root collection to use. Defaults to [[GridStoreClass.DEFAULT_ROOT_COLLECTION DEFAULT_ROOT_COLLECTION]]. */
  var root: js.UndefOr[String] = _

  /** mime type of the file. Defaults to [[GridStoreClass.DEFAULT_CONTENT_TYPE DEFAULT_CONTENT_TYPE]]. */
  var content_type: js.UndefOr[String] = _

  /** size for the chunk. Defaults to [[Chunk.DEFAULT_CHUNK_SIZE]]. */
  var chunk_size: js.UndefOr[Int] = _

  /** arbitrary data the user wants to store. */
  var metadata: js.UndefOr[js.Object] = _

}

/**
  * Grid Options Companion
  * @author lawrence.daniels@gmail.com
  */
object GridOptions {

  def apply(_id: js.Any = js.undefined,
            root: js.UndefOr[String] = js.undefined,
            content_type: js.UndefOr[String] = js.undefined,
            chunk_size: js.UndefOr[Int] = js.undefined,
            metadata: js.UndefOr[js.Object] = js.undefined) = {
    val options = new GridOptions()
    options._id = _id
    options.root = root
    options.content_type = content_type
    options.chunk_size = chunk_size
    options.metadata = metadata
    options

  }

}
