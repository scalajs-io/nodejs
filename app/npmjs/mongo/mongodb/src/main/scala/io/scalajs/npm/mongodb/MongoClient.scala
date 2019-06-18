package io.scalajs.npm.mongodb

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Mongo Client Module
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/contents.html]]
  */
@js.native
@JSImport("mongodb", "MongoClient")
class MongoClient() extends js.Object {

  /**
    * Constructor
    * @param server  the [[Server]]
    * @param options the [[MongoClientOptions options]]
    */
  def this(server: Server, options: MongoClientOptions | RawOptions) = this()

  /**
    * Close the current db connection, including all the child db instances.
    * Emits close event and calls optional callback.
    * @param callback the callback function
    */
  def close(callback: js.Function1[MongoError, Any] = js.native): js.Promise[Unit] = js.native

  /**
    * Connect to MongoDB using a url
    * @param url      the given connection URL
    * @param options  the given [[ConnectionOptions options]]
    * @param callback the callback function
    */
  def connect(url: String,
              options: ConnectionOptions | RawOptions = js.native,
              callback: MongoCallback1[Db] = js.native): js.Promise[Db] = js.native

  /**
    * Create a new Db instance sharing the current socket connections.
    * @param dbName the given database name
    * @return an [[MongoClient instance]] using the new database.
    */
  def db(dbName: String): MongoClient = js.native

  /**
    * Initializes the database connection
    * @param callback the callback function
    */
  def open(callback: MongoCallback1[Db] = js.native): js.Promise[Db] = js.native

}

/**
  * Mongo Client Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "MongoClient")
object MongoClient extends MongoClientClass

/**
  * MongoDB Client Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-generated/mongoclient.html#connect]]
  */

class MongoClientOptions(var w: js.UndefOr[js.Any] = js.undefined,
                         var wtimeout: js.UndefOr[Int] = js.undefined,
                         var fsync: js.UndefOr[Boolean] = js.undefined,
                         var j: js.UndefOr[Boolean] = js.undefined,
                         var readPreference: js.UndefOr[String] = js.undefined,
                         var native_parser: js.UndefOr[Boolean] = js.undefined,
                         var forceServerObjectId: js.UndefOr[Boolean] = js.undefined,
                         var pkFactory: js.UndefOr[js.Object] = js.undefined,
                         var serializeFunctions: js.UndefOr[Boolean] = js.undefined,
                         var raw: js.UndefOr[Boolean] = js.undefined,
                         var recordQueryStats: js.UndefOr[Boolean] = js.undefined,
                         var retryMiliSeconds: js.UndefOr[Int] = js.undefined,
                         var numberOfRetries: js.UndefOr[Int] = js.undefined,
                         var bufferMaxEntries: js.UndefOr[Int] = js.undefined) extends js.Object
