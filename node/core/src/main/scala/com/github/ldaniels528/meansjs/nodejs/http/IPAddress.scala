package com.github.ldaniels528.meansjs.nodejs.http

import scala.scalajs.js

/**
  * Server IP Address
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait IPAddress extends js.Object {
  var address: js.UndefOr[String] = js.native
  var port: js.UndefOr[Int] = js.native
}
