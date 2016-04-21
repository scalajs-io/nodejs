package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Node Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeError extends js.Object {
  var message: String = js.native
  var code: String = js.native
}

/**
  * Node Error Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeError {

  /**
    * Node Error Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ErrorExtensions(val error: NodeError) extends AnyVal {

    /**
      * Creates a new Error instance
      * @param message the given error message
      * @return a new Error instance
      */
    def apply(message: String) = {
      error.New[NodeError](message)
    }

  }

}
