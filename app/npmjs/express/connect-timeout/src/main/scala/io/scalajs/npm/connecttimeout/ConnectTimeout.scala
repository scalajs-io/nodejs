package io.scalajs.npm.connecttimeout

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * connect-timeout - Times out a request in the Connect/Express application framework.
 * @see [[https://expressjs.com/en/resources/middleware/timeout.html]]
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait ConnectTimeout extends js.Object {

  /**
   * Returns middleware that times out in time milliseconds. time can also be a string accepted by the ms module. On timeout, req will emit "timeout".
   * @example timeout(time, [options])
   * @return middleware that times out in time milliseconds. time can also be a string accepted by the ms module. On timeout, req will emit "timeout".
   */
  def apply(time: String, options: js.Any = js.native): js.Any = js.native

}

/**
 * ConnectTimeout Singleton
 * @author lawrence.daniels@gmail.com
 */
@js.native
@JSImport("connect-timeout", JSImport.Namespace)
object ConnectTimeout extends ConnectTimeout