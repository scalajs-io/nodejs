package io.scalajs.npm.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Zookeeper Client Options
  * @param sessionTimeout Session timeout in milliseconds, defaults to 30 seconds.
  * @param spinDelay      The delay (in milliseconds) between each connection attempts.
  * @param retries        The number of retry attempts for connection loss exception.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ClientOptions(var sessionTimeout: js.UndefOr[Int] = js.undefined,
                    var spinDelay: js.UndefOr[Int] = js.undefined,
                    var retries: js.UndefOr[Int] = js.undefined) extends js.Object