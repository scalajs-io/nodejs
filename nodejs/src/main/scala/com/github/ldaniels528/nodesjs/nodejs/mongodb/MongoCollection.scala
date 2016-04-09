package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.nodejs.mongodb.MongoClient.MongoError
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Collection
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait MongoCollection extends js.Object {

  def find(): MongoCursor

  def find(selector: js.Any): MongoCursor

  def findOne(selector: js.Any, callback: js.Function): Unit

  def insert(doc: js.Any): Unit

  def insert(doc: js.Any, callback: js.Function): Unit

  def insert(doc: js.Any, options: WriteOptions, callback: js.Function): Unit

  def insert(docs: js.Array[js.Object], options: WriteOptions, callback: js.Function): Unit

  def remove(): Unit

  def remove(selector: js.Any): Unit

  def remove(selector: js.Any, options: WriteOptions, callback: js.Function): Unit

  def update(selector: js.Any, modifier: js.Any, options: WriteOptions, callback: js.Function): Unit

}

/**
  * Mongo Collection Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoCollection {

  /**
    * Mongo Collection Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoCollectionEnrich(val coll: MongoCollection) extends AnyVal {

    def findAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[js.Object]]()
      coll.find().toArray((err: MongoError, items: js.Array[js.Object]) => {
        if (!isDefined(err)) promise.success(items)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def findOneAsync(selector: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      coll.findOne(selector, (err: MongoError, doc: js.Any) => {
        if (!isDefined(err)) promise.success(doc)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def insertAsync(doc: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.insert(doc, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def insertAsync(docs: js.Array[js.Object])(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.insert(docs, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def removeAsync(doc: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.remove(doc, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def updateAsync(selector: js.Any, modifier: js.Any)(implicit ec: ExecutionContext) = {
      val promise = Promise[WriteResult]()
      coll.update(selector, modifier, WriteOptions(w = 1), (err: MongoError, result: WriteResult) => {
        if (!isDefined(err)) promise.success(result)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}