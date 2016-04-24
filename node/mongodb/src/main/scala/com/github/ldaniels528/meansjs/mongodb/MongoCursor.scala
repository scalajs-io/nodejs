package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Cursor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoCursor extends js.Object {

  def each(callback: js.Function): Unit = js.native

  def nextObject(callback: js.Function): Unit = js.native

  def stream(): MongoStream = js.native

  def toArray(callback: js.Function): Unit = js.native

}

/**
  * Mongo Cursor Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoCursor {

  /**
    * Mongo Cursor Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCursorEnrich(val cursor: MongoCursor) extends AnyVal {

    def eachAsync[T <: js.Any] = toFuture[Option[T]](cursor.each)

    def nextObjectAsync[T <: js.Any] = toFuture[Option[T]](cursor.toArray)

    def toArrayAsync[T <: js.Any] = toFuture[js.Array[T]](cursor.toArray)

  }

}