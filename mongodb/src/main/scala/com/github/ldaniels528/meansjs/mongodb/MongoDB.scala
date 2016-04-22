package com.github.ldaniels528.meansjs.mongodb

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * MongoDB Module for Node.js
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoDB extends NodeModule {

  def connect(servers: String, callback: js.Function): Unit = js.native

  def pure(): js.Dynamic = js.native // BSON

  def Binary: js.Dynamic = js.native

  def Code: js.Dynamic = js.native

  def Db: MongoDatabase = js.native

  def Grid: js.Dynamic = js.native

  def GridStore: MongoGridStore = js.native

  def MongoClient: MongoClient = js.native

  def ObjectID: ObjectID = js.native

  def ReplSetServers: js.Dynamic = js.native

  def Server: js.Dynamic = js.native

}

/**
  * MongoDB Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoDB {

  /**
    * MongoDB Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoDBEnrich(val mongo: MongoDB) extends AnyVal {

    def connectAsync(servers: String) = toFuture[MongoDatabase](mongo.connect(servers, _))

  }

}