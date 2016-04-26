package com.github.ldaniels528.meansjs.zookeeper

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Zookeeper Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ZkOptions extends js.Object {
  var sessionTimeout: js.UndefOr[Int] = _
  var spinDelay: js.UndefOr[Int] = _
  var retries: js.UndefOr[Int] = _
}

/**
  * Zookeeper Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ZkOptions {

  def apply(sessionTimeout: js.UndefOr[Int] = js.undefined,
            spinDelay: js.UndefOr[Int] = js.undefined,
            retries: js.UndefOr[Int] = js.undefined) = {
    val options = new ZkOptions()
    options.sessionTimeout = sessionTimeout
    options.spinDelay = spinDelay
    options.retries = retries
    options
  }

}
