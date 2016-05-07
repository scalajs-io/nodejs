package com.github.ldaniels528.meansjs.nodejs.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Zookeeper Client Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ClientOptions extends js.Object {

  /**
    * Session timeout in milliseconds, defaults to 30 seconds.
    */
  var sessionTimeout: js.UndefOr[Int] = _

  /**
    * The delay (in milliseconds) between each connection attempts.
    */
  var spinDelay: js.UndefOr[Int] = _

  /**
    * The number of retry attempts for connection loss exception.
    */
  var retries: js.UndefOr[Int] = _

}

/**
  * Client Options
  * @author lawrence.daniels@gmail.com
  */
object ClientOptions {

  def apply(sessionTimeout: js.UndefOr[Int] = js.undefined,
            spinDelay: js.UndefOr[Int] = js.undefined,
            retries: js.UndefOr[Int] = js.undefined) = {
    val options = new ClientOptions()
    options.sessionTimeout = sessionTimeout
    options.spinDelay = spinDelay
    options.retries = retries
    options
  }

}
