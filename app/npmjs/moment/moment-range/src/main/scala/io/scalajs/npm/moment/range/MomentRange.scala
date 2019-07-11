package io.scalajs.npm.moment
package range

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * moment-range - Fancy date ranges for Moment.js.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MomentRange extends js.Object {

  def extendMoment(moment: Moment): Moment with Range = js.native

}

/**
  * Moment Range Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("moment-range", JSImport.Namespace)
object MomentRange extends MomentRange