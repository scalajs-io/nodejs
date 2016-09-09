package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Mongo Client Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoClientClass extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def connect(servers: String, callback: js.Function2[MongoError, Db, Any]): Unit = js.native

}

/**
  * Mongo Client Class Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoClientClass {

  /**
    * Mongo Client Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoClientClassExtensions(val `class`: MongoClientClass) extends AnyVal {

    @inline
    def apply() = `class`.New[MongoClient]()

    @inline
    def apply(server: Server, options: MongoClientOptions) = `class`.New[MongoClient](server, options)

    @inline
    def connectFuture(servers: String) = callbackMongoFuture[Db](`class`.connect(servers, _))

  }

}