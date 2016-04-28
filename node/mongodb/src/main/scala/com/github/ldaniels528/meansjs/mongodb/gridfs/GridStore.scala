package com.github.ldaniels528.meansjs.mongodb.gridfs

import com.github.ldaniels528.meansjs.mongodb._
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Grid Store
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GridStore extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constructor Fields
  /////////////////////////////////////////////////////////////////////////////////

  /** A database instance to interact with. */
  var db: js.UndefOr[MongoDB] = js.native

  /** optional unique id for this file */
  var id: js.UndefOr[js.Any] = js.native

  /** optional filename for this file, no unique constrain on the field */
  var filename: js.UndefOr[String] = js.native

  /** set the mode for this file. */
  var mode: js.UndefOr[String] = js.native

  /** optional properties to specify. */
  var options: js.UndefOr[GridStoreOptions] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the current chunk size of the file.
    */
  var chunkSize: Number = js.native

  /**
    * The md5 checksum for this file.
    */
  var md5: Number = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Retrieve this file’s chunks collection.
    */
  def chunkCollection(callback: js.Function): Unit = js.native

  /**
    * Saves this file to the database. This will overwrite the old entry if it already exists. This will work
    * properly only if mode was initialized to “w” or “w+”.
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Retrieves the file collection associated with this object.
    */
  def collection(callback: js.Function): Unit = js.native

  /**
    * Verify if the file is at EOF.
    */
  def eof(): Boolean = js.native

  /**
    * Retrieves a single character from this file.
    */
  def getc(callback: js.Function): Unit = js.native

  /**
    * Opens the file from the database and initialize this object. Also creates a new one if file does not exist.
    */
  def open(callback: js.Function): Unit = js.native

  /**
    * Writes a string to the file with a newline character appended at the end if the given string does not have one.
    * @example puts(string, callback)
    */
  def puts(string: String, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(length: Int, buffer: Buffer, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(buffer: Buffer, callback: js.Function): Unit = js.native

  /**
    * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
    * @example read([length][, buffer], callback)
    */
  def read(callback: js.Function): Unit = js.native

  /**
    * Reads the data of this file.
    * @example readlines([separator], callback)
    */
  def readlines(separator: String, callback: js.Function): Unit = js.native

  /**
    * Reads the data of this file.
    * @example readlines([separator], callback)
    */
  def readlines(callback: js.Function): Unit = js.native

  /**
    * Deletes all the chunks of this file in the database if mode was set to “w” or “w+” and resets the read/write
    * head to the initial position.
    */
  def rewind(callback: js.Function): Unit = js.native

  /**
    * Retrieves the position of the read/write head of this file.
    */
  def tell(callback: js.Function): Unit = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(position: Int, seekLocation: Int, callback: js.Function): Unit = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(seekLocation: Int, callback: js.Function): Unit = js.native

  /**
    * Moves the read/write head to a new location.
    * Seek Location Modes:
    * <ul>
    * <li>GridStore.IO_SEEK_SET, (default) set the position from the start of the file.</li>
    * <li>GridStore.IO_SEEK_CUR, set the position from the current position in the file.</li>
    * <li>GridStore.IO_SEEK_END, set the position from the end of the file.</li>
    * </ul>
    * @example seek([position][, seekLocation], callback)
    */
  def seek(callback: js.Function): Unit = js.native

  /**
    * Returns read stream based on this GridStore file.
    * <p/>Events
    * <ul>
    * <li>data {function(item) {}} the data event triggers when a document is ready.</li>
    * <li>end {function() {}} the end event triggers when there is no more documents available.</li>
    * <li>close {function() {}} the close event triggers when the stream is closed.</li>
    * <li>error {function(err) {}} the error event triggers if an error happens.</li>
    * </ul>
    * @param autoclose if true current GridStore will be closed when EOF and ‘close’ event will be fired
    */
  def stream(autoclose: Boolean): Unit = js.native

  /**
    * Deletes all the chunks of this file in the database.
    */
  def unlink(callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: Buffer, close: Boolean, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: String, close: Boolean, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: Buffer, callback: js.Function): Unit = js.native

  /**
    * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
    * @example write(data[, close], callback)
    */
  def write(data: String, callback: js.Function): Unit = js.native

  /**
    * Stores a file from the file system to the GridFS database.
    */
  def writeFile(file: String, callback: js.Function): Unit = js.native

}

/**
  * Grid Store Companion
  * @author lawrence.daniels@gmail.com
  */
object GridStore {

  /**
    * Grid Store Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridStoreExtensions(val gridStore: GridStore) extends AnyVal {

    /**
      * Retrieve this file’s chunks collection.
      */
    @inline
    def chunkCollectionAsync() = callbackWithErrorToFuture[Collection](gridStore.chunkCollection)

    /**
      * Saves this file to the database. This will overwrite the old entry if it already exists. This will work
      * properly only if mode was initialized to “w” or “w+”.
      */
    @inline
    def closeAsync() = callbackWithErrorToFuture[js.Any](gridStore.close)

    /**
      * Retrieves the file collection associated with this object.
      */
    @inline
    def collectionAsync() = callbackWithErrorToFuture[js.Any](gridStore.collection)

    /**
      * Retrieves a single character from this file.
      */
    @inline
    def getcAsync() = callbackWithErrorToFuture[String](gridStore.getc)

    /**
      * The close event triggers when the stream is closed.
      */
    @inline
    def onClose(callback: js.Function0[Unit]) = gridStore.on("close", callback)

    /**
      * The data event triggers when a document is ready.
      */
    @inline
    def onData[T <: js.Any](callback: js.Function1[T, Unit]) = gridStore.on("data", callback)

    /**
      * The end event triggers when there is no more documents available.
      */
    @inline
    def onEnd(callback: js.Function0[Unit]) = gridStore.on("end", callback)

    /**
      * The error event triggers if an error happens.
      */
    @inline
    def onError(callback: js.Function1[js.Object, Unit]) = gridStore.on("error", callback)

    /**
      * Opens the file from the database and initialize this object. Also creates a new one if file does not exist.
      */
    @inline
    def openAsync() = callbackWithErrorToFuture[Db](gridStore.open)

    /**
      * Writes a string to the file with a newline character appended at the end if the given string does not have one.
      */
    @inline
    def putsAsync(string: String) = callbackWithErrorToFuture[GridStore](gridStore.puts(string, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readAsync[T <: js.Any](length: Int, buffer: Buffer) = callbackWithErrorToFuture[js.Array[T]](gridStore.read(length, buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readAsync[T <: js.Any](buffer: Buffer) = callbackWithErrorToFuture[js.Array[T]](gridStore.read(buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readAsync[T <: js.Any]() = callbackWithErrorToFuture[js.Array[T]](gridStore.read)

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesAsync(separator: String) = callbackWithErrorToFuture[js.Array[String]](gridStore.readlines(separator, _))

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesAsync = callbackWithErrorToFuture[js.Array[String]](gridStore.readlines)

    /**
      * Deletes all the chunks of this file in the database if mode was set to “w” or “w+” and resets the read/write
      * head to the initial position.
      */
    @inline
    def rewindAsync() = callbackWithErrorToFuture[js.Any](gridStore.rewind)

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekAsync(position: Int, seekLocation: Int) = callbackWithErrorToFuture[GridStore](gridStore.seek(position, seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekAsync(seekLocation: Int) = callbackWithErrorToFuture[GridStore](gridStore.seek(seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekAsync() = callbackWithErrorToFuture[GridStore](gridStore.seek)

    /**
      * Retrieves the position of the read/write head of this file.
      */
    @inline
    def tellAsync() = callbackWithErrorToFuture[Int](gridStore.tell)

    /**
      * Deletes all the chunks of this file in the database.
      */
    @inline
    def unlinkAsync() = callbackWithErrorToFuture[Boolean](gridStore.unlink)

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeAsync(data: Buffer, close: Boolean) = callbackWithErrorToFuture[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeAsync(data: String, close: Boolean) = callbackWithErrorToFuture[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeAsync(data: Buffer) = callbackWithErrorToFuture[GridStore](gridStore.write(data, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeAsync(data: String) = callbackWithErrorToFuture[GridStore](gridStore.write(data, _))

    /**
      * Stores a file from the file system to the GridFS database.
      */
    @inline
    def writeFileAsync(file: String) = callbackWithErrorToFuture[GridStore](gridStore.writeFile(file, _))

  }

}