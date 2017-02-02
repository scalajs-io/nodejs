package io.scalajs.npm.mongodb.gridfs

import io.scalajs.npm.mongodb.Chunk
import io.scalajs.npm.mongodb.Chunk

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Grid Options
  * @param _id          unique id for this file.
  * @param root         root collection to use. Defaults to [[GridStoreClass.DEFAULT_ROOT_COLLECTION DEFAULT_ROOT_COLLECTION]].
  * @param content_type mime type of the file. Defaults to [[GridStoreClass.DEFAULT_CONTENT_TYPE DEFAULT_CONTENT_TYPE]].
  * @param chunk_size   size for the chunk. Defaults to [[Chunk.DEFAULT_CHUNK_SIZE]].
  * @param metadata     arbitrary data the user wants to store.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridOptions(var _id: js.Any = js.undefined,
                  var root: js.UndefOr[String] = js.undefined,
                  var content_type: js.UndefOr[String] = js.undefined,
                  var chunk_size: js.UndefOr[Int] = js.undefined,
                  var metadata: js.UndefOr[js.Object] = js.undefined)
    extends js.Object
