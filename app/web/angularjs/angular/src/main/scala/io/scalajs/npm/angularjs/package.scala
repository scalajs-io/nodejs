package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Angularjs Package Object
  * @author lawrence.daniels@gmail.com
  */
package object angularjs {

  //////////////////////////////////////////////////////////////
  //    Globals
  //////////////////////////////////////////////////////////////

  /**
    * Singleton "angular" instance
    */
  @js.native
  @JSGlobal("angular")
  object angular extends Angular

}
