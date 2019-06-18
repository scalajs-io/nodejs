package io.scalajs.npm.mongodb

import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js

/**
  * Mongo Client Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoClientClass extends js.Object {

  def connect(url: String, callback: MongoCallback1[Db]): Unit = js.native

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
    def connectFuture(url: String): Future[Db] = promiseWithError1[MongoError, Db](`class`.connect(url, _))

  }

}