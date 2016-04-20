package com.github.ldaniels528.meansjs.mongodb

import MongoDB.MongoError
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
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
  def connect(url: String, callback: js.Function): Unit = js.native

  /**
    * Connect to MongoDB using a url
    * @param url      the given connection URL
    * @param options  the given [[ConnectionOptions options]]
    * @param callback the callback function
    */
  def connect(url: String, options: ConnectionOptions, callback: js.Function): Unit = js.native

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

  def apply(config: ServerConfig, options: MongoClientOptions)(implicit mongo: MongoDB) = {
    mongo.MongoClient.New[MongoClient](config, options)
  }

  /**
    * Mongo Client Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientEnrich(val client: MongoClient) extends AnyVal {

    def closeAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      client.close((err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def connectAsync(url: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      client.connect(url, (err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def connectAsync(url: String, options: ConnectionOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      client.connect(url, options, (err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def openAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      client.open((err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}