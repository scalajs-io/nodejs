package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Signal
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Signal extends js.Object {

  def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

  def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native

  def add(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

  def add(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native

}
