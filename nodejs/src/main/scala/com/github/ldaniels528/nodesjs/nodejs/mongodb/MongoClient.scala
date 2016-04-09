package com.github.ldaniels528.nodesjs.nodejs.mongodb

import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Mongo Client Module
  * @author lawrence.daniels@gmail.com
  * @see [[https://mongodb.github.io/node-mongodb-native/api-bson-generated/objectid.html]]
  */
@js.native
trait MongoClient extends js.Object {

  def connect(servers: String, callback: js.Function): Unit

  def Db: MongoDatabase

  def GridStore: MongoGridStore

  def ObjectID: ObjectID

}

/**
  * Mongo Client Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoClient {

  type MongoError = js.Any

  /**
    * Mongo Client Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientEnrich(val client: MongoClient) extends AnyVal {

    def connectAsync(servers: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      client.connect(servers, (err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}