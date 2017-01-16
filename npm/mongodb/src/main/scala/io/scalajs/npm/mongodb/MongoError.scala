package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

/**
  * Mongo Error
  * @author lawrence.daniels@gmail.com
  * @see {{{ http://mongodb.github.io/node-mongodb-native/2.1/api/MongoError.html }}}
  */
@js.native
@JSImport("mongodb", "MongoError")
class MongoError(val message: String) extends js.Object

/**
  * Mongo Error Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("MongoError")
object MongoError extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Error.stackTraceLimit
    */
  def stackTraceLimit: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any): Unit = js.native

  /**
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any, constructorOpt: js.Any): Unit = js.native

  /**
    * Creates a new Mongo Error object
    * @param options the error options
    * @return the [[MongoError]] instance
    */
  def create(options: js.Any): MongoError = js.native

}