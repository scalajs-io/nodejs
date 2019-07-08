package io.scalajs.social

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * LinkedIn package object
  * @author lawrence.daniels@gmail.com
  */
package object linkedin {

  /**
    * LinkedIn service instance
    */
  @js.native
  @JSGlobal("IN")
  object IN extends LinkedIn

}
