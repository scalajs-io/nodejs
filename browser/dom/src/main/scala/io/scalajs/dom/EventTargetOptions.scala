package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * An options object that specifies characteristics about the event listener.
  * The available options are:
  * @param capture        A Boolean that indicates that events of this type will be dispatched to the registered
  *                       listener before being dispatched to any EventTarget beneath it in the DOM tree.
  * @param once           A Boolean indicating that the listener should be invoked at most once after being added.
  *                       If it is true, the listener would be removed automatically when it is invoked.
  * @param passive        A Boolean indicating that the listener will never call preventDefault(). If it does,
  *                       the user agent should ignore it and generate a console warning.
  * @param mozSystemGroup Available only in code running in XBL or in Firefox's chrome, it is a Boolean defining
  *                       if the listener is added to the system group.
  */
@ScalaJSDefined
class EventTargetOptions(val capture: js.UndefOr[Boolean] = js.undefined,
                         val once: js.UndefOr[Boolean] = js.undefined,
                         val passive: js.UndefOr[Boolean] = js.undefined,
                         val mozSystemGroup: js.UndefOr[Boolean] = js.undefined) extends js.Object
