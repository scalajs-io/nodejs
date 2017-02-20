package io.scalajs.nodejs.net

import scala.scalajs.js

/**
  * Server IP Address
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Address extends js.Object {
  var address: js.UndefOr[String] = js.native
  var family: js.UndefOr[String]  = js.native
  var port: js.UndefOr[Int]       = js.native
}
