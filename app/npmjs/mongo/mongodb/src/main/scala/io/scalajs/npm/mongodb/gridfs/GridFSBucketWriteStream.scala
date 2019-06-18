package io.scalajs.npm.mongodb
package gridfs

import io.scalajs.RawOptions
import io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * A writable stream that enables you to write buffers to GridFS.
  * Do not instantiate this class directly. Use openUploadStream() instead.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "GridFSBucketWriteStream")
class GridFSBucketWriteStream(bucket: GridFSBucket, filename: String, options: WriteStreamOptions | RawOptions = js.native)
  extends stream.Writable {

  /**
    * Places this write stream into an aborted state (all future writes fail)
    * and deletes all chunks that have already been written.
    * @param callback called when chunks are successfully removed or error occurred
    * @return a completion promise if the callback was not passed
    */
  def abort(callback: MongoCallback0): js.Promise[Unit] = js.native

}

/**
  * Write Stream Options
  * @param id             string | number | object	null	optional Custom file id for the GridFS file.
  * @param chunkSizeBytes number	null	optional The chunk size to use, in bytes
  * @param w              number	null	optional The write concern
  * @param wtimeout       number	null	optional The write concern timeout
  * @param j              number	null	optional The journal write concern
  */

class WriteStreamOptions(val id: js.UndefOr[ObjectID | String | Int] = js.undefined,
                         val chunkSizeBytes: js.UndefOr[Int] = js.undefined,
                         val w: js.UndefOr[Int] = js.undefined,
                         val wtimeout: js.UndefOr[Int] = js.undefined,
                         val j: js.UndefOr[Int] = js.undefined) extends js.Object