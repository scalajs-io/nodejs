package com.github.ldaniels528.meansjs.nodejs.errors

import scala.scalajs.js
import scala.scalajs.js._
import scala.scalajs.js.annotation.JSName

/**
  * Node.js Error Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Error(message: String = "") extends js.Error(message) {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  //def message: String = js.native

  def stack: js.Any = js.native

}

/**
  * Error Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Error")
object Error extends ErrorClass {

  /**
    * Constructor
    * @example Error(message)
    */
  def apply(message: String = ""): Error = native

}