package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
trait Db extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Server | ReplSet | Mongos  - Get the current db topology.
  var serverConfig: js.Any = js.native

  // Current bufferMaxEntries value for the database.
  var bufferMaxEntries: Int = js.native

  // The name of the database this instance represents.
  var databaseName: String = js.native

  // The options associated with the db instance.
  var options: js.Any = js.native

  // The current value of the parameter native_parser.
  var native_parser: Boolean = js.native

  // The current slaveOk value for the db instance.
  var slaveOk: Boolean = js.native

  // The current write concern values.
  var writeConcern: js.Any = js.native

  // Access the topology object (single server, replicaset or mongos).
  var topology: js.Any = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def admin(): MongoAdmin = js.native

  def close(): Unit = js.native

  def collection(name: String): Collection = js.native

  def collection(name: String, callback: js.Function): Unit = js.native

  def collection(name: String, options: CollectionOptions, callback: js.Function): Unit = js.native

  def collectionsInfo(): Cursor = js.native

  def collectionNames(callback: js.Function): Unit = js.native

  def createCollection(name: String, callback: js.Function): Unit = js.native

  def createCollection(name: String, options: CollectionOptions, callback: js.Function): Unit = js.native

  def createIndex(name: String, flag: Char, callback: js.Function): Unit = js.native

  def dropCollection(name: String, callback: js.Function): Unit = js.native

  def dropDatabase(callback: js.Function): Unit = js.native

  def indexInformation(name: String, callback: js.Function): Unit = js.native

  def open(callback: js.Function): Unit = js.native

}

/**
  * Mongo Database Companion
  * @author lawrence.daniels@gmail.com
  */
object Db {

  /**
    * Mongo Database Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDatabaseExtensions(val db: Db) extends AnyVal {

    @inline
    def collectionFuture(name: String) = callbackMongoFuture[Collection](db.collection(name, _))

    @inline
    def collectionFuture(name: String, options: CollectionOptions) = callbackMongoFuture[Collection](db.collection(name, options, _))

    @inline
    def collectionNamesAsync = callbackMongoFuture[js.Array[String]](db.collectionNames)

    @inline
    def createCollectionAsync(name: String) = callbackMongoFuture[Collection](db.createCollection(name, _))

    @inline
    def createCollectionAsync(name: String, options: CollectionOptions) = callbackMongoFuture[Collection](db.createCollection(name, options, _))

    @inline
    def dropCollectionAsync(name: String) = callbackMongoFuture[OperationResult](db.dropCollection(name, _))

    @inline
    def dropDatabaseAsync = callbackMongoFuture[OperationResult](db.dropDatabase)

  }

}
