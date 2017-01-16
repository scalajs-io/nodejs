package io.scalajs.nodejs.timer

import scala.scalajs.js

/**
  * The opaque value returned by setTimeout and setInterval also has the method timer.unref() which allows
  * the creation of a timer that is active but if it is the only item left in the event loop, it won't keep
  * the program running. If the timer is already unrefd calling unref again will have no effect.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait UnRef extends js.Object {

  /**
    * The opaque value returned by setTimeout and setInterval also has the method timer.unref() which allows
    * the creation of a timer that is active but if it is the only item left in the event loop, it won't keep
    * the program running. If the timer is already unrefd calling unref again will have no effect.
    *
    * In the case of setTimeout, unref creates a separate timer that will wakeup the event loop, creating too
    * many of these may adversely effect event loop performance -- use wisely.
    *
    * Returns the timer.
    * @example unref()
    */
  def unref(): Timer = js.native

}
