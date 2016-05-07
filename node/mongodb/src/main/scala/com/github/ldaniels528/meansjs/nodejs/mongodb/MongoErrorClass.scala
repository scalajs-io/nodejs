package com.github.ldaniels528.meansjs.nodejs.mongodb

import com.github.ldaniels528.meansjs.nodejs.errors.ErrorClass
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Mongo Error Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MongoErrorClass extends ErrorClass {

  /**
    * Creates a new MongoError object
    * @param options the error options
    * @return the [[MongoError]] instance
    */
  def create(options: js.Any): MongoError = js.native

}

/**
  * Mongo Error Class Companion
  * @author lawrence.daniels@gmail.com
  */
object MongoErrorClass {

  /**
    * Mongo Error Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class MongoErrorClassExtensions(val `class`: MongoErrorClass) extends AnyVal {

    /**
      * Constructor
      * @example MongoError(message)
      */
    @inline
    def apply(message: String) = `class`.New[MongoError](message)

  }

}