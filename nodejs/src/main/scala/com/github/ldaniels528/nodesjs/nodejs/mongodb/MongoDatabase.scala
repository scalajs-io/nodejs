package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.nodejs.mongodb.MongoClient.MongoError
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait MongoDatabase extends js.Object {

  def admin(): MongoAdmin

  def close(): Unit

  def collection(name: String, callback: js.Function): Unit

  def collection(name: String, options: CollectionOptions, callback: js.Function): Unit

  def collectionsInfo(): MongoCursor

  def collectionNames(callback: js.Function): Unit

  def createCollection(name: String, callback: js.Function): Unit

  def createCollection(name: String, options: CollectionOptions, callback: js.Function): Unit

  def createIndex(name: String, flag: Char, callback: js.Function): Unit

  def dropCollection(name: String, callback: js.Function): Unit

  def dropDatabase(callback: js.Function): Unit

  def indexInformation(name: String, callback: js.Function): Unit

}

/**
  * Mongo Database Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoDatabase {

  /**
    * Mongo Database Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDatabaseEnrich(val db: MongoDatabase) extends AnyVal {

    def collectionAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.collection(name, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def collectionAsync(name: String, options: CollectionOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.collection(name, options, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def collectionNamesAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Array[String]]()
      db.collectionNames((err: MongoError, names: js.Array[String]) => {
        if (!isDefined(err)) promise.success(names) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def createCollectionAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.createCollection(name, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def createCollectionAsync(name: String, options: CollectionOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.createCollection(name, options, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def dropCollectionAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[OperationResult]()
      db.dropCollection(name, (err: MongoError, result: OperationResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def dropDatabaseAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[OperationResult]()
      db.dropDatabase((err: MongoError, result: OperationResult) => {
        if (!isDefined(err)) promise.success(result) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}
