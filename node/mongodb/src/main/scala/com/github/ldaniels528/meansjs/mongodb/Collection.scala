package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.ExecutionContext
import scala.scalajs.js

/**
  * Mongo Collection
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait Collection extends js.Object {

  def drop(callback: js.Function): Unit = js.native

  def find(): Cursor = js.native

  def find(selector: js.Any): Cursor = js.native

  def findOne(selector: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any): Unit = js.native

  def insert(doc: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def insert[T <: js.Any](docs: js.Array[T], options: WriteOptions, callback: js.Function): Unit = js.native

  def remove(): Unit = js.native

  def remove(selector: js.Any): Unit = js.native

  def remove(selector: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def update(selector: js.Any, modifier: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

}

/**
  * Mongo Collection Companion
  * @author lawrence.daniels@gmail.com
  */
object Collection {

  /**
    * Mongo Collection Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCollectionEnrich(val coll: Collection) extends AnyVal {

    @inline
    def dropAsync = callbackWithErrorToFuture[OperationResult](coll.drop)

    @inline
    def findAsync[T <: js.Any] = callbackWithErrorToFuture[js.Array[T]](coll.find().toArray)

    @inline
    def findAsync[T <: js.Any](selector: js.Any) = callbackWithErrorToFuture[js.Array[T]](coll.find(selector).toArray)

    @inline
    def findOneAsync[T <: js.Any](selector: js.Any)(implicit ec: ExecutionContext) = {
      callbackWithErrorToFuture[js.UndefOr[T]](coll.findOne(selector, _)) map(_.toOption.flatMap(Option(_)))
    }

    @inline
    def insertAsync[T <: js.Any](doc: T) = callbackWithErrorToFuture[WriteResult](coll.insert(doc, WriteOptions(w = 1), _))

    @inline
    def insertAsync[T <: js.Any](docs: js.Array[T]) = callbackWithErrorToFuture[WriteResult](coll.insert(docs, WriteOptions(w = 1), _))

    @inline
    def removeAsync(doc: js.Any) = callbackWithErrorToFuture[WriteResult](coll.remove(doc, WriteOptions(w = 1), _))

    @inline
    def updateAsync(selector: js.Any, modifier: js.Any) = callbackWithErrorToFuture[WriteResult](coll.update(selector, modifier, WriteOptions(w = 1), _))

  }

}