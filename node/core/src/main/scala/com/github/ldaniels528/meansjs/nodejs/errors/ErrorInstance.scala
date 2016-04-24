package com.github.ldaniels528.meansjs.nodejs.errors

import scala.scalajs.js

/**
  * Node.js Error Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ErrorInstance extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def message: String = js.native
  def stack: js.Any

}
