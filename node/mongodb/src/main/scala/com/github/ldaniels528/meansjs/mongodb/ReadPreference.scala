package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Read Preference
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("ReadPreference")
object ReadPreference extends js.Object {
  val PRIMARY: ReadPreference = js.native
  val PRIMARY_PREFERRED: ReadPreference = js.native
  val SECONDARY: ReadPreference = js.native
  val SECONDARY_PREFERRED: ReadPreference = js.native
  val NEAREST: ReadPreference = js.native

}
