package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.nodejs.mongodb.MongoClient.MongoError
import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoDatabase extends js.Object {

  def collection(name: String, callback: js.Function): Unit

  def collection(name: String, options: CollectionOptions, callback: js.Function): Unit

  def createCollection(name: String, callback: js.Function): Unit

  def createCollection(name: String, options: CollectionOptions, callback: js.Function): Unit

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
        if (!isDefined(err)) promise.success(coll)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def collectionAsync(name: String, options: CollectionOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.collection(name, options, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def createCollectionAsync(name: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.createCollection(name, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def createCollectionAsync(name: String, options: CollectionOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoCollection]()
      db.createCollection(name, options, (err: MongoError, coll: MongoCollection) => {
        if (!isDefined(err)) promise.success(coll)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}
