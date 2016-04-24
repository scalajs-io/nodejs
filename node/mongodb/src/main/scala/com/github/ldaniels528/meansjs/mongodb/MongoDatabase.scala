package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait MongoDatabase extends js.Object {

  def admin(): MongoAdmin = js.native

  def close(): Unit = js.native

  def collection(name: String, callback: js.Function): Unit = js.native

  def collection(name: String, options: CollectionOptions, callback: js.Function): Unit = js.native

  def collectionsInfo(): MongoCursor = js.native

  def collectionNames(callback: js.Function): Unit = js.native

  def createCollection(name: String, callback: js.Function): Unit = js.native

  def createCollection(name: String, options: CollectionOptions, callback: js.Function): Unit = js.native

  def createIndex(name: String, flag: Char, callback: js.Function): Unit = js.native

  def dropCollection(name: String, callback: js.Function): Unit = js.native

  def dropDatabase(callback: js.Function): Unit = js.native

  def indexInformation(name: String, callback: js.Function): Unit = js.native

}

/**
  * Mongo Database Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoDatabase {

  /**
    * Mongo Database Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDatabaseEnrich(val db: MongoDatabase) extends AnyVal {

    def collectionAsync(name: String) = toFuture[MongoCollection](db.collection(name, _))

    def collectionAsync(name: String, options: CollectionOptions) = toFuture[MongoCollection](db.collection(name, options, _))

    def collectionNamesAsync = toFuture[js.Array[String]](db.collectionNames)

    def createCollectionAsync(name: String) = toFuture[MongoCollection](db.createCollection(name, _))

    def createCollectionAsync(name: String, options: CollectionOptions) = toFuture[MongoCollection](db.createCollection(name, options, _))

    def dropCollectionAsync(name: String) = toFuture[OperationResult](db.dropCollection(name, _))

    def dropDatabaseAsync = toFuture[OperationResult](db.dropDatabase)

  }

}
