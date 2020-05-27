package io.scalajs.nodejs.os

import io.scalajs.nodejs.{GID, UID}
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

/**
  * User Information Object
  * @example {{{ {"uid":501,"gid":20,"username":"ldaniels","homedir":"/Users/ldaniels","shell":"/bin/bash"} }}}
  */
@Factory
trait UserInfoObject extends js.Object {
  var uid: UID
  var gid: GID
  var username: String
  var homedir: String
  var shell: String
}
