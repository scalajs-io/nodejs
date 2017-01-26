package io.scalajs.dom.html.phaser

import scala.scalajs.js

@js.native
trait Signal extends js.Object {

  def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

  def addOnce(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native

  def add(listener: js.ThisFunction0[_, _], listenerContext: Any, priority: Int, args: Any*): SignalBinding = js.native

  def add(listener: js.ThisFunction0[_, _], listenerContext: Any = this, priority: Int = 0): SignalBinding = js.native

}

