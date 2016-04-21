package com.github.ldaniels528.meansjs.mongodb

import MongoDB.MongoError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Collection
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait MongoCollection extends js.Object {

  def drop(callback: js.Function): Unit = js.native

  def find(): MongoCursor = js.native

  def find(selector: js.Any): MongoCursor = js.native

  def findOne(selector: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any): Unit = js.native

  def insert(doc: js.Any, callback: js.Function): Unit = js.native

  def insert(doc: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def insert(docs: js.Array[js.Any], options: WriteOptions, callback: js.Function): Unit = js.native

  def remove(): Unit = js.native

  def remove(selector: js.Any): Unit = js.native

  def remove(selector: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

  def update(selector: js.Any, modifier: js.Any, options: WriteOptions, callback: js.Function): Unit = js.native

}

/**
  * Mongo Collection Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoCollection {

  /**
    * Mongo Collection Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCollectionEnrich(val coll: MongoCollection) extends AnyVal {

    def dropAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[OperationResult]()
      coll.drop((err: MongoError, result: OperationResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def findAsync[T <: js.Any](implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[T]]()
      coll.find().toArray((err: MongoError, items: js.Array[T]) => {
        if (!isDefined(err)) promise.success(items) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def findAsync[T <: js.Any](selector: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[T]]()
      coll.find(selector).toArray((err: MongoError, items: js.Array[T]) => {
        if (!isDefined(err)) promise.success(items) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def findOneAsync[T <: js.Any](selector: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[Option[T]]()
      coll.findOne(selector, (err: MongoError, doc: T) => {
        if (!isDefined(err)) promise.success(Option(doc)) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def insertAsync(doc: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.insert(doc, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def insertAsync(docs: js.Array[js.Any])(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.insert(docs, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def removeAsync(doc: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.remove(doc, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def updateAsync(selector: js.Any, modifier: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.update(selector, modifier, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}