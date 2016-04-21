package com.github.ldaniels528.meansjs.zookeeper

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Zookeeper Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ZkOptions extends js.Object {
  var sessionTimeout: js.UndefOr[Int] = js.native
  var spinDelay: js.UndefOr[Int] = js.native
  var retries: js.UndefOr[Int] = js.native
}

/**
  * Zookeeper Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ZkOptions {

  def apply(sessionTimeout: js.UndefOr[Int] = js.undefined,
            spinDelay: js.UndefOr[Int] = js.undefined,
            retries: js.UndefOr[Int] = js.undefined) = {
    val options = makeNew[ZkOptions]
    options.sessionTimeout = sessionTimeout
    options.spinDelay = spinDelay
    options.retries = retries
    options
  }

}
