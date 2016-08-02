package org.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js require function
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NodeRequire extends js.Any {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  var cache: js.Dictionary[Module] = js.native
  var extensions: js.Dictionary[js.Function] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def apply[T](name: String): T = js.native

}

/**
  * NodeRequire Companion
  * @author lawrence.daniels@gmail.com
  */
object NodeRequire {

  @js.native
  @JSName("require")
  implicit object require extends NodeRequire

}