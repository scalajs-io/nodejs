package com.github.ldaniels528.meansjs.mongodb.gridfs

import com.github.ldaniels528.meansjs.mongodb._
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

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
  def read(db: Db, name: String, length: Int, offset: Int, options: GridStoreOptions, callback: js.Function): Unit = js.native

  /**
    * Reads the data of this file.
    * @example GridStore.readlines(db, name[, separator][, options], callback)
    */
  def readlines(db: Db, name: String, separator: String, options: GridStoreOptions, callback: js.Function): Unit = js.native

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
      * Constructor method
      */
    @inline
    def apply(db: Db, filename: String, mode: String) = `class`.New[GridStore](db, filename, mode)

    /**
      * Constructor method
      */
    @inline
    def apply(db: Db, filename: String, mode: String, options: GridStoreOptions) = `class`.New[GridStore](db, filename, mode, options)

    /**
      * Constructor method
      */
    @inline
    def apply(db: Db, id: js.Any, mode: String) = `class`.New[GridStore](db, id, mode)

    /**
      * Constructor method
      */
    @inline
    def apply(db: Db, id: js.Any, filename: String, mode: String) = `class`.New[GridStore](db, id, filename, mode)

    /**
      * Constructor method
      */
    @inline
    def apply(db: Db, id: js.Any, filename: String, mode: String, options: GridStoreOptions) = {
      `class`.New[GridStore](db, id, filename, mode, options)
    }

    /**
      * Checks if a file exists in the database.
      */
    @inline
    def existAsync(db: Db, name: String, rootCollection: String) = callbackMongoFuture[GridStore](`class`.exist(db, name, rootCollection, _))

    /**
      * Checks if a file exists in the database.
      */
    @inline
    def existAsync(db: Db, name: String) = callbackMongoFuture[GridStore](`class`.exist(db, name, _))

    /**
      * Gets the list of files stored in the GridFS.
      */
    @inline
    def listAsync(db: Db, rootCollection: String) = callbackMongoFuture[js.Array[String]](`class`.list(db, rootCollection, _))

    /**
      * Gets the list of files stored in the GridFS.
      */
    @inline
    def listAsync(db: Db) = callbackMongoFuture[js.Array[String]](`class`.list(db, _))

    /**
      * Reads the contents of a file.
      */
    @inline
    def readAsync[T <: js.Any](db: Db, name: String) = callbackMongoFuture[js.Array[T]](`class`.read(db, name, _))

    /**
      * Reads the contents of a file.
      */
    @inline
    def readAsync[T <: js.Any](db: Db, name: String, length: Int) = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, _))
    }

    /**
      * Reads the contents of a file.
      */
    @inline
    def readAsync[T <: js.Any](db: Db, name: String, length: Int, offset: Int) = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, offset, _))
    }

    /**
      * Reads the contents of a file.
      */
    @inline
    def readAsync[T <: js.Any](db: Db, name: String, length: Int, offset: Int, options: GridStoreOptions) = {
      callbackMongoFuture[js.Array[T]](`class`.read(db, name, length, offset, options, _))
    }

    /**
      * Reads the data of this file.
      */
    @inline
    def readlinesAsync(db: Db, name: String, separator: String, options: GridStoreOptions) = {
      callbackMongoFuture[js.Array[String]](`class`.readlines(db, name, separator, options, _))
    }

  }

}
