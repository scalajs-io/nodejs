package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * minimist package object
  * @author lawrence.danils@gmail.com
  */
package object minimist {

  implicit def array2JSArray(values: Array[String]): js.Array[String] = values.toJSArray

}
