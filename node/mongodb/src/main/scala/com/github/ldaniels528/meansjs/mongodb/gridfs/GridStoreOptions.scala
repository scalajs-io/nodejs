package com.github.ldaniels528.meansjs.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Grid Store Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridStoreOptions extends js.Object {
  var root: js.UndefOr[String] = _
  // root collection to use. Defaults to {GridStore.DEFAULT_ROOT_COLLECTION}.
  var content_type: js.UndefOr[String] = _
  // mime type of the file. Defaults to {GridStore.DEFAULT_CONTENT_TYPE}.
  var chunk_size: js.UndefOr[Int] = _
  // size for the chunk. Defaults to {Chunk.DEFAULT_CHUNK_SIZE}.
  var metadata: js.UndefOr[js.Object] = _
  // arbitrary data the user wants to store.
  var readPreference: js.UndefOr[String] = _
  // the prefered read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED, ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  var w: js.Any = js.undefined
  // {Int/String, > -1 || ‘majority’ || tag name} the write concern for the operation where < 1 is no acknowlegement of write and w >= 1, w = ‘majority’ or tag acknowledges the write
  var wtimeout: js.UndefOr[Int] = _
  // 0} set the timeout for waiting for write concern to finish (combines with w option)
  var fsync: js.UndefOr[Boolean] = _
  // default:false) write waits for fsync before returning, from MongoDB 2.6 on, fsync cannot be combined with journal
  var j: js.UndefOr[Boolean] = _ // default:false) write waits for journal sync before returning

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
            w: js.Any = js.undefined,
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

