package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.nodejs.mongodb.MongoClient.MongoError
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Cursor
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoCursor extends js.Object {

  def stream(): MongoStream

  def toArray(callback: js.Function): Unit

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

    def streamAsync[T <: js.Any](f: T => Unit) {
      val mStream = cursor.stream()
      mStream.on("data", (item: T) => f(item))
      mStream.on("end", () => ())
    }

    def toArrayAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[T]]()
      cursor.toArray((err: MongoError, items: js.Array[T]) => {
        if (!isDefined(err)) promise.success(items)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}