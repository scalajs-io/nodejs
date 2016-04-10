package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * MongoDB Module for Node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoDB extends js.Object {

  def connect(servers: String, callback: js.Function): Unit

  def pure(): js.Dynamic // BSON

  def Binary: js.Dynamic

  def Code: js.Dynamic

  def Db: MongoDatabase

  def Grid: js.Dynamic

  def GridStore: MongoGridStore

  def MongoClient: MongoClient

  def ObjectID: ObjectID

  def ReplSetServers: js.Dynamic

  def Server: js.Dynamic

}

/**
  * MongoDB Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoDB {

  type MongoError = js.Any

  /**
    * MongoDB Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDBEnrich(val mongo: MongoDB) extends AnyVal {

    def connectAsync(servers: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[MongoDatabase]()
      mongo.connect(servers, (err: MongoError, conn: MongoDatabase) => {
        if (!isDefined(err)) promise.success(conn)
        else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

}