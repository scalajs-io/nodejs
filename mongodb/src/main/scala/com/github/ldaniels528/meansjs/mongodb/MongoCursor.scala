package com.github.ldaniels528.meansjs.mongodb

import MongoDB.MongoError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
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
    * Mongo Cursor Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCursorEnrich(val cursor: MongoCursor) extends AnyVal {

    def eachAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[Option[T]]()
      cursor.each((err: MongoError, item: T) => {
        if (!isDefined(err)) promise.success(Option(item)) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def nextObjectAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[Option[T]]()
      cursor.toArray((err: MongoError, item: T) => {
        if (!isDefined(err)) promise.success(Option(item)) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def toArrayAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[T]]()
      cursor.toArray((err: MongoError, items: js.Array[T]) => {
        if (!isDefined(err)) promise.success(items) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}