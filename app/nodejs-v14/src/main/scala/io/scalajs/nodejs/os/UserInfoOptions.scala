package io.scalajs.nodejs.os

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait UserInfoOptions extends js.Object {
  var encoding: js.UndefOr[String] = js.undefined
  var username: js.UndefOr[String] = js.undefined
  var shell: js.UndefOr[String]    = js.undefined
  var homedir: js.UndefOr[String]  = js.undefined
}
