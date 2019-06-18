package io.scalajs.npm.streamthrottle

import io.scalajs.nodejs.stream.Transform

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * ThrottleGroup allows the creation of a group of streams whose aggregate bandwidth is throttled.
  * The constructor accepts the same opts argument as for Throttle. Call throttle on a ThrottleGroup
  * object to create a new throttled stream belonging to the group.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("stream-throttle", "ThrottleGroup")
class ThrottleGroup(options: ThrottleOptions) extends js.Object {

  def throttle(): Transform = js.native

}