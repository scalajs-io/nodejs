package io.scalajs.npm.mongodb

import io.scalajs.util.ScalaJsHelper._
import io.scalajs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cursor Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CursorClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Constants
  /////////////////////////////////////////////////////////////////////////////////

  val INIT: Int     = js.native
  val OPEN: Int     = js.native
  val CLOSED: Int   = js.native
  val GET_MORE: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Static Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clones a given cursor but uses new options
    * @example Cursor.cloneWithOptions(cursor)
    */
  def cloneWithOptions(cursor: Cursor): CursorOptions = js.native

}

/**
  * Cursor Class Companion
  * @author lawrence.daniels@gmail.com
  */
object CursorClass {

  /**
    * Cursor Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class CursorClassExtensions(val `class`: CursorClass) extends AnyVal {

    /**
      * Constructor for a cursor object that handles all the operations on query result using find. This cursor object
      * is unidirectional and cannot traverse backwards. Clients should not be creating a cursor directly, but use find
      * to acquire a cursor. (INTERNAL TYPE)
      * @param db         the [[Db database object]] to work with.
      * @param collection the [[Collection collection]] to query.
      * @param selector   the [[js.Object query selector]].
      * @param fields     an [[js.Object object]] containing what fields to include or exclude from objects returned.
      * @param options    additional [[CursorOptions options]] for the collection.
      */
    @inline
    def apply(db: Db,
              collection: Collection,
              selector: js.Object,
              fields: js.Object,
              options: js.UndefOr[CursorOptions] = js.undefined) = {
      `class`.New[Cursor](db, collection, selector, fields, options)
    }

  }

}
