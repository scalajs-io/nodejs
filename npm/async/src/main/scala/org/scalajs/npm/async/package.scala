package org.scalajs.npm

import org.scalajs.nodejs.errors.Error

import scala.scalajs.js

/**
  * async package object
  * @author lawrence.daniels@gmail.com
  */
package object async {

  type AsyncErrorCallback = js.Function1[Error, Any]

  type AsyncResultCallback = js.Function

}
