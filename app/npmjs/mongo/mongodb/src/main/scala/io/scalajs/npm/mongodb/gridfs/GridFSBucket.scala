package io.scalajs.npm.mongodb
package gridfs

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * GridFS Bucket
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "GridFSBucket")
class GridFSBucket() extends js.Object {

  /**
    * Constructor for a streaming GridFS interface
    * @param db      the [[Db]]
    * @param options the [[GridFSOptions options]]
    * @return a new [[GridFSBucket]]
    */
  def this(db: Db, options: GridFSOptions | RawOptions = js.native) = this()

  /**
    * Deletes a file with the given id
    * @param id       the id of the file doc
    * @param callback the optional callback function
    * @return a completion promise if no callback function was passed
    * @example delete(id[, callback])
    */
  def delete(id: ObjectID, callback: MongoCallback0 = js.native): js.Promise[Unit] = js.native

  /**
    * Removes this bucket's files collection, followed by its chunks collection.
    * @param callback the optional callback function
    * @return a completion promise if no callback function was passed
    * @example drop(callback)
    */
  def drop(callback: MongoCallback0 = js.native): js.Promise[Unit] = js.native

  /**
    * Convenience wrapper around find on the files collection
    * @example find(filter, options)
    */
  def find[T](filter: js.Any, options: GridFSBucketFindOptions | RawOptions = js.native): Cursor[T] = js.native

  /**
    * Returns a readable stream (GridFSBucketReadStream) for streaming file data from GridFS.
    * @param id      the id of the file document
    * @param options the [[DownloadStreamOptions download options]]
    * @example openDownloadStream(id, options)
    */
  def openDownloadStream(id: ObjectID | String | Int,
                         options: DownloadStreamOptions | RawOptions = js.native): GridFSBucketReadStream = js.native

  /**
    * Returns a readable stream (GridFSBucketReadStream) for streaming the file with the given name from GridFS.
    * If there are multiple files with the same name, this will stream the most recent file with the given name
    * (as determined by the uploadDate field). You can set the revision option to change this behavior.
    * @param filename the name of the file to download
    * @param options  the [[DownloadStreamByNameOptions download options]]
    * @example bucket.openDownloadStreamByName('meistersinger.mp3')
    */
  def openDownloadStreamByName(filename: String,
                               options: DownloadStreamByNameOptions | RawOptions = js.native): GridFSBucketReadStream = js.native

  /**
    * Returns a writable stream (GridFSBucketWriteStream) for writing buffers to GridFS. The stream's 'id' property
    * contains the resulting file's id.
    * @param filename the name of the file to download
    * @param options  the [[UploadStreamOptions upload options]]
    * @return a [[GridFSBucketWriteStream]]
    * @example bucket.openUploadStream('./meistersinger.mp3')
    */
  def openUploadStream(filename: String,
                       options: UploadStreamOptions | RawOptions = js.native): GridFSBucketWriteStream = js.native

  /**
    * Returns a writable stream (GridFSBucketWriteStream) for writing buffers to GridFS for a custom file id.
    * The stream's 'id' property contains the resulting file's id.
    * @param id       A custom id used to identify the file
    * @param filename The value of the 'filename' key in the files doc
    * @param options  Optional settings.
    * @return a [[GridFSBucketWriteStream]]
    */
  def openUploadStreamWithId(id: ObjectID | String | Int,
                             filename: String,
                             options: UploadStreamOptions | RawOptions = js.native): GridFSBucketWriteStream = js.native

}

/**
  * GridFS Bucket Download Stream Options
  * @param start Optional 0-based offset in bytes to start streaming from
  * @param end   Optional 0-based offset in bytes to stop streaming before
  * @author lawrence.daniels@gmail.com
  */

class DownloadStreamOptions(var start: js.UndefOr[Int] = js.undefined,
                            var end: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * GridFS Bucket Download Stream (By Name) Options
  * @param revision The revision number relative to the oldest file with the given filename. 0 gets you the oldest file,
  *                 1 gets you the 2nd oldest, -1 gets you the newest.
  * @param start    Optional 0-based offset in bytes to start streaming from
  * @param end      Optional 0-based offset in bytes to stop streaming before
  * @author lawrence.daniels@gmail.com
  */

class DownloadStreamByNameOptions(var revision: js.UndefOr[Int] = js.undefined,
                                  var start: js.UndefOr[Int] = js.undefined,
                                  var end: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * GridFS Bucket Find Options
  * @param batchSize       Optional: batch size for cursor
  * @param limit           Optional: limit for cursor
  * @param maxTimeMS       Optional: maximum time (milliseconds) for cursor
  * @param noCursorTimeout Optional: set cursor's noCursorTimeout flag
  * @param skip            Optional: skip for cursor
  * @param sort            Optional: sort for cursor
  */

class GridFSBucketFindOptions(var batchSize: js.UndefOr[Int] = js.undefined,
                              var limit: js.UndefOr[Int] = js.undefined,
                              var maxTimeMS: js.UndefOr[Int] = js.undefined,
                              var noCursorTimeout: js.UndefOr[Boolean] = js.undefined,
                              var skip: js.UndefOr[Int] = js.undefined,
                              var sort: js.UndefOr[js.Object] = js.undefined) extends js.Object

/**
  * GridFS Bucket Options
  * @author lawrence.daniels@gmail.com
  */

class GridFSOptions(var bucketName: js.UndefOr[String] = js.undefined,
                    var chunkSizeBytes: js.UndefOr[Int] = js.undefined,
                    var readPreference: js.UndefOr[js.Any] = js.undefined,
                    var writeConcern: js.UndefOr[js.Any] = js.undefined) extends js.Object

/**
  * GridFS Bucket Upload Stream Options
  * @param chunkSizeBytes Optional: overwrite this bucket's chunkSizeBytes for this file
  * @param metadata       Optional: object to store in the file document's metadata field
  * @param contentType    Optional: string to store in the file document's contentType field
  * @param aliases        Optional: array of strings to store in the file document's aliases field
  */

class UploadStreamOptions(var chunkSizeBytes: js.UndefOr[Int] = js.undefined,
                          var metadata: js.UndefOr[js.Any] = js.undefined,
                          var contentType: js.UndefOr[String] = js.undefined,
                          var aliases: js.UndefOr[js.Array[js.Any]] = js.undefined) extends js.Object