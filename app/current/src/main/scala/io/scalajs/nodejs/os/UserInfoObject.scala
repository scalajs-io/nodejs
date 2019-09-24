package io.scalajs.nodejs.os

import io.scalajs.nodejs.{GID, UID}

import scala.scalajs.js

/**
  * User Information Object
  * @example {{{ {"uid":501,"gid":20,"username":"ldaniels","homedir":"/Users/ldaniels","shell":"/bin/bash"} }}}
  */
class UserInfoObject(val uid: UID, val gid: GID, val username: String, val homedir: String, val shell: String)
    extends js.Object
