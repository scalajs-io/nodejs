package io.scalajs.npm.mongodb.gridfs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Grid Store Options
  * @param root           root collection to use. Defaults to GridStore.DEFAULT_ROOT_COLLECTION.
  * @param content_type   mime type of the file. Defaults to GridStore.DEFAULT_CONTENT_TYPE.
  * @param chunk_size     size for the chunk. Defaults to Chunk.DEFAULT_CHUNK_SIZE.
  * @param metadata       arbitrary data the user wants to store.
  * @param readPreference the prefered read preference (ReadPreference.PRIMARY, ReadPreference.PRIMARY_PREFERRED,
  *                       ReadPreference.SECONDARY, ReadPreference.SECONDARY_PREFERRED, ReadPreference.NEAREST).
  * @param w              {Int/String, > -1 || ‘majority’ || tag name} the write concern for the operation where < 1 is
  *                       no acknowlegement of write and w >= 1, w = ‘majority’ or tag acknowledges the write
  * @param wtimeout       set the timeout for waiting for write concern to finish (combines with w option)
  * @param fsync          write waits for fsync before returning, from MongoDB 2.6 on, fsync cannot be combined with
  *                       journal (default: false)
  * @param j              write waits for journal sync before returning (default: false)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class GridStoreOptions(var root: js.UndefOr[String] = js.undefined,
                       var content_type: js.UndefOr[String] = js.undefined,
                       var chunk_size: js.UndefOr[Int] = js.undefined,
                       var metadata: js.UndefOr[js.Object] = js.undefined,
                       var readPreference: js.UndefOr[String] = js.undefined,
                       var w: js.UndefOr[js.Any] = js.undefined,
                       var wtimeout: js.UndefOr[Int] = js.undefined,
                       var fsync: js.UndefOr[Boolean] = js.undefined,
                       var j: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
