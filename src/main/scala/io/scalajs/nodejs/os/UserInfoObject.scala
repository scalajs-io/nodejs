package io.scalajs.nodejs.os

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * User Information Object
  * @example {{{ {"uid":501,"gid":20,"username":"ldaniels","homedir":"/Users/ldaniels","shell":"/bin/bash"} }}}
  */
@ScalaJSDefined
class UserInfoObject(val uid: Int, val gid: Int, val username: String, val homedir: String, val shell: String)
    extends js.Object
