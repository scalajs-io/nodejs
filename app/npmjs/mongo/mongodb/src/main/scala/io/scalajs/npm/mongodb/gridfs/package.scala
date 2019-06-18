package io.scalajs.npm.mongodb

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * mongodb/gridfs package object
  * @author lawrence.daniels@gmail.com
  */
package object gridfs {

  /**
    * GridFS Bucket Read Stream Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridFSBucketReadStreamExtensions(val stream: GridFSBucketReadStream) extends AnyVal {

    /**
      * Fires when the stream loaded the file document corresponding to the provided id.
      */
    @inline
    def onFile(callback: js.Function): stream.type = stream.on("file", callback)

  }

  /**
    * Grid Store Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridStoreExtensions(val gridStore: GridStore) extends AnyVal {

    /**
      * Retrieve this file’s chunks collection.
      */
    @inline
    def chunkCollectionFuture(): js.Promise[Collection] = promiseMongoCallback1[Collection](gridStore.chunkCollection)

    /**
      * Saves this file to the database. This will overwrite the old entry if it already exists. This will work
      * properly only if mode was initialized to “w” or “w+”.
      */
    @inline
    def closeFuture(): js.Promise[js.Any] = promiseMongoCallback1[js.Any](gridStore.close)

    /**
      * Retrieves the file collection associated with this object.
      */
    @inline
    def collectionFuture(): js.Promise[js.Any] = promiseMongoCallback1[js.Any](gridStore.collection)

    /**
      * Retrieves a single character from this file.
      */
    @inline
    def getcFuture(): js.Promise[String] = promiseMongoCallback1[String](gridStore.getc)

    /**
      * Opens the file from the database and initialize this object. Also creates a new one if file does not exist.
      */
    @inline
    def openFuture(): js.Promise[Db] = promiseMongoCallback1[Db](gridStore.open)

    /**
      * Writes a string to the file with a newline character appended at the end if the given string does not have one.
      */
    @inline
    def putsFuture(string: String): js.Promise[GridStore] = promiseMongoCallback1[GridStore](gridStore.puts(string, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any](length: Int, buffer: Buffer): js.Promise[Array[T]] =
    promiseMongoCallback1[js.Array[T]](gridStore.read(length, buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any](buffer: Buffer): js.Promise[Array[T]] =
    promiseMongoCallback1[js.Array[T]](gridStore.read(buffer, _))

    /**
      * Retrieves the contents of this file and advances the read/write head. Works with Buffers only.
      */
    @inline
    def readFuture[T <: js.Any](): js.Promise[Array[T]] = promiseMongoCallback1[js.Array[T]](gridStore.read)

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesFuture(separator: String): js.Promise[Array[String]] =
    promiseMongoCallback1[js.Array[String]](gridStore.readlines(separator, _))

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesFuture: js.Promise[Array[String]] = promiseMongoCallback1[js.Array[String]](gridStore.readlines)

    /**
      * Deletes all the chunks of this file in the database if mode was set to “w” or “w+” and resets the read/write
      * head to the initial position.
      */
    @inline
    def rewindFuture(): js.Promise[js.Any] = promiseMongoCallback1[js.Any](gridStore.rewind)

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture(position: Int, seekLocation: Int): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.seek(position, seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture(seekLocation: Int): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.seek(seekLocation, _))

    /**
      * Moves the read/write head to a new location.
      */
    @inline
    def seekFuture(): js.Promise[GridStore] = promiseMongoCallback1[GridStore](gridStore.seek)

    /**
      * Deletes all the chunks of this file in the database.
      */
    @inline
    def unlinkFuture(): js.Promise[Boolean] = promiseMongoCallback1[Boolean](gridStore.unlink)

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: Buffer, close: Boolean): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: String, close: Boolean): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.write(data, close, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: Buffer): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.write(data, _))

    /**
      * Writes some data. This method will work properly only if initialized with mode “w” or “w+”.
      */
    @inline
    def writeFuture(data: String): js.Promise[GridStore] =
    promiseMongoCallback1[GridStore](gridStore.write(data, _))

    /**
      * Stores a file from the file system to the GridFS database.
      */
    @inline
    def writeFileFuture(file: String): js.Promise[GridStore] = {
      promiseMongoCallback1[GridStore](gridStore.writeFile(file, _))
    }

  }

}
