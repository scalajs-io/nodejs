package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js

/**
  * Mongo Client Module
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/contents.html]]
  */
@js.native
trait MongoClient extends js.Object {

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
object MongoClient {

  /**
    * Mongo Client Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientExtensions(val client: MongoClient) extends AnyVal {

    @inline
    def closeAsync = callbackMongoFuture[Db](client.close)

    @inline
    def connectAsync(url: String) = callbackMongoFuture[Db](client.connect(url, _))

    @inline
    def connectAsync(url: String, options: ConnectionOptions) = callbackMongoFuture[Db](client.connect(url, options, _))

    @inline
    def openAsync = callbackMongoFuture[Db](client.open)

  }

}