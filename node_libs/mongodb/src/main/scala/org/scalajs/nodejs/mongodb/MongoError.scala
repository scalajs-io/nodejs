package org.scalajs.nodejs.mongodb

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.errors.ErrorClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Mongo Error
  * @author lawrence.daniels@gmail.com
  * @see {{{ http://mongodb.github.io/node-mongodb-native/2.1/api/MongoError.html }}}
  */
@js.native
trait MongoError extends errors.Error

/**
  * Mongo Error Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("MongoError")
object MongoError extends ErrorClass {

  /**
    * Constructor
    * @example MongoError(message)
    */
  def apply(message: String): MongoError = js.native

  /**
    * Creates a new Mongo Error object
    * @param options the error options
    * @return the [[MongoError]] instance
    */
  def create(options: js.Any): MongoError = js.native

}