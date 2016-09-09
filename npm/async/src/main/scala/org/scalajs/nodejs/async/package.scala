package org.scalajs.nodejs

import scala.scalajs.js

/**
  * async package object
  * @author lawrence.daniels@gmail.com
  */
package object async {

  type AsyncErrorCallback = js.Function1[errors.Error, Any]

  type AsyncResultCallback = js.Function

}
