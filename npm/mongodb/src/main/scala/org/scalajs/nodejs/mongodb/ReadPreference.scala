package org.scalajs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Read Preference
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ReadPreference extends js.Object {
  val _type: String = js.native
  val mode: String = js.native
  val tags: js.Any = js.native
}

/**
  * Read Preference Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("ReadPreference")
object ReadPreference extends ReadPreferenceClass
