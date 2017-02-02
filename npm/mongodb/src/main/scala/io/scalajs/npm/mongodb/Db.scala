package io.scalajs.npm.mongodb

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{Array, |}

/**
  * Mongo Database
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-articles/nodekoarticle1.html]]
  */
@js.native
@JSImport("mongodb", "Db")
class Db(val databaseName: String, val replicaSet: ReplSet, val options: DbOptions) extends js.Object {

  def this() = this(null, null, null)

  def this(databaseName: String, server: Server) = this(databaseName, null, null)

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Server | ReplSet | Mongos  - Get the current db topology.
  var serverConfig: js.Any = js.native

  // Current bufferMaxEntries value for the database.
  var bufferMaxEntries: Int = js.native

  // The name of the database this instance represents.
  //var databaseName: String = js.native

  // The options associated with the db instance.
  //var options: js.Any = js.native

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

  def collection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

  def collectionsInfo(): Cursor = js.native

  def collectionNames(callback: js.Function): Unit = js.native

  def createCollection(name: String, callback: js.Function): Unit = js.native

  def createCollection(name: String, options: CollectionOptions | js.Any, callback: js.Function): Unit = js.native

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
    def collectionFuture(name: String, options: CollectionOptions | js.Any = null): Future[Collection] = {
      callbackMongoFuture[Collection](db.collection(name, options, _))
    }

    @inline
    def collectionNamesFuture: Future[Array[String]] = callbackMongoFuture[js.Array[String]](db.collectionNames)

    @inline
    def createCollectionFuture(name: String, options: CollectionOptions = null): Future[Collection] = {
      callbackMongoFuture[Collection](db.createCollection(name, options, _))
    }

    @inline
    def dropCollectionFuture(name: String): Future[OperationResult] =
      callbackMongoFuture[OperationResult](db.dropCollection(name, _))

    @inline
    def dropDatabaseFuture(): Future[OperationResult] = callbackMongoFuture[OperationResult](db.dropDatabase)

    @inline
    def openFuture(): Future[Db] = callbackMongoFuture[Db](db.open)

  }

}
