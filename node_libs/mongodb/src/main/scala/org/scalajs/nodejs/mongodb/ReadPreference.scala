package org.scalajs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Read Preference
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReadPreference extends js.Object {
  val PRIMARY: String = js.native
  val PRIMARY_PREFERRED: String = js.native
  val SECONDARY: String = js.native
  val SECONDARY_PREFERRED: String = js.native
  val NEAREST: String = js.native

}

/**
  * Read Preference Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("ReadPreference")
object ReadPreference extends ReadPreference
