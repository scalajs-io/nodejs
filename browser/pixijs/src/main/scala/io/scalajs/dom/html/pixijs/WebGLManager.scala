package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("WebGLManager")
class WebGLManager(var renderer: WebGLRenderer) extends js.Object {

  /**
    * Generic destroy methods to be overridden by the subclass
    */
  def destroy(): Unit = js.native

  /**
    * Generic method called when there is a WebGL context change.
    */
  def onContextChange(callback: js.Function): Unit = js.native

}
