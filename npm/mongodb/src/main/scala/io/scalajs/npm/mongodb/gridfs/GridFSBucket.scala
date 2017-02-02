package io.scalajs.npm.mongodb.gridfs

import io.scalajs.npm.mongodb.{Cursor, Db}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * GridFS Bucket
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "GridFSBucket")
class GridFSBucket() extends js.Object {

  def this(db: Db) = this()

  def this(db: Db, options: GridFSOptions) = this()

  /**
    * Deletes a file with the given id
    * @param id the id of the file doc
    * @example delete(id, callback)
    */
  def delete(id: js.Any, callback: js.Function): Unit = js.native

  /**
    * Deletes a file with the given id
    * @param id the id of the file doc
    * @example delete(id, callback)
    */
  def delete(id: js.Any): Unit = js.native

  /**
    * Removes this bucket's files collection, followed by its chunks collection.
    * @example drop(callback)
    */
  def drop(callback: js.Function): Unit = js.native

  /**
    * Removes this bucket's files collection, followed by its chunks collection.
    * @example drop(callback)
    */
  def drop(): Unit = js.native

  /**
    * Convenience wrapper around find on the files collection
    * @example find(filter, options)
    */
  def find(filter: js.Any, options: GridFSBucketFindOptions = null): Cursor = js.native

  /**
    * Returns a readable stream (GridFSBucketReadStream) for streaming file data from GridFS.
    * @param id      the id of the file document
    * @param options the [[DownloadStreamOptions download options]]
    * @example openDownloadStream(id, options)
    */
  def openDownloadStream(id: js.Any, options: DownloadStreamOptions = null): GridFSBucketReadStream = js.native

  /**
    * Returns a readable stream (GridFSBucketReadStream) for streaming the file with the given name from GridFS.
    * If there are multiple files with the same name, this will stream the most recent file with the given name
    * (as determined by the uploadDate field). You can set the revision option to change this behavior.
    * @param file    the name of the file to download
    * @param options the [[DownloadStreamByNameOptions download options]]
    * @example bucket.openDownloadStreamByName('meistersinger.mp3')
    */
  def openDownloadStreamByName(file: String, options: DownloadStreamByNameOptions = null): GridFSBucketReadStream =
    js.native

  /**
    * Returns a writable stream (GridFSBucketWriteStream) for writing buffers to GridFS. The stream's 'id' property
    * contains the resulting file's id.
    * @param file    the name of the file to download
    * @param options the [[UploadStreamOptions upload options]]
    * @example bucket.openUploadStream('./meistersinger.mp3')
    */
  def openUploadStream(file: String, options: UploadStreamOptions = null): GridFSBucketWriteStream = js.native

}
