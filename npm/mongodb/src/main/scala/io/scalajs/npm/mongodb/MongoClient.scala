package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Mongo Client Module
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/contents.html]]
  */
@js.native
@JSImport("mongodb", "MongoClient")
class MongoClient() extends js.Object {

  def this(server: Server, options: MongoClientOptions) = this()

  /**
    * Close the current db connection, including all the child db instances.
    * Emits close event and calls optional callback.
    * @param callback the callback function
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Connect to MongoDB using a url
    * @param url      the given connection URL
    * @param callback the callback function
    */
  def connect(url: String, callback: js.Function2[MongoError, Db, Any]): Unit = js.native

  /**
    * Connect to MongoDB using a url
    * @param url      the given connection URL
    * @param options  the given [[ConnectionOptions options]]
    * @param callback the callback function
    */
  def connect(url: String, options: ConnectionOptions, callback: js.Function2[MongoError, Db, Any]): Unit = js.native

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
  def open(callback: js.Function): Unit = js.native

}

/**
  * Mongo Client Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("mongodb", "MongoClient")
object MongoClient extends MongoClientClass