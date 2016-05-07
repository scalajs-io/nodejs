package com.github.ldaniels528.meansjs.nodejs.mongodb.gridfs

import com.github.ldaniels528.meansjs.nodejs.mongodb._
import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * Grid Instance
  * @author lawrence.daniels@gmail.com
  * @see {{{ https://mongodb.github.io/node-mongodb-native/api-generated/grid.html }}}
  */
@js.native
trait Grid extends js.Object {

  /**
    * Delete file from grid
    * @param id       the _id for file.
    * @param callback this will be called after this method is executed. The first parameter will contain an Error
    *                 object if an error occurred or null otherwise. The second parameter will contain a reference
    *                 to this object.
    * @example delete(id, callback)
    */
  def delete(id: js.Any, callback: js.Function): Unit = js.native

  /**
    * Get binary data to the grid
    * @param id       the _id for file.
    * @param callback this will be called after this method is executed. The first parameter will contain an Error
    *                 object if an error occurred or null otherwise. The second parameter will contain a reference
    *                 to this object.
    * @example get(id, callback)
    */
  def get(id: js.Any, callback: js.Function): Unit = js.native

  /**
    * Puts binary data to the grid
    * @param data     buffer with Binary Data.
    * @param options  the options for the files.
    * @param callback this will be called after this method is executed. The first parameter will contain an Error
    *                 object if an error occurred or null otherwise. The second parameter will contain a reference
    *                 to this object.
    * @example put(data[, options], callback)
    */
  def put(data: Buffer, options: GridOptions, callback: js.Function): Unit = js.native

  /**
    * Puts binary data to the grid
    * @param data     buffer with Binary Data.
    * @param callback this will be called after this method is executed. The first parameter will contain an Error
    *                 object if an error occurred or null otherwise. The second parameter will contain a reference
    *                 to this object.
    * @example put(data[, options], callback)
    */
  def put(data: Buffer, callback: js.Function): Unit = js.native

}

/**
  * Grid Companion
  * @author lawrence.daniels@gmail.com
  */
object Grid extends {

  /**
    * Grid Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class GridExtensions(val grid: Grid) extends AnyVal {

    /**
      * Delete file from grid
      * @param id the _id for file.
      */
    def deleteAsync(id: js.Any) = callbackMongoFuture[Grid](grid.delete(id, _))

    /**
      * Get binary data to the grid
      * @param id the _id for file.
      */
    def getAsync(id: js.Any) = callbackMongoFuture[Buffer](grid.get(id, _))

    /**
      * Puts binary data to the grid
      * @param data    buffer with Binary Data.
      * @param options the options for the files.
      */
    def putAsync(data: Buffer, options: GridOptions) = callbackMongoFuture[Grid](grid.put(data, options, _))

    /**
      * Puts binary data to the grid
      * @param data buffer with Binary Data.
      */
    def putAsync(data: Buffer, callback: js.Function) = callbackMongoFuture[Grid](grid.put(data, _))

  }

}