package org.scalajs.nodejs.moment
package timezone

import org.scalajs.nodejs.{NodeModule, NodeRequire}

import scala.scalajs.js

/**
  * moment-timezone - Parse and display dates in any timezone.
  * @see [[http://momentjs.com/timezone/]]
  * @version 0.5.5-2016f
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MomentTimezone extends NodeModule

/**
  * Moment Timezone Companion
  * @author lawrence.daniels@gmail.com
  */
object MomentTimezone {

  /**
    * Convenience method for retrieving the 'moment' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Moment instance
    */
  def apply()(implicit require: NodeRequire) = require[Moment]("moment-timezone")


}