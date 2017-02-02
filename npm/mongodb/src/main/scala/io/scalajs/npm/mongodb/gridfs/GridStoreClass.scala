package io.scalajs.npm.mongodb.gridfs

import io.scalajs.npm.mongodb.{Db, _}

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * Grid Store Class
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/gridstore.html }}}
  */
@js.native
trait GridStoreClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Default file mime type
    */
  val DEFAULT_CONTENT_TYPE: String = js.native

  /**
    * TODO document this property
    */
  val DEFAULT_CHUNK_SIZE: Int = js.native

  /**
    * The collection to be used for holding the files and chunks collection.
    */
  val DEFAULT_ROOT_COLLECTION: String = js.native

  /**
    * Seek mode where the given length is an offset to the current read/write head.
    */
  val IO_SEEK_CUR: Int = js.native

  /**
    * Seek mode where the given length is an offset to the end of the file.
    */
  val IO_SEEK_END: Int = js.native

  /**
    * Seek mode where the given length is absolute.
    */
  val IO_SEEK_SET: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Static Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Checks if a file exists in the database.
    * @example GridStore.exist(db, name[, rootCollection], callback)
    */
  def exist(db: Db, name: String, rootCollection: String, callback: js.Function): Unit = js.native

  /**
    * Checks if a file exists in the database.
    * @example GridStore.exist(db, name[, rootCollection], callback)
    */
  def exist(db: Db, name: String, callback: js.Function): Unit = js.native

  /**
    * Gets the list of files stored in the GridFS.
    * @example GridStore.list(db[, rootCollection], callback)
    */
  def list(db: Db, rootCollection: String, callback: js.Function): Unit = js.native

  /**
    * Gets the list of files stored in the GridFS.
    * @example GridStore.list(db[, rootCollection], callback)
    */
  def list(db: Db, callback: js.Function): Unit = js.native

  /**
    * Reads the contents of a file.
    * @example GridStore.read(db, name[, length][, offset][, options], callback)
    */
  def read(db: Db, name: String, callback: js.Function): Unit = js.native

  /**
    * Reads the contents of a file.
    * @example GridStore.read(db, name[, length][, offset][, options], callback)
    */
  def read(db: Db, name: String, length: Int, callback: js.Function): Unit = js.native

  /**
    * Reads the contents of a file.
    * @example GridStore.read(db, name[, length][, offset][, options], callback)
    */
  def read(db: Db, name: String, length: Int, offset: Int, callback: js.Function): Unit = js.native

  /**
    * Reads the contents of a file.
    * @example GridStore.read(db, name[, length][, offset][, options], callback)
    */
  def read(db: Db, name: String, length: Int, offset: Int, options: GridStoreOptions, callback: js.Function): Unit =
    js.native

  /**
    * Reads the data of this file.
    * @example GridStore.readlines(db, name[, separator][, options], callback)
    */
  def readlines(db: Db, name: String, separator: String, options: GridStoreOptions, callback: js.Function): Unit =
    js.native

  /**
    * Deletes the chunks and metadata information of a file from GridFS.
    * @example GridStore.unlink(db, names[, options])
    */
  def unlink(db: Db, names: String, options: GridStoreOptions): Unit = js.native

  /**
    * Deletes the chunks and metadata information of a file from GridFS.
    * @example GridStore.unlink(db, names[, options])
    */
  def unlink(db: Db, names: String): Unit = js.native

}

/**
  * Grid Store Class Companion
  * @author lawrence.daniels@gmail.com
  */
object GridStoreClass {

  /**
    * Grid Store Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridStoreClassExtensions(val `class`: GridStoreClass) extends AnyVal {

    /**
      * Checks if a file exists in the database.
      */
    @inline
    def existFuture(db: Db, name: String, rootCollection: String): Future[GridStore] = {
      callbackMongoFuture[GridStore](`class`.exist(db, name, rootCollection, _))
    }

    /**
      * Checks if a file exists in the database.
      */
    @inline
    def existFuture(db: Db, name: String): Future[GridStore] =
      callbackMongoFuture[GridStore](`class`.exist(db, name, _))

    /**
      * Gets the list of files stored in the GridFS.
      */
    @inline
    def listFuture(db: Db, rootCollection: String): Future[Array[String]] = {
      callbackMongoFuture[js.Array[String]](`class`.list(db, rootCollection, _))
    }

    /**
      * Gets the list of files stored in the GridFS.
      */
    @inline
    def listFuture(db: Db): Future[Array[String]] = callbackMongoFuture[js.Array[String]](`class`.list(db, _))

    /**
      * Reads the contents of a file.
      */
    @inline
    def readFuture[T <: js.Any](db: Db, name: String): Future[Array[T]] =
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, _))

    /**
      * Reads the contents of a file.
      */
    @inline
    def readFuture[T <: js.Any](db: Db, name: String, length: Int): Future[Array[T]] = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, _))
    }

    /**
      * Reads the contents of a file.
      */
    @inline
    def readFuture[T <: js.Any](db: Db, name: String, length: Int, offset: Int): Future[Array[T]] = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, offset, _))
    }

    /**
      * Reads the contents of a file.
      */
    @inline
    def readFuture[T <: js.Any](db: Db,
                                name: String,
                                length: Int,
                                offset: Int,
                                options: GridStoreOptions): Future[Array[T]] = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, offset, options, _))
    }

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesFuture(db: Db, name: String, separator: String, options: GridStoreOptions): Future[Array[String]] = {
      callbackMongoFuture[js.Array[String]](`class`.readlines(db, name, separator, options, _))
    }

  }

}
