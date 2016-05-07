package com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Grid Store Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridStoreOptions extends js.Object {
  // root collection to use. Defaults to {GridStore.DEFAULT_ROOT_COLLECTION}.
  var root: js.UndefOr[String] = _

  // mime type of the file. Defaults to {GridStore.DEFAULT_CONTENT_TYPE}.
  var content_type: js.UndefOr[String] = _

  // size for the chunk. Defaults to {Chunk.DEFAULT_CHUNK_SIZE}.
  var chunk_size: js.UndefOr[Int] = _

  // arbitrary data the user wants to store.
  var metadata: js.UndefOr[js.Object] = _

  // the prefered read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED, ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  var readPreference: js.UndefOr[String] = _

  // {Int/String, > -1 || ‘majority’ || tag name} the write concern for the operation where < 1 is no acknowlegement of write and w >= 1, w = ‘majority’ or tag acknowledges the write
  var w: js.UndefOr[js.Any] = js.undefined

  // set the timeout for waiting for write concern to finish (combines with w option)
  var wtimeout: js.UndefOr[Int] = _

  // (default:false) write waits for fsync before returning, from MongoDB 2.6 on, fsync cannot be combined with journal
  var fsync: js.UndefOr[Boolean] = _

  // (default:false) write waits for journal sync before returning
  var j: js.UndefOr[Boolean] = _

}

/**
  * Grid Store Options
  * @author lawrence.daniels@gmail.com
  */
object GridStoreOptions {

  def apply(root: js.UndefOr[String] = js.undefined,
            content_type: js.UndefOr[String] = js.undefined,
            chunk_size: js.UndefOr[Int] = js.undefined,
            metadata: js.UndefOr[js.Object] = js.undefined,
            readPreference: js.UndefOr[String] = js.undefined,
            w: js.UndefOr[js.Any] = js.undefined,
            wtimeout: js.UndefOr[Int] = js.undefined,
            fsync: js.UndefOr[Boolean] = js.undefined,
            j: js.UndefOr[Boolean] = js.undefined) = {
    val options = new GridStoreOptions()
    options.root = root
    options.content_type = content_type
    options.chunk_size = chunk_size
    options.metadata = metadata
    options.readPreference = readPreference
    options.w = w
    options.wtimeout = wtimeout
    options.fsync = fsync
    options.j = j
    options
  }

}

